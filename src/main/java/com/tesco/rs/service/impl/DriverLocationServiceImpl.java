package com.tesco.rs.service.impl;

import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tesco.rs.constant.Domain;
import com.tesco.rs.couchbase.CouchbaseWrapper;
import com.tesco.rs.domain.DriverLocation;
import com.tesco.rs.dto.ResponseDto;
import com.tesco.rs.service.DriverLocationService;

/**
 * @author vagrant
 *
 */
public class DriverLocationServiceImpl implements DriverLocationService {

	private ObjectMapper mapper;

	public DriverLocationServiceImpl() {
		this.mapper = new ObjectMapper();
	}

	public ResponseDto<String> create(Domain entity, Class<?> cls) throws JsonProcessingException, IOException {

		String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entity);
		CouchbaseWrapper.createDocument(entity.getId(), result);
		ResponseDto<String> rDto = new ResponseDto<String>();
		rDto.setContent(Arrays.asList(entity.getId()));
		return rDto;
	}

	public ResponseDto<DriverLocation> findOne(String id, Class<?> cls)
			throws JsonParseException, JsonMappingException, IOException {
		Object obj = CouchbaseWrapper.getDocument(id);
		ResponseDto<DriverLocation> rDto = new ResponseDto<DriverLocation>();
		rDto.setContent(Arrays.asList((DriverLocation) mapper.readValue(String.valueOf(obj), cls)));
		return rDto;
	}

	public ResponseDto<DriverLocation> findAll() throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Domain enity, Class<?> cls) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub

	}

	public void delete(String id) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub

	}

	public void afterCreate(Domain user) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub

	}

	public void afterDelete(String id) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub

	}

}
