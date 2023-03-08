package com.cashup.services;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public void removeById(int vid) {
		ven.deleteById(vid); 
		
	}

	@Override
	public List<Vendor> getAll() {
		Iterable<Vendor> itr = ven.findAll();
		List<Vendor> lst = new ArrayList<Vendor>();
		itr.forEach(vendor->lst.add(vendor));
		return lst;
	}

	@Override
	public List<Vendor> getAllByBrandName(String bName) {
		return ven.findByName(bName);
	}

	

}
