package com.cashup.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cashup.dao.TransactionDao;
import com.cashup.dao.UserDao;
import com.cashup.dto.TransactionDto;
import com.cashup.model.Transaction;
import com.cashup.model.UserRegister;
import com.cashup.model.Vendor;
import com.cashup.services.TransactionService;
import com.cashup.services.UserService;
@RestController
public class TransactionController {
	@Autowired
	private TransactionService tservice;
	@Autowired
	private UserDao uDao;
	@Autowired
	private Vendor vendor;
	
	
	
	@PostMapping(value = {"/createtx/{uid}"}) 
	public String txAdd(@RequestBody TransactionDto txd,@PathVariable  String uid) {
		//List<Transaction> userTransactions =new ArrayList<>();
		//userTransactions.add(tx);
		//ureg.setUserTransactions(userTransactions);
		
		tservice.create(txd);
		double purchase=vendor.getPrice1();
		int user_id=Integer.parseInt(uid);
		//sint t_id=Integer.parseInt(tid);
		double currentBalance=uDao.getByAddBalance(user_id);
		double rewards=uDao.getByRewards(user_id);
		double expense=uDao.getByTotalExpense(user_id);
		double totalExpense=expense+purchase;
		
		
		if(purchase>currentBalance)
		{
			return "insufficient balance";
		}

		 double netBal=currentBalance-purchase;
		 double pointsEarned=20*Math.random();
		 
		 if(purchase>50)
		 {
			rewards=rewards+pointsEarned ; 
			 //tDao.getByUpdatePointsEarned(pointsEarned, t_id);
			//return "Congrats u won rewards";
		 }
		 
		 uDao.getByChangeBal(netBal, user_id);
		 uDao.getByUpdateRewards(rewards, user_id);
		 uDao.getByChangeTotalExp(totalExpense, user_id);
		
		 return "purchased";
		
		
	}
	
//	@PostMapping(value = {"/createtx"}) 
//	public String txAdd(@RequestBody TransactionDto txd) {
//		tservice.create(txd);
//		return "Sucess";
//	}
	
	
	
	@GetMapping(value = {"/transaction/{id}"})
	public List<Transaction> tanxGet(@PathVariable int id) {
		return tservice.getById(id);
	}
	
	

}
