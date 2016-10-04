package com.tesco.rs.domain;

import com.tesco.rs.constant.Domain;

public class BookSuperHero implements Domain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3232122888111372081L;
	public String id;
	public String customerName;
	public String customerAddressLine1;
	public String customerLatitude;
	public String customerLongitude;
	public String productId;
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
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the customerAddressLine1
	 */
	public String getCustomerAddressLine1() {
		return customerAddressLine1;
	}
	/**
	 * @param customerAddressLine1 the customerAddressLine1 to set
	 */
	public void setCustomerAddressLine1(String customerAddressLine1) {
		this.customerAddressLine1 = customerAddressLine1;
	}
	/**
	 * @return the customerLatitude
	 */
	public String getCustomerLatitude() {
		return customerLatitude;
	}
	/**
	 * @param customerLatitude the customerLatitude to set
	 */
	public void setCustomerLatitude(String customerLatitude) {
		this.customerLatitude = customerLatitude;
	}
	/**
	 * @return the customerLongitude
	 */
	public String getCustomerLongitude() {
		return customerLongitude;
	}
	/**
	 * @param customerLongitude the customerLongitude to set
	 */
	public void setCustomerLongitude(String customerLongitude) {
		this.customerLongitude = customerLongitude;
	}
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BookSuperHero [id=" + id + ", customerName=" + customerName + ", customerAddressLine1="
				+ customerAddressLine1 + ", customerLatitude=" + customerLatitude + ", customerLongitude="
				+ customerLongitude + ", productId=" + productId + "]";
	}

}
