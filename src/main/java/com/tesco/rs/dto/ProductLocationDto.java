package com.tesco.rs.dto;

import com.tesco.rs.constant.Dto;

/**
 * @author vagrant
 *
 */
public class ProductLocationDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -601687849195534040L;
	private String productName;
	private String longitude;
	private String latitude;

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductLocationDto [productName=" + productName + ", longitude=" + longitude + ", latitude=" + latitude
				+ "]";
	}

}
