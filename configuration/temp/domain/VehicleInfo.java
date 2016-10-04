package com.tesco.rs.domain;

import java.util.List;

/**
 * @author vagrant
 *
 */
public class VehicleInfo {

	private List<String> type;
	private String registrationNo;

	/**
	 * @return the type
	 */
	public List<String> getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(List<String> type) {
		this.type = type;
	}

	/**
	 * @return the registrationNo
	 */
	public String getRegistrationNo() {
		return registrationNo;
	}

	/**
	 * @param registrationNo
	 *            the registrationNo to set
	 */
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VehicleInfo [type=" + type + ", registrationNo=" + registrationNo + "]";
	}

}
