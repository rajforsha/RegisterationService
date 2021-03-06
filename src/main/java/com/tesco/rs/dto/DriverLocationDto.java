package com.tesco.rs.dto;

import com.tesco.rs.constant.Dto;

/**
 * @author vagrant
 *
 */
public class DriverLocationDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -352257839219745122L;
	private String driverName;
	private String longitude;
	private String latitude;

	/**
	 * @return the driverName
	 */
	public String getDriverName() {
		return driverName;
	}

	/**
	 * @param driverName
	 *            the driverName to set
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
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
		return "DriverLocationDto [driverName=" + driverName + ", longitude=" + longitude + ", latitude=" + latitude
				+ "]";
	}
}
