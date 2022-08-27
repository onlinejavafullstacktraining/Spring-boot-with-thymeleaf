package com.spring.thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.thymeleaf.autobean.PersonAutoBean;
import com.spring.thymeleaf.database.UserDao;
import com.spring.thymeleaf.model.Address;
import com.spring.thymeleaf.model.Contact;
import com.spring.thymeleaf.model.Login;
import com.spring.thymeleaf.model.Person;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public String saveUser(PersonAutoBean personAutoBean) {
		Person person = new Person();
		person.setFirstname(personAutoBean.getFirstname());
		person.setLastname(personAutoBean.getLastname());
		person.setSortname(personAutoBean.getFirstname() + " " + personAutoBean.getLastname());
		Contact contact = new Contact();
		contact.setEmail(personAutoBean.getEmail());
		contact.setPhone(personAutoBean.getPhone());
		Address address = new Address();
		address.setAddress1(personAutoBean.getAddress1());
		address.setAddress2(personAutoBean.getAddress2());
		address.setCity(personAutoBean.getCity());
		address.setZipcode(personAutoBean.getZipcode());
		person.setContact(contact);
		person.setAddress(address);
		return userDao.savePerson(person);
	}

	@Override
	public Login findLogin(Login login) {
		return userDao.findLogin(login);
	}

}
