package com.freeter.modules.good.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.GoodAttributeEntity;
import com.freeter.modules.good.entity.GoodEntity;
import com.freeter.modules.good.entity.GoodImageEntity;
import com.freeter.modules.good.entity.model.GoodModel;
import com.freeter.modules.good.entity.model.GoodOrderByModel;
import com.freeter.modules.good.entity.vo.GoodAttributeVO;
import com.freeter.modules.good.entity.vo.GoodVO;
import com.freeter.modules.good.service.GoodAttributeService;
import com.freeter.modules.good.service.GoodDetailService;
import com.freeter.modules.good.service.GoodImageService;
import com.freeter.modules.good.service.GoodService;

import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 商品表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:00
 */
@RestController
@RequestMapping("good")
@Api(tags="商品表接口")
public class GoodController {
    @Autowired
    private GoodService goodService;
 
    @Autowired
    private GoodAttributeService goodAttributeService;
 
    @Autowired
    private GoodDetailService goodDetailService;
     
    @Autowired
    private GoodImageService goodImageService;
 
    
    
    /**
     * 
     * 获取商品搜索页
     */
    @GetMapping("/getGoodSearch")
    @ApiOperation("商品搜索页")
    public R getGoodSearch(GoodOrderByModel good){
    	
    	Assert.notEmpty(BeanUtil.beanToMap(good, false, true), "数据不能都为空");
        EntityWrapper< GoodEntity> ew = new EntityWrapper< GoodEntity>();
        Map params = new HashMap();
		params.put("category.category_id", good.getCategoryId());
 		ew.like("good.good_name", good.getSearch());
		ew.or();
		ew.like("good.page_keyword", good.getSearch());
		ew.or();
		ew.like("category.name", good.getSearch());
		if(good.getCategoryId()!= null) {
			ew.andNew();
			ew.allEq(params);
		}
		if("sale".equals(good.getOrderBy())) {
			ew.orderBy("attr.sales_volume");
		}
		if("price".equals(good.getOrderBy())) {
			ew.orderBy("good.min_price");
		}
		List<GoodVO>  goodVO= goodService.selectGoodAndGoodAttr(ew);
		return R.ok("查询商品表成功").put("data",R.toMap("good",goodVO));
    }
    
    
    
    
    
    /**
     * 
     * 获取商品详情页
     */
    @GetMapping("/getGoodDetail")
    @ApiOperation("商品详情页")
    public R getGoodDetail(Integer goodId){
    	Assert.notNull(goodId, "商品ID不能为空");
        EntityWrapper< GoodEntity> ew = new EntityWrapper< GoodEntity>();
		GoodEntity good = new  GoodEntity();
		ew.eq("good_id", goodId);
		GoodVO goodVO = goodService.selectVO(ew);
		EntityWrapper<GoodAttributeEntity> gew = new EntityWrapper<GoodAttributeEntity>();
		gew.eq("good_id", goodId);

		GoodAttributeVO gavo = goodAttributeService.selectVO(gew);
		EntityWrapper<GoodImageEntity> giew = new EntityWrapper<GoodImageEntity>();
		GoodImageEntity goodImageEntity = new GoodImageEntity();
		giew.eq("good_id", goodId);
		 List givo =goodImageService.selectListVO(giew);
		return R.ok("获取商品详情成功").put("data",R.toMap("good",goodVO).put("goodAttr", gavo).put("image",givo));
    }
    
    
    
    
    /**
     * 
     * 查询
     */
    @GetMapping("/getGood")
    @ApiOperation("查询商品表")
    public R getGood(Integer goodId){
    	Assert.notNull(goodId, "商品ID不能为空");
        EntityWrapper< GoodEntity> ew = new EntityWrapper< GoodEntity>();
		GoodEntity good = new  GoodEntity();
		good.setGoodId(goodId);
		ew.eq("good_id", goodId);
		GoodVO goodVO = goodService.selectVO(ew);
		return R.ok("查询商品表成功").put("data",goodVO);
    }
    

    /**
     * 查询
     */
    @GetMapping("/search")
    @ApiOperation("查询商品表")
    public R search(GoodModel goodModel){
		ValidatorUtils.validateEntity(goodModel);
        EntityWrapper< GoodEntity> ew = new EntityWrapper< GoodEntity>();
		GoodEntity good = new  GoodEntity( goodModel);
		ew.setEntity(good);
		goodService.selectList(ew);
		return R.ok("查询商品表成功").put("data",goodService.selectList(ew));
    }

	

    /**
     * 信息
     */
    @GetMapping("/info/{goodId}")
    @ApiOperation("获取相应的商品表")
    public R info(@PathVariable("goodId") Integer goodId){
        GoodEntity good = goodService.selectById(goodId);
        return R.ok().put("good", good);
    }






}
