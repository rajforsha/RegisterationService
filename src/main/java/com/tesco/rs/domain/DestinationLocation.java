package com.tesco.rs.domain;

import com.tesco.rs.constant.Domain;

/**
 * @author vagrant
 *
 */
public class DestinationLocation implements Domain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7589227707301331785L;
	private String userName;
	private String longitude;
	private String latitude;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
		return "DestinationLocation [userName=" + userName + ", longitude=" + longitude + ", latitude=" + latitude
				+ "]";
	}

}
