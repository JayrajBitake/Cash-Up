package com.cashup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="users")
public class UserRegister {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
//	  @NotBlank(message = "Please enter proper employee name")
//	    @Size(min=5, message = "Name should be atleast 5 characters")
//	    @Size(max=12, message = "Name should not be greater than 12 characters")
	private String uname;
//	 @Email(message = "Please enter a valid email Id", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
//	    @NotNull(message = "Please enter a valid email Id")
	private String email;
	private String pass;
	 @Column(columnDefinition = "integer default 0")
	private Double balance;
	 @NotBlank(message = "Please enter proper city name")
	private String city;
	 @Size(max=10, message = "Mobile No should be 10 digits")
	 @Size(max=10, message = "Mobile No should be 10 digits")
	private String mobileno;
	
	 @Column(columnDefinition = "integer default 0")
	private Integer rewardPoints;
	
	 @Column(columnDefinition = "integer default 0")
	private Double totalExpense;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="userRegister")
	@JsonIgnore
	private List<Transaction> userTransactions;
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public List<Transaction> getUserTransactions() {
		return userTransactions;
	}
	public void setUserTransactions(List<Transaction> userTransactions) {
		this.userTransactions = userTransactions;
	}
	public Integer getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public Double getTotalExpense() {
		return totalExpense;
	}
	public void setTotalExpense(Double totalExpense) {
		this.totalExpense = totalExpense;
	}
	
	
	
	

}
