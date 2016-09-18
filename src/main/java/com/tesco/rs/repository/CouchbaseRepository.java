package com.tesco.rs.repository;

import java.util.List;
import java.util.Map;

public interface CouchbaseRepository {

	public Boolean createDocument(String id, String result);

	public Boolean setDocument(String id, String result);

	public Map<String, Object> getBulk(List<String> ids);

	public Object getDocument(String id);

	public Boolean updateDocument(String id, String result);

	public Boolean deleteDocument(String id);
}
