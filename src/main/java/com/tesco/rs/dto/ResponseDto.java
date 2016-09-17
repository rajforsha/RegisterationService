package com.tesco.rs.dto;

import java.util.List;
import java.util.Set;

public class ResponseDto<T> {
	private Integer total;
	private Set<String> missingSet;
	private List<T> content;
	private Integer pageNumber;
	private Integer pageSize;
	private Integer totalElements;
	private Integer totalPages;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Set<String> getMissingSet() {
		return missingSet;
	}

	public void setMissingSet(Set<String> missingSet) {
		this.missingSet = missingSet;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

}