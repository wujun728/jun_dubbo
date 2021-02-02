package com.freeter.modules.good.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.GoodImageEntity;
import com.freeter.modules.good.entity.model.GoodImageModel;
import com.freeter.modules.good.entity.vo.GoodImageVO;
import com.freeter.modules.good.service.GoodImageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 商品图片表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
@RestController
@RequestMapping("goodimage")
@Api(tags="商品图片表接口")
public class GoodImageController {
    @Autowired
    private GoodImageService goodImageService;
 
	
    /**
     * 查询
     */
    @GetMapping("/getGoodImage")
    @ApiOperation("获取商品图片")
    public R getGoodImage(GoodImageModel goodImageModel){
		ValidatorUtils.validateEntity(goodImageModel);
        EntityWrapper< GoodImageEntity> ew = new EntityWrapper< GoodImageEntity>();
		GoodImageEntity goodImage = new  GoodImageEntity( goodImageModel);
		ew.setEntity(goodImage);
		goodImage.setStatus(1);
		List<GoodImageVO> goodImageVOList =goodImageService.selectListVO(ew);
		return R.ok("查询商品图片表成功").put("data",goodImageVOList);
    }
    
    
    /**
     * 查询
     */
    @GetMapping("/search")
    @ApiOperation("查询商品图片表")
    public R search(GoodImageModel goodImageModel){
		ValidatorUtils.validateEntity(goodImageModel);
        EntityWrapper< GoodImageEntity> ew = new EntityWrapper< GoodImageEntity>();
		GoodImageEntity goodImage = new  GoodImageEntity( goodImageModel);
		ew.setEntity(goodImage);
		goodImageService.selectList(ew);
		return R.ok("查询商品图片表成功").put("data",goodImageService.selectList(ew));
    }

	

    /**
     * 信息
     */
    @GetMapping("/info/{picImgId}")
    @ApiOperation("获取相应的商品图片表")
    public R info(@PathVariable("picImgId") Long picImgId){
        GoodImageEntity goodImage = goodImageService.selectById(picImgId);
        return R.ok().put("goodImage", goodImage);
    }

}
