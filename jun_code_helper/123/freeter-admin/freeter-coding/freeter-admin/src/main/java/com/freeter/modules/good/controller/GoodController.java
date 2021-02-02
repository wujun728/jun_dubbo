package com.freeter.modules.good.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.validator.Assert;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.CategoryEntity;
import com.freeter.modules.good.entity.CategoryGoodEntity;
import com.freeter.modules.good.entity.GoodDetailEntity;
import com.freeter.modules.good.entity.GoodEntity;
import com.freeter.modules.good.entity.GoodImageEntity;
import com.freeter.modules.good.entity.GoodParameterEntity;
import com.freeter.modules.good.entity.GoodSpecPriceEntity;
import com.freeter.modules.good.entity.GoodSpecValueEntity;
import com.freeter.modules.good.entity.view.GoodView;
import com.freeter.modules.good.service.CategoryGoodService;
import com.freeter.modules.good.service.CategoryService;
import com.freeter.modules.good.service.ChannelService;
import com.freeter.modules.good.service.GoodDetailService;
import com.freeter.modules.good.service.GoodImageService;
import com.freeter.modules.good.service.GoodParameterService;
import com.freeter.modules.good.service.GoodService;
import com.freeter.modules.good.service.GoodSpecPriceService;
import com.freeter.modules.good.service.GoodSpecValueService;
import com.freeter.modules.oss.cloud.OSSFactory;

/**
 * 商品表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-31 09:01:38
 */
@RestController
@RequestMapping("good/good")
public class GoodController {
	@Autowired
	private ChannelService channelService;
	@Autowired
	private GoodSpecPriceService goodSpecPriceService;
	@Autowired
	private GoodDetailService goodDetailService;
	@Autowired
	private GoodService goodService;
	@Autowired
	private GoodParameterService goodParameterService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private GoodSpecValueService goodSpecValueService;
	@Autowired
	private CategoryGoodService categoryGoodService;

	@Autowired
	private GoodImageService goodImageService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("good:good:list")
	public R list(@RequestParam Map<String, Object> params, GoodView goodView) {
		EntityWrapper<GoodEntity> wrapper = new EntityWrapper<GoodEntity>();
		Long categoryId = goodView.getCategoryId();
		Long oneCategotyId = goodView.getOneCategoryId();
		if (categoryId != null) {
			wrapper.eq("category.category_id", categoryId);
		} else if (oneCategotyId != null) {
			EntityWrapper<CategoryEntity> wrapperCategory = new EntityWrapper<CategoryEntity>();
			wrapperCategory.eq("parent_id", oneCategotyId);
			List<Object> categoryIds = categoryService.selectObjs(wrapperCategory);
			if (categoryIds.isEmpty()) {
				return R.ok().put("page", new PageUtils(params));
			}
			wrapper.in("category.category_id", categoryIds);
		} else if (goodView.getChannelId() != null) {
			EntityWrapper<CategoryEntity> wrapperCategory = new EntityWrapper<CategoryEntity>();
			wrapperCategory.eq("channel_id", goodView.getChannelId());
			List<Object> categoryIds = categoryService.selectObjs(wrapperCategory);
			if (categoryIds.isEmpty()) {

				return R.ok().put("page", new PageUtils(params));
			}
			wrapper.in("category.category_id", categoryIds);
		}
		wrapper.like("good.good_name", goodView.getGoodName());
		PageUtils page = new PageUtils(goodService.queryPage(params, wrapper));

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{goodId}")
	@RequiresPermissions("good:good:info")
	public R info(@PathVariable("goodId") Integer goodId) {
		GoodEntity good = goodService.selectById(goodId);
		CategoryGoodEntity categoryGoodEntity = new CategoryGoodEntity();
		EntityWrapper<CategoryGoodEntity> ew = new EntityWrapper<CategoryGoodEntity>();
		categoryGoodEntity.setGoodId(goodId.longValue());
		GoodView goodView = new GoodView(good);
		ew.setEntity(categoryGoodEntity);
		CategoryGoodEntity categoryGood = categoryGoodService.selectOne(ew);
		if(categoryGood!= null){
			Long categoryId = categoryGood.getCategoryId();
			goodView.setCategoryId(categoryId);
			EntityWrapper<CategoryEntity> wrapper = new EntityWrapper<CategoryEntity>();
			wrapper.eq("category_id", categoryId);
			CategoryEntity ce = categoryService.selectOne(wrapper);
			if(ce != null){
				goodView.setOneCategoryId(ce.getParentId());
				goodView.setChannelId(Long.valueOf( ce.getChannelId()));
				
			}
		}
	 
		return R.ok().put("good", goodView);

	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("good:good:save")
	public R save(@RequestBody GoodEntity good) {
		ValidatorUtils.validateEntity(good);
		goodService.insert(good);

		return R.ok();
	}

	/**
	 * 保存
	 */
	@RequestMapping("/saveGood")
	@RequiresPermissions("good:good:save")
	public R saveGood(@RequestBody(required = false) GoodView goodView) {

		ValidatorUtils.validateEntity(goodView);
		GoodEntity good = new GoodEntity(goodView);
		good.setActivate(0);
		goodService.insert(good);
		Integer id = good.getGoodId();
		goodView.setGoodId(id);
		CategoryGoodEntity cge = new CategoryGoodEntity(goodView);
		Long categoryId = goodView.getOneCategoryId();

		categoryGoodService.insert(cge);
		List<GoodImageEntity> listGoodImageEntity = new ArrayList();
		goodView.getImages().forEach(image -> {
			GoodImageEntity goodImageEntity = new GoodImageEntity();
			goodImageEntity.setGoodId(good.getGoodId().longValue());
			;
			goodImageEntity.setStatus(1);
			goodImageEntity.setPicImg(image);
			listGoodImageEntity.add(goodImageEntity);

		});
		if (!listGoodImageEntity.isEmpty()) {

			goodImageService.insertBatch(listGoodImageEntity);
		}

		Map map = new HashMap();
		map.put("categoryId", categoryId);
		map.put("id", id);
		return R.ok().put("data", map);
	}

	/**
	 * 修改
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/update")
	@RequiresPermissions("good:good:update")
	public R update(@RequestBody GoodView goodView) throws IOException {
		Long newCategoryId = goodView.getCategoryId();
		Assert.isNull(goodView.getCategoryId(), "分类不能为空");
		ValidatorUtils.validateEntity(goodView);
		GoodEntity goodEntity = goodService.selectById(goodView.getGoodId());
		
		EntityWrapper<CategoryEntity> wrapper = new EntityWrapper<CategoryEntity>();
		wrapper.eq("category_id", goodView.getCategoryId());
		CategoryEntity ce = categoryService.selectOne(wrapper);
		Long parentCategoryId = ce.getParentId();
		
		CategoryGoodEntity categoryGoodEntity = new CategoryGoodEntity();
		EntityWrapper<CategoryGoodEntity> ew = new EntityWrapper<CategoryGoodEntity>();
		categoryGoodEntity.setGoodId(goodEntity.getGoodId().longValue());
 		ew.setEntity(categoryGoodEntity);
 		CategoryGoodEntity oldCategoryGoodEntity = categoryGoodService.selectOne(ew);
		Long oldCategoryId =  oldCategoryGoodEntity.getCategoryId();
		EntityWrapper<CategoryEntity> wrapperOld = new EntityWrapper<CategoryEntity>();
		wrapperOld.eq("category_id",oldCategoryId);
		CategoryEntity oldCe = categoryService.selectOne(wrapperOld);
		if(oldCe == null){
 			 
			oldCategoryGoodEntity.setCategoryId(newCategoryId);
			oldCategoryGoodEntity.setCategoryName(ce.getName());
		 
			categoryGoodService.updateById (oldCategoryGoodEntity);
			goodView.setPicImg(goodEntity.getPicImg());
			goodService.updateAllColumnById(goodView);// 全部更新	
			return R.ok();
		}
		Long oldParentCategoryId = oldCe.getParentId();
		
		if(newCategoryId.equals(oldCategoryId)) {
			goodView.setPicImg(goodEntity.getPicImg());
			goodService.updateAllColumnById(goodView);// 全部更新	
			return R.ok();
		}
		
		if(oldParentCategoryId.equals(parentCategoryId)) {
			EntityWrapper<CategoryGoodEntity> wrapperCategoryGood =  new EntityWrapper<CategoryGoodEntity>(); 
			oldCategoryGoodEntity.setCategoryId(newCategoryId);
			oldCategoryGoodEntity.setCategoryName(ce.getName());
		 
			categoryGoodService.updateById (oldCategoryGoodEntity);
			
			goodView.setPicImg(goodEntity.getPicImg());
			goodService.updateAllColumnById(goodView);// 全部更新
			
			return R.ok();
			
		}else {
			return R.error("只能更换二级分类，因为分类的规格不一样");
		}
		
		
	 
		
	 
	}

	/**
	 * 修改上架 下架
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/updateShelve")
	@RequiresPermissions("good:good:update")
	public R shelve(GoodEntity good) throws IOException {

		goodService.updateById(good);

		return R.ok();
	}

	/**
	 * 修改
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/updateImage")
	@RequiresPermissions("good:good:update")
	public R updateImage(GoodEntity good, @RequestParam("files") MultipartFile file) throws IOException {
		if (file != null && file.getSize() > 0) {

			// 上传文件
			String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			String url = OSSFactory.build().uploadSuffix(file.getBytes(), suffix);
			good.setPicImg(url);
		}

		goodService.updateById(good);

		return R.ok();
	}

	/**
	 * 修改
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/deleteImage")
	@RequiresPermissions("good:good:update")
	public R updateImage(GoodEntity good, @RequestParam(value = "filePath") String filePath) throws IOException {
		OSSFactory.build().deleteByPath(filePath);
		good = goodService.selectById(good.getGoodId());
		good.setPicImg(null);
		goodService.updateAllColumnById(good);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("good:good:delete")
	public R delete(@RequestBody Integer[] goodIds) {
		goodService.deleteBatchIds(Arrays.asList(goodIds));
		EntityWrapper<CategoryGoodEntity> ew = new EntityWrapper<CategoryGoodEntity>();
		ew.in("good_id", goodIds);
 		categoryGoodService.delete(ew);
		EntityWrapper<GoodImageEntity> ew2 = new EntityWrapper<GoodImageEntity>();
		ew2.in("good_id", goodIds);
		goodImageService.delete(ew2);
 		EntityWrapper<GoodSpecPriceEntity> ew3 = new EntityWrapper<GoodSpecPriceEntity>();
		ew3.in("good_id", goodIds);
		goodSpecPriceService.delete(ew3);
		EntityWrapper<GoodSpecValueEntity> ew4 = new EntityWrapper<GoodSpecValueEntity>();
		ew4.in("good_id", goodIds);
		goodSpecValueService.delete(ew4);
		EntityWrapper<GoodDetailEntity> ew5 = new EntityWrapper<GoodDetailEntity>();
		ew5.in("good_id", goodIds);
		goodDetailService.delete(ew5);
		EntityWrapper<GoodParameterEntity> ew6 = new EntityWrapper<GoodParameterEntity>();
		ew6.in("good_id", goodIds);
		goodParameterService.delete(ew6);
		
		return R.ok();
	}

}
