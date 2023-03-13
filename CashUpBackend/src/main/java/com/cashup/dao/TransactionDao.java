package com.cashup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.cashup.dto.TransactionDto;
import com.cashup.model.Transaction;
import com.cashup.model.UserRegister;
@Repository
public interface TransactionDao  extends JpaRepository<Transaction, Integer> {
	
//	@Query(value = "insert into transaction(is_redeemed,t_date,tamount,uid) values()",countQuery="insert into transaction values(points_earned=:points_earned)" ,nativeQuery=true)
//	 @Transactional//manually commit tx
//	public void create(@RequestBody TransactionDto txd);

		
	
	
	
//	@Query(value = "select sum(points_earned) from transaction where tid=:tid",nativeQuery=true)
//	public double getByPointsEarned(@Param("tid") int tid);
	 @Modifying 
	//@Query(value = "insert into transaction(points_earned) values(points_earned=:points_earned)",countQuery="insert into transaction values(points_earned=:points_earned)" ,nativeQuery=true)
	 @Query(value = "update transaction set points_earned=:points_earned where tid=:tid",countQuery="update transaction set points_earned=:points_earned where tid=:tid" ,nativeQuery=true)
	 @Transactional//manually commit tx
	public void getByUpdatePointsEarned(@Param("points_earned") double points_earned,@Param("tid") int tid);
	 
	 @Modifying 
	 @Query(value = "update transaction set tamount=:tamount where tid=:tid",countQuery="update transaction set  tamount=:tamount where tid=:tid" ,nativeQuery=true)
	 @Transactional//manually commit tx
	public void getByUpdateTamount(@Param("tamount") double  tamount,@Param("tid") int tid);
	 
	 
	 @Query(value="select * from transaction where uid=:uid",nativeQuery=true)
		public List<Transaction> findUserId(@Param("uid") int id);
	 
	
}

