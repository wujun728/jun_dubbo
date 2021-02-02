package com.freeter.modules.good.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.good.dao.GoodSpecPriceDao;
import com.freeter.modules.good.entity.GoodSpecPriceEntity;
import com.freeter.modules.good.service.GoodSpecPriceService;


@Service("goodSpecPriceService")
public class GoodSpecPriceServiceImpl extends ServiceImpl<GoodSpecPriceDao, GoodSpecPriceEntity> implements GoodSpecPriceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodSpecPriceEntity> page = this.selectPage(
                new Query<GoodSpecPriceEntity>(params).getPage(),
                new EntityWrapper<GoodSpecPriceEntity>()
        );

        return new PageUtils(page);
    }

}
