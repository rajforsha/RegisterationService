package com.tesco.rs.service.impl;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tesco.rs.constant.Domain;
import com.tesco.rs.couchbase.CouchbaseWrapper;
import com.tesco.rs.service.RegisterationService;

/**
 * @author vagrant
 *
 */
public class RegisterationServiceImpl implements RegisterationService {
	private ObjectMapper mapper;
	private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RegisterationServiceImpl.class);

	public RegisterationServiceImpl() {
		this.mapper = new ObjectMapper();
	}

	public Boolean create(Domain entity, Class<?> cls) throws JsonProcessingException, IOException {
		String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entity);
		return CouchbaseWrapper.createDocument("1001", result);
	}

	public Domain findOne(String id, Class<?> cls) throws JsonParseException, JsonMappingException, IOException {
		Object obj = CouchbaseWrapper.getDocument(id);
		logger.info("object returned is::" + obj.toString());
		return (Domain) mapper.readValue(String.valueOf(obj), cls);
	}

	public List<Domain> findAll() throws JsonParseException, JsonMappingException, IOException {
		return null;
	}

	public void update(Domain enity, Class<?> cls) throws JsonParseException, JsonMappingException, IOException {

	}

	public void delete(String id) throws JsonParseException, JsonMappingException, IOException {

	}

	public void afterCreate(Domain user) throws JsonParseException, JsonMappingException, IOException {

	}

	public void afterDelete(String id) throws JsonParseException, JsonMappingException, IOException {

	}

}
