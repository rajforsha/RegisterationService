package com.tesco.rs.service.impl;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tesco.rs.constant.Domain;
import com.tesco.rs.service.RegisterationService;

/**
 * @author vagrant
 *
 */
public class RegisterationServiceImpl implements RegisterationService {

	public Boolean create(Domain entity, Class<?> cls) throws JsonProcessingException, IOException {
		return null;
	}

	public Domain findOne(String id, Class<?> cls) throws JsonParseException, JsonMappingException, IOException {
		return null;
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
