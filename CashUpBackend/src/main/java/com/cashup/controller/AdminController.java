package com.cashup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cashup.dao.UserDao;
import com.cashup.dao.VendorDao;
import com.cashup.model.UserRegister;
import com.cashup.model.Vendor;
import com.cashup.services.VendorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AdminController {
	
	@Autowired
	private VendorService vService;
	
	
	@PostMapping(value = {"/addvendor"}) 
	public String vendorAdd(@RequestBody Vendor vendor) {
		vService.add(vendor);
		return "Vendor Added";
	}
	
	@DeleteMapping(value = {"/deletevendor/{vid}"})
	public String vendorDelete1(@PathVariable int vid) {
		
		vService.removeById(vid);
		return " vendor removed successfuly";
	}
	
	@GetMapping(value = {"/vendors"})
	public List<Vendor> vendorList(){
		return vService.getAll();
	}
	
	@GetMapping(value = {"/vendorbyname/{bName}"})
	public List<Vendor> vendorListBybName(@PathVariable String bName){
		return vService.getAllByBrandName(bName);
	}

}
