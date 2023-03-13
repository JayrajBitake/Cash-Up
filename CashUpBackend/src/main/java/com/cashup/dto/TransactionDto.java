package com.cashup.dto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.stereotype.Repository;

import com.cashup.model.Redeem;
import com.cashup.model.UserRegister;

public class TransactionDto {
	
	
	private int tid;
	private Date tDate;
	
	private double tamount;
	private Integer pointsEarned;
	@Enumerated(EnumType.STRING)
	private Redeem isRedeemed;
	private int uid;
	
	
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
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;

}
}
