package com.freeter.modules.good.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.GoodAttributeEntity;
import com.freeter.modules.good.entity.GoodEntity;
import com.freeter.modules.good.entity.GoodSpecPriceEntity;
import com.freeter.modules.good.service.GoodAttributeService;
import com.freeter.modules.good.service.GoodService;
import com.freeter.modules.good.service.GoodSpecPriceService;



/**
 * 规格价格表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-04 15:09:04
 */
@RestController
@RequestMapping("good/goodspecprice")
public class GoodSpecPriceController {
    @Autowired
    private GoodSpecPriceService goodSpecPriceService;

    @Autowired
    private GoodService goodService;
    
    @Autowired
    private GoodAttributeService goodAttributeService;

    
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("good:goodspecprice:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodSpecPriceService.queryPage(params);

        return R.ok().put("page", page);
    }
    

    /**
     * 列表
     */
    @RequestMapping("/getGoodSpecPricelist")
     public R getGoodSpecPricelist(GoodSpecPriceEntity goodSpecPriceEntity ){
    	   
    	EntityWrapper< GoodSpecPriceEntity> ew = new EntityWrapper< GoodSpecPriceEntity>();
    	ew.setEntity(goodSpecPriceEntity);
        List page = goodSpecPriceService.selectList(ew);

        return R.ok().put("data", page);
    }

 

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("good:goodspecprice:info")
    public R info(@PathVariable("id") Integer id){
        GoodSpecPriceEntity goodSpecPrice = goodSpecPriceService.selectById(id);

        return R.ok().put("goodSpecPrice", goodSpecPrice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("good:goodspecprice:save")
    public R save(@RequestBody GoodSpecPriceEntity goodSpecPrice){
    	ValidatorUtils.validateEntity(goodSpecPrice);
        goodSpecPriceService.insert(goodSpecPrice);

        return R.ok();
    }
    
    /**
     * 保存
     */
    @RequestMapping("/saveGoodSpecPriceEntity")
    public R saveGoodSpecPriceEntity(@RequestBody List<GoodSpecPriceEntity> goodSpecPriceList){
    	//ValidatorUtils.validateEntity(goodSpecPrice);
    	//排除价格为0的数据
    	
    	List<GoodSpecPriceEntity> list =goodSpecPriceList.stream().filter(e->  e.getPrice().compareTo(new BigDecimal(0))>0?true:false).collect(Collectors.toList());
    
    		 if(list.size() == 0) {
    			  return R.error("价格数据必须大于0");
    		 }
    		list.sort((u1, u2) -> u1.getPrice().compareTo(u2.getPrice()));
    	 
    	BigDecimal minPrice = list.get(0).getPrice();
    	BigDecimal maxPrice = list.get(list.size()-1).getPrice();
    	Integer goodId = goodSpecPriceList.get(0).getGoodId();
    	GoodEntity good = goodService.selectById(goodId);
    	good.setMinPrice(minPrice);
    	good.setMaxPrice(maxPrice);
    	good.setActivate(1);
    	long  salesVolume=goodSpecPriceList.stream().mapToLong(p->Long.parseLong (  StringUtils.isEmpty(p.getSalesVolume()) ? "0": p.getSalesVolume())).sum();
    	long stocks=goodSpecPriceList.stream().mapToLong(p->  p.getStock()==null?0:p.getStock()).sum();   
    	EntityWrapper<GoodAttributeEntity> wrapper = new EntityWrapper<GoodAttributeEntity>();
    	wrapper.eq("good_id", goodId);
    	GoodAttributeEntity goodAttributeEntity = goodAttributeService.selectOne(wrapper);
    	if(goodAttributeEntity == null) {
    		goodAttributeEntity = new GoodAttributeEntity();
    	}
    	goodAttributeEntity.setSalesVolume(salesVolume);
    	goodAttributeEntity.setStock(stocks);
    	goodAttributeEntity.setGoodId(goodId.longValue());
    	goodAttributeService.insertOrUpdate(goodAttributeEntity);
    	
    	goodService.updateById(good);
         goodSpecPriceService.updateAllColumnBatchById(goodSpecPriceList);
         return R.ok();
    }
    

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("good:goodspecprice:update")
    public R update(@RequestBody GoodSpecPriceEntity goodSpecPrice){
        ValidatorUtils.validateEntity(goodSpecPrice);
        goodSpecPriceService.updateAllColumnById(goodSpecPrice);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("good:goodspecprice:delete")
    public R delete(@RequestBody Integer[] ids){
        goodSpecPriceService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
