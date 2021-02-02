package com.freeter.modules.order.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.freeter.common.utils.MPUtil;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.CategorySpecEntity;
import com.freeter.modules.good.entity.GoodEntity;
import com.freeter.modules.good.entity.GoodSpecPriceEntity;
import com.freeter.modules.good.entity.GoodSpecValueEntity;
import com.freeter.modules.good.service.CategorySpecService;
import com.freeter.modules.good.service.GoodService;
import com.freeter.modules.good.service.GoodSpecPriceService;
import com.freeter.modules.good.service.GoodSpecValueService;
import com.freeter.modules.order.entity.OrderEntity;
import com.freeter.modules.order.entity.OrderGoodEntity;
import com.freeter.modules.order.entity.model.OrderGoodModel;
import com.freeter.modules.order.entity.model.OrderModel;
import com.freeter.modules.order.service.OrderGoodService;
import com.freeter.modules.order.service.OrderService;
import com.freeter.modules.sys.controller.AbstractController;
import com.freeter.modules.sys.entity.SysUserEntity;
import com.freeter.modules.user.entity.UserEntity;
import com.freeter.modules.user.service.UserService;

import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * 订单主表
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-28 15:57:37
 */
@RestController
@RequestMapping("/order")
@Api(tags="订单主表接口")
public class OrderController  extends AbstractController {
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
    private UserService userService;


    /**
     * 订单列表
     * @Param orderStatus订单状态
     *        consignee 收货人姓名
     */
    @RequestMapping("/orderList")
    @ApiOperation("订单列表")
    public R orderList(@RequestParam Map<String, Object> params){
        PageUtils page=orderService.queryPage(params);
        /*List<OrderEntity> orderEntityList=(List<OrderEntity>) page.getList();
        List<OrderModel> orderModelList=getOrderModelList(orderEntityList);
        page.setList(orderModelList);*/
        return R.ok().put("page",page);
    }

    /**
     * 获取订单信息
     */
    @RequestMapping("/info/{orderId}")
    @ApiOperation("获取订单信息")
    public R info(@PathVariable("orderId") String orderId){
        OrderEntity orderEntity=orderService.selectById(orderId);
        OrderModel orderModel=new OrderModel();
        orderModel.setOrderId(orderEntity.getId());
         orderModel.setTotalAmount(orderEntity.getTotalMoney());
        orderModel.setConsignee(orderEntity.getConsignee());
        orderModel.setStrCreatedTime(new SimpleDateFormat("yyyyMMdd hh:mm:ss").format(orderEntity.getCreatedTime()));
        orderModel.setPostCode(orderEntity.getPostcode());
        orderModel.setExpressCompanyName(orderEntity.getExpressCompanyName());
        orderModel.setExpressCompanyNo(orderEntity.getExpressCompanyNo());
        orderModel.setExpressNumber(orderEntity.getExpressNumber());
        orderModel.setOrderNo(orderEntity.getOrderNo());
        orderModel.setTel(orderEntity.getTel());
        orderModel.setOrderId(orderEntity.getId());
        Integer orderStatus=orderEntity.getOrderStatus();
        orderModel.setUserId(orderEntity.getUserId());

        switch(orderStatus){
            case 0:
                orderModel.setOrderStatus("待支付");
                break;
            case 1:
                orderModel.setOrderStatus("待支付关闭");
                break;
            case 2:
                orderModel.setOrderStatus("待发货");
                break;
            case 3:
                orderModel.setOrderStatus("待收货");
                break;
            case 4:
                orderModel.setOrderStatus("已收货");
                break;
            case 5:
                orderModel.setOrderStatus("待评价");
                break;
            case 6:
                orderModel.setOrderStatus("申请退款");
                break;
            case 7:
                orderModel.setOrderStatus("退款完成");
                break;
            case 8:
                orderModel.setOrderStatus("已完成订单");
                break;
        }

        orderModel.setUserName("11111");



        return R.ok().put("orderModel",orderModel);
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
            orderEntity.setVirDel(1);
            orderService.updateAllColumnById(orderEntity);
        }
        return R.ok("订单已删除");
    }

    /**
     * 保存
     */
    @RequestMapping("/update")
    @ApiOperation("修改订单")
    public R update(@RequestBody OrderModel  orderModel) throws ParseException{
        //校验类型
        ValidatorUtils.validateEntity(orderModel);
        System.out.println(orderModel.getPostCode());
        OrderEntity orderEntity=new OrderEntity(orderModel);
        orderEntity.setTotalMoney(orderModel.getTotalAmount());
        orderEntity.setId(orderModel.getOrderId());
        orderEntity.setCreatedTime(new SimpleDateFormat("yyyyMMdd hh:mm:ss").parse(orderModel.getStrCreatedTime()));
        orderService.updateAllColumnById(orderEntity);
        return R.ok("更新成功");
    }

    /**
     * 获取订单商品
     */
    @RequestMapping("/good/{orderId}")
    @ApiOperation("获取订单商品")
    public R getOrderGood(@PathVariable("orderId") Integer orderId){
        OrderEntity orderEntity=orderService.selectById(orderId);
        Page page=new Page();
        EntityWrapper<OrderGoodEntity> orderGoodEntityWrapper=new EntityWrapper<OrderGoodEntity>();
        List<OrderGoodEntity> orderGoodEntityList=orderGoodService.selectList(orderGoodEntityWrapper.eq("order_no",orderEntity.getOrderNo()));
        Iterator orderGoodEntityListIt=orderGoodEntityList.iterator();
        List<OrderGoodModel> orderGoodModelList=new ArrayList<>();
        while(orderGoodEntityListIt.hasNext()){
            OrderGoodModel orderGoodModel=new OrderGoodModel();
            OrderGoodEntity orderGoodEntity=(OrderGoodEntity) orderGoodEntityListIt.next();
            Integer goodSpecPriceId=orderGoodEntity.getGoodSpecPriceId();
            Integer goodId=orderGoodEntity.getGoodId();
            GoodEntity goodEntity=goodService.selectById(goodId);
            //如果规格重置 那么 订单表的商品价格规格id不存在
            GoodSpecPriceEntity goodSpecPriceEntity=goodSpecPriceService.selectById(goodSpecPriceId);
            String spec=goodSpecPriceEntity.getSpec();
            String[]  goodSpecValueIdArray=spec.split(",");
            StringBuilder goodSpecStr=new StringBuilder();
            for(int i=0;i<goodSpecValueIdArray.length;i++){
                GoodSpecValueEntity goodSpecValueEntity=goodSpecValueService.selectById(goodSpecValueIdArray[i]);
                Integer categorySpecId=goodSpecValueEntity.getCategorySpecId();
                CategorySpecEntity categorySpecEntity=categorySpecService.selectById(categorySpecId);
                goodSpecStr.append(categorySpecEntity.getSpecName()).append(":").append(goodSpecValueEntity.getSpecValue()).append("   ");
            }
            orderGoodModel.setGoodId(goodId);
            orderGoodModel.setGoodName(goodEntity.getGoodName());
            orderGoodModel.setUnitPrice(goodSpecPriceEntity.getPrice());
            orderGoodModel.setGoodCount(orderGoodEntity.getAmount());
            orderGoodModel.setGoodSpec(goodSpecStr.toString());
            orderGoodModelList.add(orderGoodModel);
        }
        page.setRecords(orderGoodModelList);
        return R.ok().put("page",new PageUtils(page));
    }


    /**
     * 订单查询列表
     */
    @RequestMapping("/orderSelectList")
    @ApiOperation("订单查询列表")
    public R orderSelectList(@RequestParam Map<String, Object> params){
        String selectType=(String)params.get("selectType");
        String selectValue=(String)params.get("selectValue");
        EntityWrapper<OrderEntity> orderEntityWrapper=new EntityWrapper<OrderEntity>();
        if("userName".equals(selectType)) {
        	EntityWrapper<UserEntity> userEntityWrapper=new EntityWrapper<UserEntity>();
           List<Object> listUserIds=userService.selectObjs(userEntityWrapper.like("user_name", selectValue));
           orderEntityWrapper.in("user.user_id", listUserIds);
        }else {   	
        	orderEntityWrapper.like(MPUtil.camelToUnderline(selectType), selectValue);
        }     
       orderEntityWrapper.eq("order_status","2");
       PageUtils pageUtils= orderService.queryPage(params, orderEntityWrapper);
        return R.ok().put("page",pageUtils);

    }

    /**
     * 发货
     */
    @RequestMapping("delivery")
    @ApiOperation("订单发货")
    public R delivery(String expressType,String orderId,String expressNumber,String expressCompanyNo,String expressCompanyName,String deliveryPersonTel){
        OrderEntity orderEntity=orderService.selectById(orderId);
        //自主配送
        if(("myself".equals(expressType))){
            orderEntity.setExpressType(0);
            orderEntity.setDeliveryPersonTel(deliveryPersonTel);
            orderService.updateAllColumnById(orderEntity);
            SysUserEntity user=getUser();
            orderEntity.setConsignorId(user.getUserId().intValue());
            orderEntity.setOrderStatus(3);
            orderEntity.setDeliveryTime(new Date());
            orderService.updateAllColumnById(orderEntity);
        }else{
            orderEntity.setExpressType(1);
            orderEntity.setExpressNumber(expressNumber);
            orderEntity.setExpressCompanyNo(expressCompanyNo);
            orderEntity.setExpressCompanyName(expressCompanyName);
            SysUserEntity user=getUser();
            orderEntity.setConsignorId(user.getUserId().intValue());
            orderEntity.setOrderStatus(3);
            orderEntity.setDeliveryTime(new Date());
            orderService.updateAllColumnById(orderEntity);
        }
        return R.ok("发货成功");


    }

    /**
     * 我的订单
     */
    @RequestMapping("myOrderList")
    @ApiOperation("我的订单")
    public R myOrderList(@RequestParam  Map<String, Object> params,OrderEntity orderEntity){

        String selectType=(String)params.get("selectType");
        String selectValue=(String)params.get("selectValue");
        EntityWrapper<OrderEntity> orderEntityWrapper=new EntityWrapper<OrderEntity>();
         if("userName".equals(selectType)) {
        	EntityWrapper<UserEntity> userEntityWrapper=new EntityWrapper<UserEntity>();
           List<Object> listUserIds=userService.selectObjs(userEntityWrapper.like("user_name", selectValue));
           orderEntityWrapper.in("user.user_id", listUserIds);
        }else {   	
        	orderEntityWrapper.like(MPUtil.camelToUnderline(selectType), selectValue);
        }    
      orderEntityWrapper.eq("consignor_id",getUserId());
      orderEntityWrapper.allEq(BeanUtil.beanToMap(orderEntity, true, true));
      PageUtils pageUtils= orderService.queryPage(params, orderEntityWrapper);
      return R.ok().put("page",pageUtils);

    }

   
}
