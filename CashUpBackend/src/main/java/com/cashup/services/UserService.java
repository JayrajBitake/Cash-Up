package com.cashup.services;

import com.cashup.model.UserRegister;

public interface UserService {
	
	String add(UserRegister ulogin);
	UserRegister getById(int id);
	UserRegister loadUserByUsername(String username,String pass); 
	void modify(UserRegister ur);
//	double addBalance(int amount, int  uid);
	
	
	

}
