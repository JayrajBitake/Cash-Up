package com.cashup.services;

import java.util.List;

import com.cashup.dto.TransactionDto;
import com.cashup.model.Transaction;


public interface TransactionService {
	
	void create(TransactionDto txd);
	
	List <Transaction>  getById(int id);
	

}
