package com.tesco.rs.domain;

import com.tesco.rs.constant.Domain;

public class BookingAcknowledgement implements Domain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3232122888111372081L;
	public String id;
	public String status;
	public String superHeroName;
	public String superHeroCurrentLat;
	public String superHeroCurrentLong;
	public String customerLat;
	public String customerLong;
	public String productLat;
	public String productLong;
	public String superHeroCharge;
	

	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the superHeroName
	 */
	public String getSuperHeroName() {
		return superHeroName;
	}
	/**
	 * @param superHeroName the superHeroName to set
	 */
	public void setSuperHeroName(String superHeroName) {
		this.superHeroName = superHeroName;
	}
	/**
	 * @return the superHeroCurrentLat
	 */
	public String getSuperHeroCurrentLat() {
		return superHeroCurrentLat;
	}
	/**
	 * @param superHeroCurrentLat the superHeroCurrentLat to set
	 */
	public void setSuperHeroCurrentLat(String superHeroCurrentLat) {
		this.superHeroCurrentLat = superHeroCurrentLat;
	}
	/**
	 * @return the superHeroCurrentLong
	 */
	public String getSuperHeroCurrentLong() {
		return superHeroCurrentLong;
	}
	/**
	 * @param superHeroCurrentLong the superHeroCurrentLong to set
	 */
	public void setSuperHeroCurrentLong(String superHeroCurrentLong) {
		this.superHeroCurrentLong = superHeroCurrentLong;
	}
	/**
	 * @return the customerLat
	 */
	public String getCustomerLat() {
		return customerLat;
	}
	/**
	 * @param customerLat the customerLat to set
	 */
	public void setCustomerLat(String customerLat) {
		this.customerLat = customerLat;
	}
	/**
	 * @return the customerLong
	 */
	public String getCustomerLong() {
		return customerLong;
	}
	/**
	 * @param customerLong the customerLong to set
	 */
	public void setCustomerLong(String customerLong) {
		this.customerLong = customerLong;
	}
	/**
	 * @return the productLat
	 */
	public String getProductLat() {
		return productLat;
	}
	/**
	 * @param productLat the productLat to set
	 */
	public void setProductLat(String productLat) {
		this.productLat = productLat;
	}
	/**
	 * @return the productLong
	 */
	public String getProductLong() {
		return productLong;
	}
	/**
	 * @param productLong the productLong to set
	 */
	public void setProductLong(String productLong) {
		this.productLong = productLong;
	}
	/**
	 * @return the superHeroCharge
	 */
	public String getSuperHeroCharge() {
		return superHeroCharge;
	}
	/**
	 * @param superHeroCharge the superHeroCharge to set
	 */
	public void setSuperHeroCharge(String superHeroCharge) {
		this.superHeroCharge = superHeroCharge;
	}

	
}
