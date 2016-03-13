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
public class UserRoles {

	@NotNull
	@Size(max=36)
	private String userId;
	
	@NotNull
	@Size(max=36)
	private String roleId;

}
