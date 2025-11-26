package com.springmvc.login;

import org.springframework.stereotype.Service;

@Service	//using the @Service annotation makes the LoginService class available as a bean
public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("test1234") && password.equals("test1234");
	}

}
