package com.tesco.rs.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tesco.rs.constant.Domain;

/**
 * @author vagrant
 *
 */
public class Registeration implements Domain {

	private static final long serialVersionUID = 1212069745626480714L;
	private String id;
	private String name;
	@JsonProperty("address")
	private Address address;
	@JsonProperty("bankAccountsDetails")
	private BankAccountDetails bankAccountsDetails;
	@JsonProperty("kycDetails")
	private KYCDeatils kycDetails;
	@JsonProperty("vehicleInfo")
	private VehicleInfo vehicleInfo;
	@JsonProperty("packageTypePreference")
	private PackageTypePreference packageTypePreference;

	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the bankAccountsDetails
	 */
	public BankAccountDetails getBankAccountsDetails() {
		return bankAccountsDetails;
	}

	/**
	 * @param bankAccountsDetails
	 *            the bankAccountsDetails to set
	 */
	public void setBankAccountsDetails(BankAccountDetails bankAccountsDetails) {
		this.bankAccountsDetails = bankAccountsDetails;
	}

	/**
	 * @return the kycDetails
	 */
	public KYCDeatils getKycDetails() {
		return kycDetails;
	}

	/**
	 * @param kycDetails
	 *            the kycDetails to set
	 */
	public void setKycDetails(KYCDeatils kycDetails) {
		this.kycDetails = kycDetails;
	}

	/**
	 * @return the vehicleInfo
	 */
	public VehicleInfo getVehicleInfo() {
		return vehicleInfo;
	}

	/**
	 * @param vehicleInfo
	 *            the vehicleInfo to set
	 */
	public void setVehicleInfo(VehicleInfo vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}

	/**
	 * @return the packageTypePreference
	 */
	public PackageTypePreference getPackageTypePreference() {
		return packageTypePreference;
	}

	/**
	 * @param packageTypePreference
	 *            the packageTypePreference to set
	 */
	public void setPackageTypePreference(PackageTypePreference packageTypePreference) {
		this.packageTypePreference = packageTypePreference;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Registeration [name=" + name + ", address=" + address + ", bankAccountsDetails=" + bankAccountsDetails
				+ ", kycDetails=" + kycDetails + ", vehicleInfo=" + vehicleInfo + ", packageTypePreference="
				+ packageTypePreference + "]";
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
