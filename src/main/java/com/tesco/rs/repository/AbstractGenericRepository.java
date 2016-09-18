package com.tesco.rs.repository;

import java.util.List;
import java.util.Map;

import com.tesco.rs.couchbase.CouchbaseResource;

/**
 * @author shashi
 *
 */
public abstract class AbstractGenericRepository implements CouchbaseRepository {

	public abstract CouchbaseRepository getRepository();

	public Boolean createDocument(String id, String result) {
		return CouchbaseResource.getClient().add(id, result) != null;
	}

	public Boolean setDocument(String id, String result) {
		return CouchbaseResource.getClient().set(id, result) != null;
	}

	public Map<String, Object> getBulk(List<String> ids) {
		return CouchbaseResource.getClient().getBulk(ids);
	}

	public Object getDocument(String id) {
		return CouchbaseResource.getClient().get(id);
	}

	public Boolean updateDocument(String id, String result) {
		return CouchbaseResource.getClient().replace(id, result) != null;
	}

	public Boolean deleteDocument(String id) {
		return CouchbaseResource.getClient().delete(id) != null;
	}
	
}
