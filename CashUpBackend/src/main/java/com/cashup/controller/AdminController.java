package com.cashup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cashup.dao.UserDao;
import com.cashup.dao.VendorDao;
import com.cashup.model.UserRegister;
import com.cashup.model.Vendor;
import com.cashup.services.VendorService;
@RestController
public class AdminController {
	
	@Autowired
	private VendorService vService;
	@PostMapping(value = {"/addvendor"}) 
	public String vendorAdd(@RequestBody Vendor vendor) {
		vService.add(vendor);
		return "Vendor Added";
	}

}
