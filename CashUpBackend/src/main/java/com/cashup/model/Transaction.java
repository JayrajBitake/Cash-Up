package com.cashup.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
	 @Column(columnDefinition = "varchar(255) default 'N'")
	private Character isRedeemed;
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserRegister ureg;
	
	
	
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
