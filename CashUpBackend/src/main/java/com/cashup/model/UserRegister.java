package com.cashup.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="users")
public class UserRegister {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String uname;
	private String email;
	private String pass;
	private Double balance;
	private String city;
	private String mobileno;
	private Integer rewardPoints;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "uid")
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
	
	
	

}
