package com.kss.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kss.common.util.IDGenerator;
import com.kss.data.login.entity.Roles;
import com.kss.data.login.repository.impl.RolesDataHelper;
import com.kss.login.model.RolesRequest;

@Service
public class LoginFeaturesService {

	@Autowired
	private RolesDataHelper rolesDataHelper;
	
	public boolean addRole(RolesRequest rolesRequest) {
		
		Roles roles = new Roles();
		roles.setRoleId(IDGenerator.generateGUID());
		roles.setRoleName(rolesRequest.getRoleName());
		roles.setRoleDesc(rolesRequest.getRoleDesc());
		
		return rolesDataHelper.addRole(roles);
		
		
		
	}

}
