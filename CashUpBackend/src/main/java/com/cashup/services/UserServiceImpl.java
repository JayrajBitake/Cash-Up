package com.cashup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashup.dao.UserDao;
import java.util.Optional;
import com.cashup.model.UserRegister;
@Service
public class UserServiceImpl implements UserService{
	@Autowired 
	private UserDao user;

	public void add(UserRegister ureg) {
		
		user.save(ureg);
	}

	@Override
	public UserRegister getById(int id) {
		Optional<UserRegister> bal = user.findById(id);
		if(bal.isPresent()) {
			return bal.get();
		}
		return null;
	}

	@Override
	public UserRegister loadUserByUsername(String username, String pass) {
		try {
			UserRegister ui=new UserRegister();
			
			ui=UserDao.selectByName(username,pass);
			System.out.println(ui.getUname());
			
		
		return ui;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void modify(UserRegister ur) {
		user.save(ur);
		
	}

	
//
//	@Override
//	public double addBalance(int amount, int uid) {
//		user.getByAddBalance(uid);
//		return amount;
//	}

	
}
