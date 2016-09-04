package com.tesco.rs.domain;

/**
 * @author vagrant
 *
 */
public class KYCDeatils {

	private String aadharNo;
	private String panCardNo;
	private String passportNo;
	private String drivingLicenceNo;

	/**
	 * @return the aadharNo
	 */
	public String getAadharNo() {
		return aadharNo;
	}

	/**
	 * @param aadharNo
	 *            the aadharNo to set
	 */
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	/**
	 * @return the panCardNo
	 */
	public String getPanCardNo() {
		return panCardNo;
	}

	/**
	 * @param panCardNo
	 *            the panCardNo to set
	 */
	public void setPanCardNo(String panCardNo) {
		this.panCardNo = panCardNo;
	}

	/**
	 * @return the passportNo
	 */
	public String getPassportNo() {
		return passportNo;
	}

	/**
	 * @param passportNo
	 *            the passportNo to set
	 */
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	/**
	 * @return the drivingLicenceNo
	 */
	public String getDrivingLicenceNo() {
		return drivingLicenceNo;
	}

	/**
	 * @param drivingLicenceNo
	 *            the drivingLicenceNo to set
	 */
	public void setDrivingLicenceNo(String drivingLicenceNo) {
		this.drivingLicenceNo = drivingLicenceNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "KYCDeatils [aadharNo=" + aadharNo + ", panCardNo=" + panCardNo + ", passportNo=" + passportNo
				+ ", drivingLicenceNo=" + drivingLicenceNo + "]";
	}

}
