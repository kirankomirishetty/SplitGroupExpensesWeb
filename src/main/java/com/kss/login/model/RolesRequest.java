/**
 * 
 */
package com.kss.login.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author kiran
 *
 */
public class RolesRequest {

	@NotNull
	private String roleName;
	
	@Size(max=100, min=3)
	private String roleDesc;

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleDesc
	 */
	public String getRoleDesc() {
		return roleDesc;
	}

	/**
	 * @param roleDesc the roleDesc to set
	 */
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
	
	

}
