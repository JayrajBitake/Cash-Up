package com.cashup.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="transaction")
public class Transaction {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	private Date tDate;
	 @Column(columnDefinition = "integer default 0")
	private double tamount;
	 
	 @Column(columnDefinition = "integer default 0")
	private Integer pointsEarned;
	 
	 @Enumerated(EnumType.STRING)
	private Redeem isRedeemed;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="uid")
	private UserRegister userRegister;
	
	
	
	public Integer getPointsEarned() {
		return pointsEarned;
	}
	public void setPointsEarned(Integer pointsEarned) {
		this.pointsEarned = pointsEarned;
	}
	public Redeem getIsRedeemed() {
		return isRedeemed;
	}
	public void setIsRedeemed(Redeem isRedeemed) {
		this.isRedeemed = isRedeemed;
	}
	public UserRegister getUserRegister() {
		return userRegister;
	}
	public void setUserRegister(UserRegister userRegister) {
		this.userRegister = userRegister;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public Date gettDate() {
		return tDate;
	}
	public void settDate(Date tDate) {
		this.tDate = tDate;
	}
	
	public double getTamount() {
		return tamount;
	}
	public void setTamount(double tamount) {
		this.tamount = tamount;
	}

	
}
