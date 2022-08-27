package com.spring.thymeleaf.database;

import java.util.List;

import com.spring.thymeleaf.model.Login;

public class BankUtilities {

	public static boolean isEmptyList(List<?> find) {
		if(find.isEmpty() || find ==null)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

}
