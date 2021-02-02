/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.freeter.modules.sys.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.annotation.DataFilter;
import com.freeter.common.mpextend.parser.ParseWrapper;
import com.freeter.common.utils.Constant;
import com.freeter.common.utils.PageInfo;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.sys.dao.SysUserDao;
import com.freeter.modules.sys.entity.SysDeptEntity;
import com.freeter.modules.sys.entity.SysUserEntity;
import com.freeter.modules.sys.entity.model.SysUserModel;
import com.freeter.modules.sys.service.SysDeptService;
import com.freeter.modules.sys.service.SysUserRoleService;
import com.freeter.modules.sys.service.SysUserService;
import com.freeter.modules.sys.shiro.ShiroUtils;


/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:46:09
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysDeptService sysDeptService;

	@Override
	public List<Long> queryAllMenuId(Long userId) {
		return baseMapper.queryAllMenuId(userId);
	}

	@Override
	@DataFilter(subDept = true, user = false)
	public PageUtils queryPage(PageInfo pageInfo,SysUserModel sysUserModel) {
		EntityWrapper<SysUserEntity> ew =  ParseWrapper.parseWrapper(sysUserModel);
		List deptList = new ArrayList();
		if(sysUserModel.getDeptId() != null) {
			deptList.add( sysUserModel.getDeptId());
			List subDeptList = sysDeptService.getSubDeptIdList(sysUserModel.getDeptId() );
			if(subDeptList!= null){
				deptList.addAll(subDeptList);
			}
		}
		ew.in((sysUserModel.getDeptId())!=null,"dept_id",deptList);
		System.out.println(ew.getSqlSegment());
	 
		Page<SysUserEntity> page = this.selectPage(
			pageInfo.getPage(),
			ew.addFilterIfNeed(RequestContextHolder.currentRequestAttributes().getAttribute(Constant.SQL_FILTER, RequestAttributes.SCOPE_REQUEST ) != null, (String)RequestContextHolder.currentRequestAttributes().getAttribute(Constant.SQL_FILTER, RequestAttributes.SCOPE_REQUEST) )
		);

		for(SysUserEntity sysUserEntity : page.getRecords()){
			SysDeptEntity sysDeptEntity = sysDeptService.selectById(sysUserEntity.getDeptId());
			sysUserEntity.setDeptName(sysDeptEntity.getName());
		}

		return new PageUtils(page);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(SysUserEntity user) {
		user.setCreateTime(new Date());
		//sha256加密
		String salt = RandomStringUtils.randomAlphanumeric(20);
		user.setSalt(salt);
		user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));
		this.insert(user);
		
		//保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(SysUserEntity user) {
		if(StringUtils.isBlank(user.getPassword())){
			user.setPassword(null);
		}else{
			user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));
		}
		this.updateById(user);
		
		//保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
	}


	@Override
	public boolean updatePassword(Long userId, String password, String newPassword) {
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setPassword(newPassword);
        return this.update(userEntity,
                new EntityWrapper<SysUserEntity>().eq("user_id", userId).eq("password", password));
    }

}
