package com.tesco.rs.domain;

/**
 * @author vagrant
 *
 */
public class BankAccountDetails {

	private String accountNo;
	private String name;
	private String MICR;
	private String IFSC;

	/**
	 * @return the accountNo
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * @param accountNo
	 *            the accountNo to set
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mICR
	 */
	public String getMICR() {
		return MICR;
	}

	/**
	 * @param mICR
	 *            the mICR to set
	 */
	public void setMICR(String mICR) {
		MICR = mICR;
	}

	/**
	 * @return the iFSC
	 */
	public String getIFSC() {
		return IFSC;
	}

	/**
	 * @param iFSC
	 *            the iFSC to set
	 */
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankAccountDetails [accountNo=" + accountNo + ", name=" + name + ", MICR=" + MICR + ", IFSC=" + IFSC
				+ "]";
	}

}
