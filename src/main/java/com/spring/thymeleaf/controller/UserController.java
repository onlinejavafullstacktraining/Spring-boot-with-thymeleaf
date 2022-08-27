package com.spring.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.thymeleaf.autobean.PersonAutoBean;
import com.spring.thymeleaf.model.Login;
import com.spring.thymeleaf.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="/saveUser",method = RequestMethod.POST)
	public String saveUserInfo(PersonAutoBean personAutoBean) {
		return userService.saveUser(personAutoBean);
	}
	
	@RequestMapping("/")
	public String getHomePage(Model model) {
		/*
		 * PersonAutoBean bean=new PersonAutoBean();
		 * model.addAttribute("personAutoBean", bean);
		 */
		return "/home";
	}
	@RequestMapping("/login")
	public String getLogin(Model model) {
		Login login=new Login();
		model.addAttribute("login", login);
		return "/login";	
	}
	@RequestMapping("/registration")
	public String getRegistration(Model model) {
		PersonAutoBean bean=new PersonAutoBean();
		model.addAttribute("personAutoBean", bean);
		return "/registration";	
	}
	
	@RequestMapping("/saveLogin")
	public String saveLogin(Login user) {
		String message=null;
		Login loginInfo = userService.findLogin(user);
		if(loginInfo!=null) {
			message="login successfully";
		}else
			message="login is failed try with different user";
		ModelAndView model=new ModelAndView();
		model.addObject(message);
		return "/home";	
	}

}
