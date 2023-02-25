package com.cashup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cashup.model.Transaction;
import com.cashup.model.UserRegister;
import com.cashup.services.TransactionService;
import com.cashup.services.UserService;

public class TransactionController {
	@Autowired
	private TransactionService tservice;
	
	@PostMapping(value = {"/transaction"}) 
	public String productAdd(@RequestBody Transaction tx) {
		tservice.create(tx);
		return "Sucess";
	}
	@GetMapping(value = {"/transaction/{id}"})
	public Transaction tanxGet(@PathVariable int id) {
		return tservice.getById(id);
	}
	
	
	

}
