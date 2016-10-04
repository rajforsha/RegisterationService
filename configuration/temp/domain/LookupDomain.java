package com.tesco.rs.domain;

import java.util.List;

public class LookupDomain {
	public String rootId;
	public List<String> childIds;
	public String getRootId() {
		return rootId;
	}
	public void setRootId(String rootId) {
		this.rootId = rootId;
	}
	public List<String> getChildIds() {
		return childIds;
	}
	public void setChildIds(List<String> childIds) {
		this.childIds = childIds;
	}

	
}
