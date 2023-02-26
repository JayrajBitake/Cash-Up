package com.cashup.services;

import java.util.Optional;

import com.cashup.dao.TransactionDao;
import com.cashup.dao.UserDao;
import com.cashup.model.Transaction;
import com.cashup.model.UserRegister;

public class TransactionServiceImpl implements TransactionService {
	private TransactionDao tdao;
	@Override
	public void create(Transaction tx) {
		
		tdao.save(tx);
	}

	@Override
	public Transaction getById(int id) {
		Optional<Transaction> t = tdao.findById(id);
		if(t.isPresent()) {
			return t.get();
		}
		return null;
		
	
	}

}
