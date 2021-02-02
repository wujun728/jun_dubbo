package com.freeter.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.sys.entity.MobileEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-04-23 13:57:13
 */
public interface MobileService extends IService<MobileEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

