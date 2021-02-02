package com.freeter.modules.sys.entity.model;

import com.freeter.common.annotation.MpIgnore;
import com.freeter.common.annotation.MpLike;
import com.freeter.common.annotation.OwnerTable;
import com.freeter.modules.sys.entity.SysUserEntity;

@OwnerTable(SysUserEntity.class)
public class SysUserModel {
	@MpLike
	private String username;
	
	@MpIgnore
	private Long deptId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	
}
