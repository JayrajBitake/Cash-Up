package com.cashup.services;

import com.cashup.model.Transaction;
import com.cashup.model.UserRegister;

public interface TransactionService {
	
	void create(Transaction tx);
	Transaction  getById(int id);

}
