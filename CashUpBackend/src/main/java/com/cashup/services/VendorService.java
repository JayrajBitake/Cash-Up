package com.cashup.services;

import java.util.List;

import com.cashup.model.Vendor;

public interface VendorService {
	void add(Vendor vendor);
	void removeById(int vid);
	List<Vendor> getAll();
	List<Vendor> getAllByBrandName(String bName);
	
	
}
