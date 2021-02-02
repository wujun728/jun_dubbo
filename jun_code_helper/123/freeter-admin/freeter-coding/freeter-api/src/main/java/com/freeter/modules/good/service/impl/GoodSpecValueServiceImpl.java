package com.freeter.modules.good.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.good.dao.GoodSpecValueDao;
import com.freeter.modules.good.entity.GoodSpecValueEntity;
import com.freeter.modules.good.service.GoodSpecValueService;


@Service("goodSpecValueService")
public class GoodSpecValueServiceImpl extends ServiceImpl<GoodSpecValueDao, GoodSpecValueEntity> implements GoodSpecValueService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodSpecValueEntity> page = this.selectPage(
                new Query<GoodSpecValueEntity>(params).getPage(),
                new EntityWrapper<GoodSpecValueEntity>()
        );

        return new PageUtils(page);
    }

}
