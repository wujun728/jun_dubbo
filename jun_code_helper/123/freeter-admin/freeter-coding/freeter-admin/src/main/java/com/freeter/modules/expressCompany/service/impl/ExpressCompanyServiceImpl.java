package com.freeter.modules.expressCompany.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.expressCompany.dao.ExpressCompanyDao;
import com.freeter.modules.expressCompany.entity.ExpressCompanyEntity;
import com.freeter.modules.expressCompany.service.ExpressCompanyService;


@Service("expressCompanyService")
public class ExpressCompanyServiceImpl extends ServiceImpl<ExpressCompanyDao, ExpressCompanyEntity> implements ExpressCompanyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ExpressCompanyEntity> page = this.selectPage(
                new Query<ExpressCompanyEntity>(params).getPage(),
                new EntityWrapper<ExpressCompanyEntity>()
        );

        return new PageUtils(page);
    }

}
