package com.spring.thymeleaf.service;

import com.spring.thymeleaf.autobean.PersonAutoBean;
import com.spring.thymeleaf.model.Login;

public interface UserService {
	public String saveUser(PersonAutoBean personAutoBean);
	public Login findLogin(Login login);

}
