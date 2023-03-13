package com.cashup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cashup.model.UserRegister;
import com.cashup.model.Vendor;

public interface VendorDao  extends JpaRepository<Vendor, Integer> {
	
	@Query(value = "select  price1,price2,price3 from vendor where vid=:vid",nativeQuery=true)
	public List<Double> getByPriceById(@Param("vid") int vid);
	
	@Query(value = "select brand_name from vendor brand_name where  brand_name.brand_name =:brand_name",nativeQuery=true)
	public List<Vendor> findByName(@Param(value = "brand_name") String  brand_name);

}
