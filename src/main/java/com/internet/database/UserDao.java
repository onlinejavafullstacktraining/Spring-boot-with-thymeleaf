package com.internet.database;

import com.internet.model.Address;
import com.internet.model.Contact;
import com.internet.model.Login;
import com.internet.model.Person;

public interface UserDao {
	public String savePerson(Person person);
	public String saveContact(Contact person);
	public String saveAddress(Address person);
	public Login findLogin(Login login);

}
