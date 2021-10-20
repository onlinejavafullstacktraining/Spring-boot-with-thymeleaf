package com.internet.database;

import java.util.List;

import com.internet.model.Login;

public class BankUtilities {

	public static boolean isEmptyList(List<?> find) {
		if(find.isEmpty() || find ==null)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

}
