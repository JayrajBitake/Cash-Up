package com.cashup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cashup.model.UserRegister;
import com.cashup.services.UserService;

@RestController
public class UserCotroller {
	@Autowired
	private UserService uservice;
	@PostMapping(value = {"/uregister"}) 
	public String productAdd(@RequestBody UserRegister ureg) {
		uservice.add(ureg);
		return "User Registered SucessFully";
	}
	@GetMapping(value = {"/balance/{id}"})
	public UserRegister balGet(@PathVariable int id) {
		return uservice.getById(id);
	}
	@GetMapping(value = {"/user/login/{username}/{pass}"})
	public UserRegister userLogin(@PathVariable String uname,@PathVariable String pass){
		return uservice.loadUserByUsername(uname,pass);
	}
	
	

}
