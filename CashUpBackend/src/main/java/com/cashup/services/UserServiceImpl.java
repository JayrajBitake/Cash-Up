package com.cashup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashup.dao.UserDao;
import com.cashup.exception.CustomException;

import java.util.List;
import java.util.Optional;
import com.cashup.model.UserRegister;
@Service
public class UserServiceImpl implements UserService{
	@Autowired 
	private UserDao user;
//	@Autowired
//    PasswordEncoder passwordEncoder;


	public String add(UserRegister ureg) {
		List<UserRegister> list=user.findAll();
		for(int i=0;i<list.size();i++)
		{
			if(ureg.getEmail().equals(list.get(i).getEmail()) && ureg.getMobileno().equals(list.get(i).getMobileno()))
					{
						return "Mobile or email already exists";
					}
			
		}
		//user.setPass(passwordEncoder.encode(ureg.getPass()));
		
		user.save(ureg);
		return "User Registered";
		
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
		catch(CustomException e) {
			//e.printStackTrace();
			throw new CustomException("Invalid credentials");
		
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
