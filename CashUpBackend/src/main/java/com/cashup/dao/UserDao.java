package com.cashup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cashup.model.UserRegister;

@Repository
public interface UserDao extends JpaRepository<UserRegister, Integer> {
	@Query(value = "select b from users b where b.uname = :uname and b.pass = :pass")
	public static UserRegister selectByName(@Param(value = "uname") String username,@Param(value = "pass") String pass) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
