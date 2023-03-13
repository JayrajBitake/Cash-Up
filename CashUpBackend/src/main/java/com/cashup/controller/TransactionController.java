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
import com.cashup.dao.VendorDao;
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
	private VendorDao vDao;
	@Autowired
	private TransactionDao tDao;
	
	
	
	@PostMapping(value = {"/createtx/{uid}/{vid}/{price}"}) 
	public String txAdd(@RequestBody TransactionDto txd,@PathVariable  String uid,@PathVariable  String vid,@PathVariable  Double price ) {
		//List<Transaction> userTransactions =new ArrayList<>();
		//userTransactions.add(tx);
		//ureg.setUserTransactions(userTransactions);
		int v_id=Integer.parseInt(vid);
		
		//List<Double> pricelist=vDao.getByPriceById(v_id);
		double purchase=price;
		
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
		int txid=txd.getTid();
		 tservice.create(txd);
//		 System.out.println(txd.getTamount());
//		 System.out.println(txd.gettDate());
		 List<Transaction> list=tDao.findAll();
		 Transaction last = list.get(list.size() - 1);
		 
		 System.out.println(last.getTid());
		 
			
		 
		 if(purchase>=50)
		 {
			 System.out.println(purchase);
			 double pointsEarned=20*Math.random();
			 System.out.println(pointsEarned);
			rewards=rewards+pointsEarned ; 
			 tDao.getByUpdatePointsEarned(pointsEarned,last.getTid());
			 
			//return "Congrats u won rewards";
		 }
		 tDao.getByUpdateTamount(purchase,last.getTid());
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
