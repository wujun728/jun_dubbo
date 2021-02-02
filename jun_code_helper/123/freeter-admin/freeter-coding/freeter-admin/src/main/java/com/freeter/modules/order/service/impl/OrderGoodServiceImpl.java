package com.freeter.modules.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.order.dao.OrderGoodDao;
import com.freeter.modules.order.entity.OrderGoodEntity;
import com.freeter.modules.order.service.OrderGoodService;


@Service("orderGoodService")
public class OrderGoodServiceImpl extends ServiceImpl<OrderGoodDao, OrderGoodEntity> implements OrderGoodService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderGoodEntity> page = this.selectPage(
                new Query<OrderGoodEntity>(params).getPage(),
                new EntityWrapper<OrderGoodEntity>()
        );

        return new PageUtils(page);
    }

}
