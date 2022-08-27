package com.spring.thymeleaf.database;

import com.spring.thymeleaf.model.Address;
import com.spring.thymeleaf.model.Contact;
import com.spring.thymeleaf.model.Login;
import com.spring.thymeleaf.model.Person;

public interface UserDao {
	public String savePerson(Person person);
	public String saveContact(Contact person);
	public String saveAddress(Address person);
	public Login findLogin(Login login);

}
