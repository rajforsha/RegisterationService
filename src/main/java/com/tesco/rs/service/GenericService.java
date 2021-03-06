package com.tesco.rs.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tesco.rs.constant.Domain;
import com.tesco.rs.dto.ResponseDto;

/**
 * @author vagrant
 *
 */
public interface GenericService {

	public void create(Domain entity, Class<?> cls) throws JsonProcessingException, IOException;

	public ResponseDto<?> findOne(String id, Class<?> cls) throws JsonParseException, JsonMappingException, IOException;

	public ResponseDto<?> findAll(Class<?> cls) throws JsonParseException, JsonMappingException, IOException;

	public void update(Domain enity, Class<?> cls) throws JsonParseException, JsonMappingException, IOException;

	public void delete(String id) throws JsonParseException, JsonMappingException, IOException;
}
