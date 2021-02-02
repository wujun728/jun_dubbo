package com.freeter.modules.good.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.good.dao.CategorySpecDao;
import com.freeter.modules.good.entity.CategorySpecEntity;
import com.freeter.modules.good.service.CategorySpecService;


@Service("goodSpecService")
public class CategorySpecServiceImpl extends ServiceImpl<CategorySpecDao, CategorySpecEntity> implements CategorySpecService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CategorySpecEntity> page = this.selectPage(
                new Query<CategorySpecEntity>(params).getPage(),
                new EntityWrapper<CategorySpecEntity>()
        );

        return new PageUtils(page);
    }

}
