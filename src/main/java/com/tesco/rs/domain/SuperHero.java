package com.tesco.rs.domain;

import javax.validation.constraints.NotNull;

import com.tesco.rs.constant.Domain;

public class SuperHero implements Domain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String id;
	@NotNull
	public String superHeroName;
	@NotNull
	public String minimumPrice;
	@NotNull
	public String rate;
	@NotNull
	public String carryingCapacity;
	public Address superHeroAddress;

	
	

	public String getMinimumPrice() {
		return minimumPrice;
	}




	public void setMinimumPrice(String minimumPrice) {
		this.minimumPrice = minimumPrice;
	}




	public String getRate() {
		return rate;
	}




	public void setRate(String rate) {
		this.rate = rate;
	}




	public String getCarryingCapacity() {
		return carryingCapacity;
	}




	public void setCarryingCapacity(String carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
	}




	public String getSuperHeroName() {
		return superHeroName;
	}




	public void setSuperHeroName(String superHeroName) {
		this.superHeroName = superHeroName;
	}




	public Address getSuperHeroAddress() {
		return superHeroAddress;
	}




	public void setSuperHeroAddress(Address superHeroAddress) {
		this.superHeroAddress = superHeroAddress;
	}




	public void setId(String id) {
		this.id = id;
	}




	public static class Address {
		public String addressLine1;
		public String addressLine2;
		public String city;
		public String state;
		public String pinCode;
		public String latitude;
		public String longitude;

		public String getAddressLine1() {
			return addressLine1;
		}

		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}

		public String getAddressLine2() {
			return addressLine2;
		}

		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getPinCode() {
			return pinCode;
		}

		public void setPinCode(String pinCode) {
			this.pinCode = pinCode;
		}

		public String getLatitude() {
			return latitude;
		}

		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}

		public String getLongitude() {
			return longitude;
		}

		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}

	}




	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SuperHero [id=" + id + ", superHeroName=" + superHeroName + ", minimumPrice=" + minimumPrice + ", rate="
				+ rate + ", carryingCapacity=" + carryingCapacity + ", superHeroAddress=" + superHeroAddress + "]";
	}
	
	
}
