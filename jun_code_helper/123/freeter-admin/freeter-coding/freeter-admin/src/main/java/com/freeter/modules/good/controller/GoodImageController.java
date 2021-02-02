package com.freeter.modules.good.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.CategoryEntity;
import com.freeter.modules.good.entity.GoodImageEntity;
import com.freeter.modules.good.service.GoodImageService;
import com.freeter.modules.oss.cloud.OSSFactory;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.exception.RRException;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;



/**
 * 商品图片表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-06 11:55:07
 */
@RestController
@RequestMapping("good/goodimage")
public class GoodImageController {
    @Autowired
    private GoodImageService goodImageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("good:good:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodImageService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/goodImageList")
    @RequiresPermissions("good:good:list")
    public R goodImageList(GoodImageEntity goodImageEntity){
    	EntityWrapper< GoodImageEntity> ew = new EntityWrapper< GoodImageEntity>();
    	ew.setEntity(goodImageEntity);
        return R.ok().put("goodImage", goodImageService.selectList(ew));
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{picImgId}")
    @RequiresPermissions("good:good:list")
    public R info(@PathVariable("picImgId") Long picImgId){
        GoodImageEntity goodImage = goodImageService.selectById(picImgId);

        return R.ok().put("goodImage", goodImage);
    }
    
    

    /**
     * 保存
     * @throws Exception 
     */
    @RequestMapping("/saveGoodImage")
    @RequiresPermissions("good:good:list")
    public R saveGoodImage(GoodImageEntity goodImage,@RequestParam("files") MultipartFile files[]) throws Exception{
    	
    	List<GoodImageEntity> list = new ArrayList();
		  if(files!=null&&files.length>0){ 
			  for(int i = 0;i<files.length;i++){  
				  MultipartFile file =files[i];
		if (file.isEmpty()) {
			throw new RRException("上传文件不能为空");
		}

		//上传文件
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String url = OSSFactory.build().uploadSuffix(file.getBytes(), suffix);

		//保存文件信息
	/*	SysOssEntity ossEntity = new SysOssEntity();
		ossEntity.setUrl(url);
		ossEntity.setCreateDate(new Date());
		sysOssService.insert(ossEntity);*/
		GoodImageEntity goodImageEntity = new GoodImageEntity();
		goodImageEntity.setPicImg(url);
		goodImageEntity.setGoodId(goodImage.getGoodId());
		list.add(goodImageEntity);
	}
		  }
        goodImageService.insertBatch(list);

        return R.ok();
    }
    
    
    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("good:good:list")
    public R save(@RequestBody GoodImageEntity goodImage){
    	ValidatorUtils.validateEntity(goodImage);
        goodImageService.insert(goodImage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("good:good:list")
    public R update(@RequestBody GoodImageEntity goodImage){
        ValidatorUtils.validateEntity(goodImage);
        goodImageService.updateAllColumnById(goodImage);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("good:good:list")
    public R delete( @RequestParam(value = "picImgIds[]")Long[] picImgIds,@RequestParam(value = "filePath[]")String[] filePath){
    	for(String file: filePath) 
		{
			OSSFactory.build().deleteByPath(file);
 		}
    	goodImageService.deleteBatchIds(Arrays.asList(picImgIds));

        return R.ok();
    }

}
