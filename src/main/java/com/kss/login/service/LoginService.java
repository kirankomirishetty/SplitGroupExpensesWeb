/**
 * 
 */
package com.kss.login.service;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.kss.common.util.IDGenerator;
import com.kss.data.PasswordEncryption;
import com.kss.data.exception.GenericDatabaseException;
import com.kss.data.login.repository.impl.UsersDataHelper;
import com.kss.login.model.Users;
import com.kss.login.vo.Errors;
import com.kss.login.vo.LoginResponse;

/**
 * @author kiran
 *
 */
@Service
public class LoginService {

	@Autowired
	private UsersDataHelper userRepositoryImpl;
	public LoginResponse createLogin(Users users) {
		com.kss.data.login.entity.Users userEntity = new com.kss.data.login.entity.Users();
		
		userEntity.setUserId(IDGenerator.generateGUID());
		userEntity.setUserName(users.getUserName());
		String salt = null;
		try {
			salt = PasswordEncryption.getSalt();
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userEntity.setPassword(PasswordEncryption.getSecurePassword(users.getPassword(), salt));
		if(StringUtils.isEmpty(users.getRole())) {
			userEntity.setRoleId("ADMIN");
		}
		else {
			userEntity.setRoleId(users.getRole());
		}
		userEntity.setSalt(salt);
		
		boolean isUserCreated = userRepositoryImpl.createUser(userEntity);
		
		LoginResponse loginResponse = new LoginResponse();
		if (isUserCreated) {
			loginResponse.setUserName(users.getUserName());
			loginResponse.setDescription("User Created Successfully");
		}
		else {
			loginResponse.setUserName(users.getUserName());
			loginResponse.setDescription("Problem Creating the user");
			Errors errors = new Errors();
			errors.setErrorCode("USER1000");
			errors.setErrorMessage("User with userName already exists. Please select the new userId or reset your password");
			loginResponse.getErrorsList().add(errors);
		}
		
		return loginResponse;
	}
	
	public LoginResponse addModifyUserRole(Users users) {
		return null;
	}
	
	public LoginResponse authenticateUser(Users user) throws GenericDatabaseException {
		
		com.kss.data.login.entity.Users userEntity = userRepositoryImpl.findByUserName(user.getUserName());
		
		String messageDigest = PasswordEncryption.getSecurePassword(user.getPassword(), userEntity.getSalt());
		System.out.println("Message Digest from UI "+messageDigest+" digest from db "+userEntity.getPassword());
		
		LoginResponse loginResponse = new LoginResponse();
		if(messageDigest.equalsIgnoreCase(userEntity.getPassword())) {
			System.out.println("Authentication Successfull");
			loginResponse.setUserName(user.getUserName());
			loginResponse.setDescription("User Authenticated Successfully");
		}
		else {
			System.out.println("Invalid Credientials.....");
			loginResponse.setUserName(user.getUserName());
			loginResponse.setDescription("Problem Authenticating the user");
			Errors errors = new Errors();
			errors.setErrorCode("USER1000");
			errors.setErrorMessage("Invalid Credientials.....");
			loginResponse.getErrorsList().add(errors);
		}
		return loginResponse;
	}
}
