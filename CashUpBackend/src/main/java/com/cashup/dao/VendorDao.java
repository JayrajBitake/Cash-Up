package com.cashup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cashup.model.UserRegister;
import com.cashup.model.Vendor;

public interface VendorDao  extends JpaRepository<Vendor, Integer> {
	

}
