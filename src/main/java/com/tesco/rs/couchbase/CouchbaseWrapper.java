package com.tesco.rs.couchbase;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * @author vagrant
 *
 */
public class CouchbaseWrapper {
	public static boolean createDocument(String id, String result) {
		return CouchbaseResource.getClient().add(id, result) != null;
	}

	public static Object getDocument(String id) throws JsonParseException, JsonMappingException, IOException {
		return CouchbaseResource.getClient().get(id);
	}

	public static Boolean updateDocument(String id, String result) throws JsonProcessingException {
		return CouchbaseResource.getClient().replace(id, result) != null;
	}

	public static Boolean deleteDocument(String id) throws JsonProcessingException {
		return CouchbaseResource.getClient().delete(id) != null;
	}
}
