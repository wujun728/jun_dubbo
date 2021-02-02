package com.freeter.modules.good.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.GoodParameterEntity;
import com.freeter.modules.good.service.GoodParameterService;

/**
 * 商品参数表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-07 08:56:45
 */
@RestController
@RequestMapping("good/goodparameter")
public class GoodParameterController {
	@Autowired
	private GoodParameterService goodParameterService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("good:good:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = goodParameterService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 列表
	 */
	@RequestMapping("/goodparameterList")
	@RequiresPermissions("good:good:list")
	public R goodparameterList(GoodParameterEntity goodParameterEntity) {
		EntityWrapper<GoodParameterEntity> ew = new EntityWrapper<GoodParameterEntity>();
		ew.setEntity(goodParameterEntity);
 		// goodParameterService.insertOrUpdateAllColumnBatch(entityList)

		return R.ok().put("data", goodParameterService.selectList(ew));
	}
	
	/**
	 * 列表
	 */
	@RequestMapping("/insertOrUpdateAllBatch")
	@RequiresPermissions("good:good:list")
	public R insertOrUpdateAllBatch(@RequestBody List<GoodParameterEntity> entityList) {
		 
 		 goodParameterService.insertOrUpdateAllColumnBatch(entityList);

		return R.ok();
	}
	

	/**
	 * 信息
	 */
	@RequestMapping("/info/{goodParameterId}")
	@RequiresPermissions("good:good:list")
	public R info(@PathVariable("goodParameterId") Long goodParameterId) {
		GoodParameterEntity goodParameter = goodParameterService.selectById(goodParameterId);

		return R.ok().put("goodParameter", goodParameter);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("good:good:list")
	public R save(@RequestBody GoodParameterEntity goodParameter) {
		ValidatorUtils.validateEntity(goodParameter);
		goodParameterService.insert(goodParameter);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("good:good:list")
	public R update(@RequestBody GoodParameterEntity goodParameter) {
		ValidatorUtils.validateEntity(goodParameter);
		goodParameterService.updateAllColumnById(goodParameter);// 全部更新

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("good:good:list")
	public R delete(@RequestBody Long[] goodParameterIds) {
		goodParameterService.deleteBatchIds(Arrays.asList(goodParameterIds));

		return R.ok();
	}

}
