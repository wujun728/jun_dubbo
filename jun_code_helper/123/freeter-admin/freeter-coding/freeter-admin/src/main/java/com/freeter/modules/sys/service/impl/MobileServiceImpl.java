package com.freeter.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.sys.dao.MobileDao;
import com.freeter.modules.sys.entity.MobileEntity;
import com.freeter.modules.sys.service.MobileService;


@Service("mobileService")
public class MobileServiceImpl extends ServiceImpl<MobileDao, MobileEntity> implements MobileService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MobileEntity> page = this.selectPage(
                new Query<MobileEntity>(params).getPage(),
                new EntityWrapper<MobileEntity>()
        );

        return new PageUtils(page);
    }

}
