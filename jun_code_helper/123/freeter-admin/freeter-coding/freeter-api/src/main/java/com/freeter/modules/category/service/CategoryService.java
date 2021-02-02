package com.freeter.modules.category.service;

import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.category.entity.CategoryEntity;

import java.util.Map;

/**
 * 分类表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-21 17:07:26
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

