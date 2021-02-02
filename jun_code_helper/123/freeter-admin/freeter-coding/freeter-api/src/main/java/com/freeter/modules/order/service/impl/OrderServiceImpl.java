package com.freeter.modules.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.order.dao.OrderDao;
import com.freeter.modules.order.entity.OrderEntity;
import com.freeter.modules.order.service.OrderService;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderEntity> page = this.selectPage(
                new Query<OrderEntity>(params).getPage(),
                new EntityWrapper<OrderEntity>()
        );

        return new PageUtils(page);
    }

}
