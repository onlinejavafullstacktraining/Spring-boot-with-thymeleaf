package com.internet.database;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.internet.model.Address;
import com.internet.model.Contact;
import com.internet.model.Login;
import com.internet.model.Person;
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String savePerson(Person person) {
		Serializable save = hibernateTemplate.save(person);
		return save!=null?"Person object is saved successfully":"Person object is not saved successfully";
	}

	@Override
	public String saveContact(Contact contact) {
		Serializable save = hibernateTemplate.save(contact);
		return save!=null?"Contact object is saved successfully":"Contact object is not saved successfully";
	}

	@Override
	public String saveAddress(Address address) {
		Serializable save = hibernateTemplate.save(address);
		return save!=null?"Address object is saved successfully":"Address object is not saved successfully";
	}

	@Override
	public Login findLogin(Login login) {
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Login> find = (List<Login>) hibernateTemplate.find("from Login where username=?0", login.getUsername());
		 return !BankUtilities.isEmptyList(find) ?find.get(0):null;
	}

}
