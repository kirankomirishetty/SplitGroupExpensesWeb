/**
 * 
 */
package com.kss.login.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kiran
 *
 */
public class LoginResponse {

	private String userName;
	private String description;
	
	private List<Errors> errorsList;

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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the errorsList
	 */
	public List<Errors> getErrorsList() {
		if(errorsList == null) {
			this.errorsList = new ArrayList<Errors>();
		}
		return errorsList;
	}

	/**
	 * @param errorsList the errorsList to set
	 */
	public void setErrorsList(List<Errors> errorsList) {
		this.errorsList = errorsList;
	}
	
	
	
}
