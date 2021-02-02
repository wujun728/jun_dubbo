package com.freeter.modules.order.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单主表
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-28 15:57:37
 */
public interface OrderService extends IService<OrderEntity> {
    PageUtils queryPage(Map<String, Object> params);

	PageUtils queryPage(Map<String, Object> params, Wrapper<OrderEntity> wrapper);
}

