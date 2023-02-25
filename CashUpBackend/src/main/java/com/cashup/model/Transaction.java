package com.cashup.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="transaction")
public class Transaction {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String tid;
	private Date tDate;
	private double currentBalance;
	private double tamount;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public Date gettDate() {
		return tDate;
	}
	public void settDate(Date tDate) {
		this.tDate = tDate;
	}
	public double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	public double getTamount() {
		return tamount;
	}
	public void setTamount(double tamount) {
		this.tamount = tamount;
	}

	
}
