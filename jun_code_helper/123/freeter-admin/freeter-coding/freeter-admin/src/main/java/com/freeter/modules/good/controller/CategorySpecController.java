package com.freeter.modules.good.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.freeter.common.utils.GenUtils;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.CategorySpecEntity;
import com.freeter.modules.good.entity.view.CategorySpecView;
import com.freeter.modules.good.service.CategorySpecService;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;

/**
 * 分类规格表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-31 18:32:07
 */
@RestController
@RequestMapping("good/categoryspec")
public class CategorySpecController {
	@Autowired
	private CategorySpecService categorySpecService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("good:categoryspec:list")
	public R list(@RequestParam Map<String, Object> params, CategorySpecEntity en) {
		// PageUtils page = categorySpecService.queryPage(params);
		EntityWrapper<CategorySpecEntity> ew = new EntityWrapper<CategorySpecEntity>();
	 
		Map map = new HashMap();
		map = BeanUtil.beanToMap(en);
		ew.allEq(GenUtils.camelToUnderlineMap(map, ""));
		Page<CategorySpecView> page = categorySpecService.queryPageCategorySpecView(params, ew);
		return R.ok().put("page", new PageUtils(page));
	}

	/**
	 * 列表
	 */
	@RequestMapping("/specList")
	@RequiresPermissions("good:categoryspec:list")
	public R specList(CategorySpecEntity cse) {

		EntityWrapper<CategorySpecEntity> ew = new EntityWrapper<CategorySpecEntity>();
		ew.setEntity(cse);
		ew.or("category_id is null ");
		return R.ok().put("data", categorySpecService.selectList(ew));
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("good:categoryspec:info")
	public R info(@PathVariable("id") Integer id) {
		CategorySpecEntity categorySpec = categorySpecService.selectById(id);

		return R.ok().put("categorySpec", categorySpec);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("good:categoryspec:save")
	public R save(@RequestBody CategorySpecView categorySpec) {
		// ValidatorUtils.validateEntity(categorySpec);
		Assert.notBlank(categorySpec.getSpecName(), "规格名称不能为空");
		Long[] categoryIds = categorySpec.getCategoryIds();
		if (categoryIds != null) {

			for (Long categoryId : categoryIds) {
				categorySpec.setCategoryId(categoryId.intValue());
				categorySpecService.insert(categorySpec);
			}
		} else {
			categorySpecService.insert(categorySpec);
		}

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("good:categoryspec:update")
	public R update(@RequestBody CategorySpecEntity categorySpec) {
		ValidatorUtils.validateEntity(categorySpec);
		categorySpecService.updateAllColumnById(categorySpec);// 全部更新

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("good:categoryspec:delete")
	public R delete(@RequestBody Integer[] ids) {
		categorySpecService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
