package com.tesco.rs.domain;

import java.util.List;

/**
 * @author vagrant
 *
 */
public class PackageTypePreference {

	private List<String> packageType;
	private Integer length;
	private Integer width;
	private Integer height;

	/**
	 * @return the packageType
	 */
	public List<String> getPackageType() {
		return packageType;
	}

	/**
	 * @param packageType
	 *            the packageType to set
	 */
	public void setPackageType(List<String> packageType) {
		this.packageType = packageType;
	}

	/**
	 * @return the length
	 */
	public Integer getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(Integer length) {
		this.length = length;
	}

	/**
	 * @return the width
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PackageTypePreference [packageType=" + packageType + ", length=" + length + ", width=" + width
				+ ", height=" + height + "]";
	}

}
