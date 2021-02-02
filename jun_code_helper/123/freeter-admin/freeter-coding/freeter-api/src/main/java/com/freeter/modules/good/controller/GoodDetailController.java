package com.freeter.modules.good.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.GoodDetailEntity;
import com.freeter.modules.good.entity.model.GoodDetailModel;
import com.freeter.modules.good.entity.vo.GoodDetailVO;
import com.freeter.modules.good.service.GoodDetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 商品描述表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
@RestController
@RequestMapping("gooddetail")
@Api(tags="商品描述表接口")
public class GoodDetailController {
    @Autowired
    private GoodDetailService goodDetailService;
 
	
    /**
     * 查询
     */
    @GetMapping("/getGoodDetail")
    @ApiOperation("获取商品描述")
    public R getGoodDetail(GoodDetailModel goodDetailModel){
		ValidatorUtils.validateEntity(goodDetailModel);
        EntityWrapper< GoodDetailEntity> ew = new EntityWrapper< GoodDetailEntity>();
		GoodDetailEntity goodDetail = new  GoodDetailEntity( goodDetailModel);
		ew.setEntity(goodDetail);
		GoodDetailVO goodDetailVO =goodDetailService.selectVO(ew);
		return R.ok("查询商品描述表成功").put("data",goodDetailVO);
    }

    
    /**
     * 查询
     */
    @GetMapping("/query")
    @ApiOperation("查询商品描述表")
    public R Model(GoodDetailModel goodDetailModel){
		ValidatorUtils.validateEntity(goodDetailModel);
        EntityWrapper< GoodDetailEntity> ew = new EntityWrapper< GoodDetailEntity>();
		GoodDetailEntity goodDetail = new  GoodDetailEntity( goodDetailModel);
		ew.setEntity(goodDetail);
		goodDetailService.selectList(ew);
		return R.ok("查询商品描述表成功").put("data",goodDetailService.selectList(ew));
    }

	

    /**
     * 信息
     */
    @GetMapping("/info/{goodDetailId}")
    @ApiOperation("获取相应的商品描述表")
    public R info(@PathVariable("goodDetailId") Long goodDetailId){
        GoodDetailEntity goodDetail = goodDetailService.selectById(goodDetailId);

        return R.ok().put("goodDetail", goodDetail);
    }

     
}
