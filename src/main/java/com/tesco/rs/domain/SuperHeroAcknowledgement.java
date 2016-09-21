package com.tesco.rs.domain;

import com.tesco.rs.constant.Domain;

public class SuperHeroAcknowledgement implements Domain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3232122888111372081L;
	public String id;
	public String superHeroName;
	public String superHeroCurrentLat;
	public String superHeroCurrentLong;
	public String customerLat;
	public String customerLong;
	public String productLat;
	public String productLong;
	public String superHeroCharge;
	public Boolean acknowledged;
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SuperHeroAcknowledgement [id=" + id + ", superHeroName=" + superHeroName + ", superHeroCurrentLat="
				+ superHeroCurrentLat + ", superHeroCurrentLong=" + superHeroCurrentLong + ", customerLat="
				+ customerLat + ", customerLong=" + customerLong + ", productLat=" + productLat + ", productLong="
				+ productLong + ", superHeroCharge=" + superHeroCharge + ", acknowledged=" + acknowledged + "]";
	}
	/**
	 * @return the acknowledged
	 */
	public Boolean getAcknowledged() {
		return acknowledged;
	}
	/**
	 * @param acknowledged the acknowledged to set
	 */
	public void setAcknowledged(Boolean acknowledged) {
		this.acknowledged = acknowledged;
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
