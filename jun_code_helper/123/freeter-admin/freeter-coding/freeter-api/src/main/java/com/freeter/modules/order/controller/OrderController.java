package com.freeter.modules.order.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.address.entity.AddressEntity;
import com.freeter.modules.address.service.AddressService;
import com.freeter.modules.cart.entity.CartEntity;
import com.freeter.modules.cart.service.CartService;
import com.freeter.modules.good.entity.*;
import com.freeter.modules.good.service.*;
import com.freeter.modules.order.entity.OrderEntity;
import com.freeter.modules.order.entity.OrderGoodEntity;
import com.freeter.modules.order.entity.model.OrderGoodModel;
import com.freeter.modules.order.entity.model.OrderModel;
import com.freeter.modules.order.entity.view.OrderSearch;
import com.freeter.modules.order.service.OrderGoodService;
import com.freeter.modules.order.service.OrderService;
import com.sun.org.apache.xpath.internal.SourceTree;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;


/**
 * 订单主表
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-28 15:57:37
 */
@RestController
@RequestMapping("order")
@Api(tags="订单主表接口")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderGoodService orderGoodService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private GoodSpecPriceService goodSpecPriceService;
    @Autowired
    private GoodSpecValueService goodSpecValueService;
    @Autowired
    private CategorySpecService categorySpecService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CartService cartService;


    /**
     * 提交订单
     */
    @PostMapping("add")
    @ApiOperation("提交订单")
    public R add(HttpServletRequest request,String userId){
        /**
         * 根据请求参数里面是否有cartId(购物车ID)然后判断该订单是否从购
         * 物车提交过来的，如果是从购物车提交过来的将购物车数据给删除掉
         */
        String[] cartIdArray=request.getParameterValues("cartId");
        if(cartIdArray!=null){
            for(int i=0;i<cartIdArray.length;i++){
                String cartId=cartIdArray[i];
                EntityWrapper<CartEntity> cartEntityWrapper=new EntityWrapper<CartEntity>();
                Wrapper<CartEntity> cartWrapper=cartEntityWrapper.eq("cart_id",cartId);
                cartService.delete(cartWrapper);
            }
        }
        String addressId=request.getParameter("addressId");
        //规格以及数量字符串
        //格式为：goodId：商品规格specStr：buyNumber
        String[] goodSpecStrNumberArray=request.getParameterValues("goodSpecStrNumber");
        //订单总金额
        BigDecimal orderTotalAmount=BigDecimal.valueOf(Double.valueOf(request.getParameter("totalAmount")));
        //备注
        String note=request.getParameter("note");
        //运费
        Double freight=Double.valueOf(request.getParameter("freight"));
        EntityWrapper<AddressEntity> addressEntityWrapper=new EntityWrapper<AddressEntity>();
        AddressEntity addressEntity=addressService.selectOne(addressEntityWrapper.eq("id",addressId));
        OrderEntity orderEntity=new OrderEntity();
        orderEntity.setAddress(addressEntity.getProvince()+addressEntity.getCity()+addressEntity.getArea()+addressEntity.getDetailedAddress());
        orderEntity.setConsignee(addressEntity.getPersonName());
        orderEntity.setCreatedTime(new Date());
        orderEntity.setPostcode(addressEntity.getPostcode());
        //新增订单的时候，设置订单状态为0
        orderEntity.setOrderStatus(0);
        orderEntity.setTel(addressEntity.getPersonTel());
        orderEntity.setTotalMoney(orderTotalAmount);
        orderEntity.setUserId(Integer.valueOf(userId));
        orderEntity.setFreight(freight);
        orderEntity.setNote(note);
        String orderNo=getOrderNo();
        orderEntity.setOrderNo(orderNo);
        System.out.println(orderEntity.getId());
        orderService.insert(orderEntity);
        for(int i=0;i<goodSpecStrNumberArray.length;i++){
            OrderGoodEntity orderGoodEntity=new OrderGoodEntity();
            String goodId=goodSpecStrNumberArray[i].split(":")[0];
            String spec=goodSpecStrNumberArray[i].split(":")[1];
            String buyNumber=goodSpecStrNumberArray[i].split(":")[2];
            EntityWrapper<GoodSpecPriceEntity> goodSpecPriceEntityWrapper=new EntityWrapper<GoodSpecPriceEntity>();
            Wrapper<GoodSpecPriceEntity> goodSpecPriceWrapper=goodSpecPriceEntityWrapper.eq("spec",spec);
            GoodSpecPriceEntity goodSpecPriceEntity=goodSpecPriceService.selectOne(goodSpecPriceWrapper);
            orderGoodEntity.setAmount(Integer.valueOf(buyNumber));
            orderGoodEntity.setGoodId(Integer.valueOf(goodId));
            orderGoodEntity.setOrderNo(orderNo);
            orderGoodEntity.setGoodSpecPriceId(goodSpecPriceEntity.getId());
            orderGoodService.insert(orderGoodEntity);
        }
        return R.ok("订单已添加");
    }


    /**
     * 删除订单
     */
    @PostMapping("delete")
    @ApiOperation("删除订单")
    public R delete(HttpServletRequest request){
        String[] orderIdArray=request.getParameterValues("orderId");
        for(int i=0;i<orderIdArray.length;i++){
            String orderId=orderIdArray[i];
            EntityWrapper<OrderEntity> orderEntityWrapper=new EntityWrapper<OrderEntity>();
            Wrapper<OrderEntity> orderWrapper=orderEntityWrapper.eq("id",orderId);
            OrderEntity orderEntity=orderService.selectOne(orderWrapper);
            orderEntity.setVirDel("1");
            orderService.updateAllColumnById(orderEntity);
        }
        return R.ok("订单已删除");
    }

    /**
     * 我的订单
     * @Param 用户id
     */
    @GetMapping("myOrder")
    @ApiOperation("我的订单")
    public R myOrder(String userId,String orderStatus){
        EntityWrapper<OrderEntity> entityWrapper=new EntityWrapper<OrderEntity>();
        Wrapper<OrderEntity> wrapper;
        //orderStatus是根据订单状态来查询，如果没有orderStatus请求参数表明查询的是全部订单
        if(orderStatus==null){
           wrapper=entityWrapper.eq("user_id",userId);
        }else{
            wrapper=entityWrapper.eq("user_id",userId).and().eq("order_status",orderStatus);
        }
        List<OrderEntity> myList=orderService.selectList(wrapper);
        Iterator myListIt=myList.iterator();
        List<OrderModel> orderModelList=new ArrayList<OrderModel>();
        while(myListIt.hasNext()){
            OrderModel orderModel=new OrderModel();
            OrderEntity orderEntity=(OrderEntity) myListIt.next();
            orderModel.setTotalAmount(orderEntity.getTotalMoney());
            orderModel.setUserId(Integer.valueOf(userId));
            orderModel.setOrderStatus(orderEntity.getOrderStatus().toString());
            String orderNo=orderEntity.getOrderNo();
            EntityWrapper<OrderGoodEntity> orderGoodEntityWrapper=new EntityWrapper<OrderGoodEntity>();
            Wrapper<OrderGoodEntity> orderGoodWrapper=orderGoodEntityWrapper.eq("order_no",orderNo);
            List<OrderGoodEntity> orderGoodEntityList=orderGoodService.selectList(orderGoodWrapper);
            Iterator<OrderGoodEntity> orderGoodEntityIterator=orderGoodEntityList.iterator();
            List<OrderGoodModel> orderGoodModelList=new ArrayList<OrderGoodModel>();
            //goodCount 订单商品的总数量
            int goodCount=0;
            while(orderGoodEntityIterator.hasNext()){
                OrderGoodEntity orderGoodEntity=orderGoodEntityIterator.next();
                goodCount+=orderGoodEntity.getAmount();
                Integer goodId=orderGoodEntity.getGoodId();
                Wrapper<GoodEntity> goodWrapper=new EntityWrapper<GoodEntity>().eq("good_id",goodId);
                GoodEntity goodEntity=goodService.selectOne(goodWrapper);
                OrderGoodModel orderGoodModel=new OrderGoodModel();
                orderGoodModel.setGoodTitle(goodEntity.getPageTitle());
                orderGoodModel.setGoodImg(goodEntity.getPicImg());
                orderGoodModel.setGoodCount(orderGoodEntity.getAmount());
                orderGoodModel.setGoodId(goodEntity.getGoodId());
                Integer goodSpecPriceId=orderGoodEntity.getGoodSpecPriceId();
                Wrapper<GoodSpecPriceEntity> goodSpecPriceWrapper=new EntityWrapper<GoodSpecPriceEntity>().eq("id",goodSpecPriceId);
                GoodSpecPriceEntity goodSpecPriceEntity=goodSpecPriceService.selectOne(goodSpecPriceWrapper);
                String spec=goodSpecPriceEntity.getSpec();
                String[] specArray=spec.split(",");
                List<Map> specNameValueList=new ArrayList<Map>();
                for(int i=0;i<specArray.length;i++){
                    Map specMap=new HashMap();
                    String goodSpecValueId=specArray[i];
                    Wrapper<GoodSpecValueEntity> goodSpecValueWrapper=new EntityWrapper<GoodSpecValueEntity>().eq("id",goodSpecValueId);
                    GoodSpecValueEntity goodSpecValueEntity=goodSpecValueService.selectOne(goodSpecValueWrapper);
                    Integer categorySpecId=goodSpecValueEntity.getCategorySpecId();
                    Wrapper<CategorySpecEntity> categorySpecWrapper=new EntityWrapper<CategorySpecEntity>().eq("id",categorySpecId);
                    String specName=categorySpecService.selectOne(categorySpecWrapper).getSpecName();
                    specMap.put("specName",specName);
                    specMap.put("specValue",goodSpecValueEntity.getSpecValue());
                    specNameValueList.add(specMap);
                }
                orderGoodModel.setGoodSpec(specNameValueList);
                orderGoodModelList.add(orderGoodModel);
            }
            orderModel.setOrderGoodModelList(orderGoodModelList);
            orderModel.setGoodCount(goodCount);
            orderModelList.add(orderModel);
        }
        return R.ok().put("data",orderModelList);
    }


    /**
     * 生成订单id
     * 格式为：yyyyMMdd+5位的随机小写字母加数字组合
     * @return
     */
    public static String getOrderNo(){
        Date date=new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddhhmmss");
        String dateString=sdf.format(date);
        char[] charArray=new char[]{
             '0' ,'1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n',
                'o','p','q','r','s','t','u','v','w','x','y','z'
        };
        Random random=new Random();
        int[] indexArray=new int[]{
                random.nextInt(36),random.nextInt(36),random.nextInt(36),random.nextInt(36),random.nextInt(36)
        };
        char[] generateArray=new char[5];
        for(int i=0;i<indexArray.length;i++){
            generateArray[i]=charArray[indexArray[i]];
        }
        return dateString+new String(generateArray);
    }

}
