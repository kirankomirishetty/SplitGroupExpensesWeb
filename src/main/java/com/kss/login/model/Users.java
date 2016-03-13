/**
 * 
 */
package com.kss.login.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

/**
 * @author kiran
 *
 */
public class Users {
	
	@NotNull
	@Email
	private String userName;
	
	@NotNull
	private String password;
	
//	@NotNull
	private String role;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
