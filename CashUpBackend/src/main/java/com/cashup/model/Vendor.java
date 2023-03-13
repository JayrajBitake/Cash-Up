package com.cashup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendor")
public class Vendor{
 @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vid;
	private  String title;
	private String description;
	private double price1;
	private float duration;
	private String brandName;
	private String image;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice1() {
		return price1;
	}
	public void setPrice1(double price1) {
		this.price1 = price1;
	}
//	public double getPrice3() {
//		return price3;
//	}
//	public void setPrice3(double price3) {
//		this.price3 = price3;
//	}
//	public double getPrice2() {
//		return price2;
//	}
//	public void setPrice2(double price2) {
//		this.price2 = price2;
//	}
	public float getDuration() {
		return duration;
	}
	public void setDuration(float duration) {
		this.duration = duration;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	

}
