/*
 * Copyright 2015-2016 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.roncoo.adminlte.service;

import java.util.List;

import com.roncoo.adminlte.bean.entity.RcRolePermissions;
import com.roncoo.adminlte.bean.vo.Result;

/**
 * 角色-权限Service
 * 
 * @author LYQ
 *
 */
public interface RolePermissionsService {
	Result<RcRolePermissions> query(long id);

	Result<List<RcRolePermissions>> queryByRoleId(long id);

	Result<Integer> save(long roleId, List<Long> permissionList);

	Result<Integer> update(long roleId, List<Long> permissionList);
	
	Result<Integer> delete(long roleId);

	Result<Integer> deleteByRolePermissions(RcRolePermissions rcRolePermissions);
	
	Result<List<RcRolePermissions>> listForRoleId(List<Long> idList);

}
