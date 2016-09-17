package com.tesco.rs.dto;

import com.tesco.rs.constant.Dto;

public class ProductDto implements Dto{
	public String id;
	public String productName;
	public String productDescription;
	public String retailPrice;
	public ProductLocation productLocation;




	public String getId() {
		return id;
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
}
