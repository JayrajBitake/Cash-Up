package com.cashup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashup.dao.UserDao;
import com.cashup.dao.VendorDao;
import com.cashup.model.Vendor;
@Service
public class VendorServiceImpl implements VendorService {
	@Autowired 
	private VendorDao ven;

	@Override
	public void add(Vendor vendor) {
		// TODO Auto-generated method stub
		ven.save(vendor);
		
	}

	

}
