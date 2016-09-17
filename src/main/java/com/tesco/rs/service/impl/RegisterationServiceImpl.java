package com.tesco.rs.service.impl;

import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tesco.rs.constant.Domain;
import com.tesco.rs.couchbase.CouchbaseWrapper;
import com.tesco.rs.domain.Registeration;
import com.tesco.rs.dto.ResponseDto;
import com.tesco.rs.service.RegisterationService;

/**
 * @author vagrant
 *
 */
public class RegisterationServiceImpl implements RegisterationService {
	private ObjectMapper mapper;
	@SuppressWarnings("unused")
	private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RegisterationServiceImpl.class);

	public RegisterationServiceImpl() {
		this.mapper = new ObjectMapper();
	}

	public ResponseDto<String> create(Domain entity, Class<?> cls) throws JsonProcessingException, IOException {
		String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entity);
		CouchbaseWrapper.createDocument(entity.getId(), result);
		ResponseDto<String> rDto = new ResponseDto<String>();
		rDto.setContent(Arrays.asList(entity.getId()));
		return rDto;
	}

	public ResponseDto<Registeration> findOne(String id, Class<?> cls)
			throws JsonParseException, JsonMappingException, IOException {
		Object obj = CouchbaseWrapper.getDocument(id);
		ResponseDto<Registeration> rDto = new ResponseDto<Registeration>();
		rDto.setContent(Arrays.asList((Registeration) mapper.readValue(String.valueOf(obj), cls)));
		return rDto;
	}

	public ResponseDto<Registeration> findAll() throws JsonParseException, JsonMappingException, IOException {
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
