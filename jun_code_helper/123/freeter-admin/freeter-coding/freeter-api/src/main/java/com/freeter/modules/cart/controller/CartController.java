package com.freeter.modules.cart.controller;

import java.util.*;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.cart.entity.CartEntity;
import com.freeter.modules.cart.entity.model.CartModel;
import com.freeter.modules.cart.entity.view.CartSearch;
import com.freeter.modules.cart.entity.view.CartView;
import com.freeter.modules.cart.service.CartService;
import com.freeter.modules.good.entity.CategorySpecEntity;
import com.freeter.modules.good.entity.GoodEntity;
import com.freeter.modules.good.entity.GoodSpecPriceEntity;
import com.freeter.modules.good.entity.GoodSpecValueEntity;
import com.freeter.modules.good.service.CategorySpecService;
import com.freeter.modules.good.service.GoodService;
import com.freeter.modules.good.service.GoodSpecPriceService;
import com.freeter.modules.good.service.GoodSpecValueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;


/**
 * 购物车
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-29 09:47:58
 */
@RestController
@RequestMapping("cart")
@Api(tags="购物车接口")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private GoodSpecPriceService goodSpecPriceService;
    @Autowired
    private GoodSpecValueService goodSpecValueService;
    @Autowired
    private CategorySpecService categorySpecService;
    @Autowired
    private GoodService goodService;
 
	

    /**
     * 加入购物车
     */
    @PostMapping("/add")
    @ApiOperation("加入购物车")
    public R addCart(HttpServletRequest request,String userId){
        CartEntity cartEntity=new CartEntity();
        Integer goodId=Integer.valueOf(request.getParameter("goodId"));
        Integer buyNumber=Integer.valueOf(request.getParameter("buyNumber"));
        String specStr=request.getParameter("specStr");
        EntityWrapper<GoodSpecPriceEntity> goodSpecPriceEntityWrapper=new EntityWrapper<GoodSpecPriceEntity>();
        Wrapper<GoodSpecPriceEntity> goodSpecPriceWrapper=goodSpecPriceEntityWrapper.eq("spec",specStr);
        GoodSpecPriceEntity goodSpecPriceEntity=goodSpecPriceService.selectOne(goodSpecPriceWrapper);
        Integer goodSpecPriceId=goodSpecPriceEntity.getId();
        cartEntity.setBuyNumber(buyNumber);
        cartEntity.setGoodSpecPriceId(goodSpecPriceId);
        cartEntity.setUserId(Integer.valueOf(userId));
        cartEntity.setCreateTime(new Date());
        cartService.insert(cartEntity);
        return R.ok("添加购物车成功");
    }


    /**
     * 修改购物车
     */
    @PostMapping("/modifyBySpec")
    @ApiOperation("修改购物车")
    public R modifyCart(HttpServletRequest request){
        //修改类型  购物车修改一般只能修改规格和购买数量 0 ：规格 1：数量
        String type=request.getParameter("type");
        Integer cartId=Integer.valueOf(request.getParameter("cartId"));
        CartEntity cartEntity=cartService.selectById(cartId);
        if("0".equals(type)){
            String specStr=request.getParameter("specStr");
            EntityWrapper<GoodSpecPriceEntity> goodSpecPriceEntityWrapper=new EntityWrapper<GoodSpecPriceEntity>();
            Wrapper<GoodSpecPriceEntity> goodSpecPriceWrapper=goodSpecPriceEntityWrapper.eq("spec",specStr);
            GoodSpecPriceEntity goodSpecPriceEntity=goodSpecPriceService.selectOne(goodSpecPriceWrapper);
            cartEntity.setUpdateTime(new Date());
            cartEntity.setGoodSpecPriceId(goodSpecPriceEntity.getId());
            cartService.updateAllColumnById(cartEntity);
        }else{
            Integer buyNumber=Integer.valueOf(request.getParameter("buyNumber"));
            cartEntity.setBuyNumber(buyNumber);
            cartEntity.setUpdateTime(new Date());
            cartService.updateAllColumnById(cartEntity);
        }
        return R.ok("购物车已修改");

    }


    /**
     * 删除购物车(id删除)
     */
    @PostMapping("deleteById")
    @ApiOperation("删除购物车")
    public R deleteById(HttpServletRequest request){
        String[] cartIdArray=request.getParameterValues("cartId");
        List cartIdList=Arrays.asList(cartIdArray);
        cartService.deleteBatchIds(cartIdList);
        return R.ok("购物车已删除");

    }

    /**
     * 清空购物车
     */
    @PostMapping("emptyCart")
    @ApiOperation("清空购物车")
    public R emptyCart(String userId){
        EntityWrapper<CartEntity> cartEntityWrapper =new EntityWrapper<CartEntity>();
        Wrapper<CartEntity> cartWrapper=cartEntityWrapper.eq("user_id",userId);
        cartService.delete(cartWrapper);
        return  R.ok("购物车已清空");
    }




    /**
     * 我的购物车
     * @Param userId 用户id
     */
    @GetMapping("/myCart")
    @ApiOperation("我的购物车")
    public R myCart(String userId){
        EntityWrapper<CartEntity> entityWrapper=new EntityWrapper<CartEntity>();
        Wrapper<CartEntity> wrapper=entityWrapper.eq("user_id", userId);
        List<CartEntity> cartEntityList=cartService.selectList(wrapper);
        Iterator cartEntityListIt=cartEntityList.iterator();
        List<CartModel> cartModelList=new ArrayList<CartModel>();
        while(cartEntityListIt.hasNext()){
            CartModel cartModel=new CartModel();
            CartEntity cartEntity=(CartEntity) cartEntityListIt.next();
            String goodSpecPriceId=cartEntity.getGoodSpecPriceId().toString();
            EntityWrapper<GoodSpecPriceEntity> goodSpecPriceEntityWrapper=new EntityWrapper<GoodSpecPriceEntity>();
            Wrapper<GoodSpecPriceEntity> goodSpecPriceWrapper=goodSpecPriceEntityWrapper.eq("id",goodSpecPriceId);
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
            Integer goodId=goodSpecPriceEntity.getGoodId();
            GoodEntity goodEntity=goodService.selectOne(new EntityWrapper<GoodEntity>().eq("good_id",goodId));
            cartModel.setGoodCount(cartEntity.getBuyNumber());
            cartModel.setGoodSpec(specNameValueList);
            cartModel.setGoodTitle(goodEntity.getPageTitle());
            cartModel.setGoodImg(goodEntity.getPicImg());
            cartModel.setMerchantsId(goodEntity.getMartId().intValue());
            cartModel.setCartId(cartEntity.getCartId());
            cartModel.setGoodUnitPrice(goodSpecPriceEntity.getPrice().doubleValue());
            cartModel.setGoodId(goodEntity.getGoodId());
            Double  totalAmount=goodSpecPriceEntity.getPrice().doubleValue()*cartEntity.getBuyNumber();
            cartModel.setTotalAmount(totalAmount);
            cartModelList.add(cartModel);
        }
        return R.ok().put("data",cartModelList);

    }

}
