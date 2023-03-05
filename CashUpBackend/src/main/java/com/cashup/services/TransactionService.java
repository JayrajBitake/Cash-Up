package com.cashup.services;

import com.cashup.model.Transaction;


public interface TransactionService {
	
	void create(Transaction tx);
	Transaction  getById(int id);
	

}
