/**
 * 
 */
package com.kss.login.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kss.data.exception.GenericDatabaseException;
import com.kss.login.model.Users;
import com.kss.login.service.LoginService;
import com.kss.login.vo.Errors;
import com.kss.login.vo.LoginResponse;

/**
 * @author kiran
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	/**
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, value="/users/create")
	@ResponseBody
	public LoginResponse createUser(@RequestBody @Valid Users user) {
		
		return loginService.createLogin(user);
		
	}
	/**
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/users/update")
	@ResponseBody
	public LoginResponse updateUser(@RequestBody @Valid Users user) {
		
		return loginService.createLogin(user);
		
	}

	
	@RequestMapping(method=RequestMethod.POST, value="authenticate")
	@ResponseBody
	public LoginResponse authenticateUser(@RequestBody @Valid Users user) {
		
		LoginResponse response = null;
		try {
			response = loginService.authenticateUser(user);
		}
		catch(GenericDatabaseException gde) {
			response = new LoginResponse();
			response.setUserName(user.getUserName());
			List<Errors> errorsList = new ArrayList<>();
			Errors error = new Errors();
			error.setErrorCode("1000");
			error.setErrorMessage(gde.getMessage());
			errorsList.add(error);
			response.setErrorsList(errorsList);
			response.setDescription("Unable to process your request");
		}
		return response;
		
	}
	
	
}
