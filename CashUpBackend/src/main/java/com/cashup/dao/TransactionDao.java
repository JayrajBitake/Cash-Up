package com.cashup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cashup.model.Transaction;
import com.cashup.model.UserRegister;
@Repository
public interface TransactionDao  extends JpaRepository<Transaction, Integer> {
	
	
	
		

}

