package com.freeter.modules.expressCompany.service;

import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.expressCompany.entity.ExpressCompanyEntity;

import java.util.Map;

/**
 * 
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-06-06 13:08:58
 */
public interface ExpressCompanyService extends IService<ExpressCompanyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

