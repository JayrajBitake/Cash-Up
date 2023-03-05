package com.cashup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cashup.dao.UserDao;
import com.cashup.model.Transaction;
import com.cashup.model.UserRegister;
import com.cashup.services.UserService;

@RestController
public class UserCotroller {
	@Autowired
	private UserService uservice;
	@Autowired
	private UserDao uDao;
	@PostMapping(value = {"/uregister"}) 
	public String userAdd(@RequestBody UserRegister ureg) {
		uservice.add(ureg);
		return "User Registered SucessFully";
	}
	@GetMapping(value = {"/balance/{id}"})
	public UserRegister balGet(@PathVariable int id) {
		return uservice.getById(id);
	}
	@GetMapping(value = {"/login/{uname}/{pass}"})
	public UserRegister userLogin(@PathVariable String uname,@PathVariable String pass){
		return uservice.loadUserByUsername(uname,pass);
	}
	@PutMapping(value = {"/update"})
	public String postUpdate(@RequestBody UserRegister ureg) {
		uservice.modify(ureg);
		return " update success";
	}
	
	
	@PostMapping(value = {"/addBalanc/{uid}/{balance}"}) 
	public String balanceAdd(@PathVariable String uid,@PathVariable String balance) {
	double bal=Integer.parseInt(balance);
	int user_id=Integer.parseInt(uid);
		double currentBalance=uDao.getByAddBalance(user_id);
		if(bal==0)
		{
			return "Cannot deposit 0";
		}
	
		
		
		 double netBal=currentBalance+ bal;
		 uDao.getByChangeBal(netBal, user_id);
		 return "balance add";
	}
	@PostMapping(value = {"/makePayment/{uid}/{price}"})
	public String makePayment(@PathVariable String uid ,@PathVariable String price) {
		double purchase=Integer.parseInt(price);
		int user_id=Integer.parseInt(uid);
		double currentBalance=uDao.getByAddBalance(user_id);
		double rewards=uDao.getByRewards(user_id);
		double expense=uDao.getByTotalExpense(user_id);
		double totalExpense=expense+purchase;
		
		

		 double netBal=currentBalance-purchase;
		 if(purchase>50)
		 {
			rewards=rewards+10; 
			//return "Congrats u won rewards";
		 }
		 uDao.getByChangeBal(netBal, user_id);
		 uDao.getByUpdateRewards(rewards, user_id);
		 uDao.getByChangeTotalExp(totalExpense, user_id);
		 return "purchased";
		
		
		
	}
	
	
	

}
