package com.cashup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashup.dao.TransactionDao;
import com.cashup.dao.UserDao;
import com.cashup.dto.TransactionDto;
import com.cashup.model.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionDao tdao;
	
	@Autowired
	private UserDao userDao;
	@Override
	public void create(TransactionDto txd) {
		Transaction tx= new Transaction();
		tx.setIsRedeemed(txd.getIsRedeemed());
		
		tx.setPointsEarned(txd.getPointsEarned());
		tx.settDate(txd.gettDate());
		tx.setTamount(txd.getTamount());
		tx.setUserRegister(userDao.findById(txd.getUid()).get());
		tdao.save(tx);
	}

	@Override
	public List<Transaction> getById(int id) {
		//Optional<Transaction> t = tdao.findById(id);
		return tdao.findUserId(id);
//		if(t.isPresent()) {
//			return t.get();
		//}
		//return null;
		
	
	}

	

}
