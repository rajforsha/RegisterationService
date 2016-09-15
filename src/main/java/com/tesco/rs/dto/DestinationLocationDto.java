package com.tesco.rs.dto;

import com.tesco.rs.constant.Dto;

/**
 * @author vagrant
 *
 */
public class DestinationLocationDto implements Dto {

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
		return "DestinationLocationDto [userName=" + userName + ", longitude=" + longitude + ", latitude=" + latitude
				+ "]";
	}
}
