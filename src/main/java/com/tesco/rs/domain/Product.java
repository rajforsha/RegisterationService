package com.tesco.rs.domain;

import com.tesco.rs.constant.Domain;

public class Product implements Domain {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6445600476116946037L;
	public String id;
	public String imgUrl;
	public String productName;
	public String productDescription;
	public String retailPrice;
	public ProductLocation productLocation;

	
	/**
	 * @return the imgUrl
	 */
	public String getImgUrl() {
		return imgUrl;
	}

	/**
	 * @param imgUrl the imgUrl to set
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(String retailPrice) {
		this.retailPrice = retailPrice;
	}

	public ProductLocation getProductLocation() {
		return productLocation;
	}

	public void setProductLocation(ProductLocation productLocation) {
		this.productLocation = productLocation;
	}

	public static class ProductLocation {
		public String latitude;
		public String longitude;

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
		return "Product [id=" + id + ", imgUrl=" + imgUrl + ", productName=" + productName + ", productDescription="
				+ productDescription + ", retailPrice=" + retailPrice + ", productLocation=" + productLocation + "]";
	}
	
	
}
