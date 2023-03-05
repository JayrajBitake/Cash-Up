package com.cashup.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cashup.model.UserRegister;

@Repository
public interface UserDao extends JpaRepository<UserRegister, Integer> {
	@Query(value = "select b from users b where b.uname = :uname and b.pass = :pass")
	public static UserRegister selectByName(@Param(value = "uname") String username,@Param(value = "pass") String pass) {
		// TODO Auto-generated method stub
		return null;
	}
	@Query(value = "select sum(balance) from users where uid=:uid",nativeQuery=true)
	public double getByAddBalance(@Param("uid") int uid);
	@Modifying
	@Query(value = "update users set balance=:new_bal where uid=:uid",countQuery="update users set balance=:new_bal where uid=:uid" ,nativeQuery=true)
	@Transactional
	public void getByChangeBal(@Param("new_bal") double new_bal,@Param("uid") int uid);
	
	@Query(value = "select sum(reward_points) from users where uid=:uid",nativeQuery=true)
	public double getByRewards(@Param("uid") int uid);
	 @Modifying 
	@Query(value = "update users set reward_points=:new_rewards where uid=:uid",countQuery="update users set reward_points=:new_rewards where uid=:uid" ,nativeQuery=true)
	 @Transactional
	public void getByUpdateRewards(@Param("new_rewards") double new_bal,@Param("uid") int uid);



	
	

	
	
	
}
