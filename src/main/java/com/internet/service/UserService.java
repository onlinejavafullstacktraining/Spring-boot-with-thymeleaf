package com.internet.service;

import com.internet.autobean.PersonAutoBean;
import com.internet.model.Login;

public interface UserService {
	public String saveUser(PersonAutoBean personAutoBean);
	public Login findLogin(Login login);

}
