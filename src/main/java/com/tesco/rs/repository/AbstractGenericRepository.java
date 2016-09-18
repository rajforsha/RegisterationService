package com.tesco.rs.repository;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tesco.rs.couchbase.CouchbaseWrapper;

/**
 * @author shashi
 *
 */
public abstract class AbstractGenericRepository implements CouchbaseRepository {

	public abstract CouchbaseRepository getRepository();

	public Boolean createDocument(String id, String result) {
		getRepository().getCouchbaseWrapper();
		return CouchbaseWrapper.createDocument(id, result);
	}

	public Boolean setDocument(String id, String result) {
		getRepository().getCouchbaseWrapper();
		return CouchbaseWrapper.setDocument(id, result);
	}

	public Map<String, Object> getBulk(List<String> ids) {
		try {
			getRepository().getCouchbaseWrapper();
			return CouchbaseWrapper.getBulk(ids);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object getDocument(String id) {
		try {
			getRepository().getCouchbaseWrapper();
			return CouchbaseWrapper.getDocument(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return id;
	}

	public Boolean updateDocument(String id, String result) {
		try {
			getRepository().getCouchbaseWrapper();
			return CouchbaseWrapper.updateDocument(id, result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean deleteDocument(String id) {
		try {
			getRepository().getCouchbaseWrapper();
			return CouchbaseWrapper.deleteDocument(id);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
