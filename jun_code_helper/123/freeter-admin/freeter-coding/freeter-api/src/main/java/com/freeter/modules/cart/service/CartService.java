package com.freeter.modules.cart.service;

import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.cart.entity.CartEntity;

import java.util.Map;

/**
 * 购物车
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-29 09:47:58
 */
public interface CartService extends IService<CartEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

