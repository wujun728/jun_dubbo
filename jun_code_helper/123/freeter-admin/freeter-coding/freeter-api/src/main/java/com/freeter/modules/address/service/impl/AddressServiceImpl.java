package com.freeter.modules.address.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.address.dao.AddressDao;
import com.freeter.modules.address.entity.AddressEntity;
import com.freeter.modules.address.service.AddressService;


@Service("addressService")
public class AddressServiceImpl extends ServiceImpl<AddressDao, AddressEntity> implements AddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AddressEntity> page = this.selectPage(
                new Query<AddressEntity>(params).getPage(),
                new EntityWrapper<AddressEntity>()
        );

        return new PageUtils(page);
    }

}
