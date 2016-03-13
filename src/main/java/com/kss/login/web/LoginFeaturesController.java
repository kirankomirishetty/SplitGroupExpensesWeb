/**
 * 
 */
package com.kss.login.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kss.login.model.RolesRequest;
import com.kss.login.service.LoginFeaturesService;

/**
 * @author kiran
 *
 */
@Controller
@RequestMapping("/roles/")
public class LoginFeaturesController {

	@Autowired
	private LoginFeaturesService loginFeaturesService;
	
	@RequestMapping(method=RequestMethod.POST, value="role")
	@ResponseBody
	public String addRole(@RequestBody @Valid RolesRequest rolesRequest) {
		
		boolean isRoleAdded = loginFeaturesService.addRole(rolesRequest);
		
		if(isRoleAdded) {
			return rolesRequest.getRoleName()+" Added successfully";
		}
		else {
			return "Encountered an issue while adding the role. Please try again later";
		}
	
		
	}

}
