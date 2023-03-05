package com.cashup.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cashup.dao.TransactionDao;

import com.cashup.model.Transaction;

@Service
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
