package com.cashup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cashup.model.Transaction;
import com.cashup.model.UserRegister;
@Repository
public interface TransactionDao  extends JpaRepository<Transaction, Integer> {
	
	
//	@Query(value = "select sum(points_earned) from transaction where tid=:tid",nativeQuery=true)
//	public double getByPointsEarned(@Param("tid") int tid);
	 @Modifying 
	@Query(value = "update transaction set points_earned=:points_earned where tid=:tid",countQuery="update transaction set points_earned=:points_earned where tid=:tid" ,nativeQuery=true)
	 @Transactional//manually commit tx
	public void getByUpdatePointsEarned(@Param("points_earned") double new_bal,@Param("tid") int tid);
	 
	
}

