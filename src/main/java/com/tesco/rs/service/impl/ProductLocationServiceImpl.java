package com.tesco.rs.service.impl;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tesco.rs.constant.Domain;
import com.tesco.rs.constant.RootIdConstant;
import com.tesco.rs.couchbase.CouchbaseWrapper;
import com.tesco.rs.dto.ResponseDto;
import com.tesco.rs.service.ProductLocationService;

/**
 * @author vagrant
 *
 */
public class ProductLocationServiceImpl implements ProductLocationService {
	private ObjectMapper mapper;

	public ProductLocationServiceImpl() {
		this.mapper = new ObjectMapper();
	}

	@SuppressWarnings("static-access")
	public ResponseDto create(Domain entity, Class<?> cls) throws JsonProcessingException, IOException {
		String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entity);
		String id = RootIdConstant.productRootID + RootIdConstant.uid.randomUUID().toString();
		CouchbaseWrapper.createDocument(id, result);
		ResponseDto rDto = new ResponseDto();
		rDto.setId(id);
		return rDto;
	}

	public Domain findOne(String id, Class<?> cls) throws JsonParseException, JsonMappingException, IOException {
		Object obj = CouchbaseWrapper.getDocument(id);
		return (Domain) mapper.readValue(String.valueOf(obj), cls);
	}

	public List<Domain> findAll() throws JsonParseException, JsonMappingException, IOException {
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
