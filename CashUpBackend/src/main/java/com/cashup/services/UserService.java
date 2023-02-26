package com.cashup.services;

import com.cashup.model.UserRegister;

public interface UserService {
	
	void add(UserRegister ulogin);
	UserRegister getById(int id);
	UserRegister loadUserByUsername(String username,String pass); 
	
	

}
