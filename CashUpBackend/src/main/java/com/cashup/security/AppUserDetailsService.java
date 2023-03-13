package com.cashup.security;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cashup.model.UserRegister;
import com.cashup.services.UserServiceImpl;



@Service
public class AppUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserServiceImpl userServiceImpl;

	@Override
	public UserDetails loadUserByUsername(String uname) throws UsernameNotFoundException {
		UserRegister userRegister = userServiceImpl.readByUserName(uname);
		
		if(userRegister != null) {
			User user = new User(userRegister.getUname(), userRegister.getPass(), new ArrayList<>());
			return user;	
		} else {
			throw new UsernameNotFoundException("User doest not exist");
		}
	}
}
