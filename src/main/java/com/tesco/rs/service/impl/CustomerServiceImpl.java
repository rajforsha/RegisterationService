package com.tesco.rs.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tesco.rs.constant.Domain;
import com.tesco.rs.couchbase.CouchbaseWrapper;
import com.tesco.rs.domain.Customer;
import com.tesco.rs.domain.LookupDomain;
import com.tesco.rs.dto.ResponseDto;
import com.tesco.rs.service.CustomerService;

/**
 * @author vagrant
 *
 */
public class CustomerServiceImpl implements CustomerService {
	private ObjectMapper mapper;
	@SuppressWarnings("unused")
	private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CustomerServiceImpl.class);

	public CustomerServiceImpl() {
		this.mapper = new ObjectMapper();
	}

	private static String CUSTOMER_ROOT = "customer:root";

	@SuppressWarnings("static-access")
	public ResponseDto create(Domain entity, Class<?> cls) throws JsonProcessingException, IOException {
		String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entity);
		Boolean output = CouchbaseWrapper.createDocument(entity.getId(), result);
		Object object = CouchbaseWrapper.getDocument(CUSTOMER_ROOT);

		LookupDomain lookup;
		List<String> childIds;
		if (object == null) {
			lookup = new LookupDomain();
			lookup.setRootId(CUSTOMER_ROOT);
			childIds = new ArrayList<String>();
			childIds.add(entity.getId());
			lookup.setChildIds(childIds);
			Boolean lookupCreatedOutput = CouchbaseWrapper.createDocument(CUSTOMER_ROOT,
					mapper.writerWithDefaultPrettyPrinter().writeValueAsString(lookup));
			logger.info("Customer Root Lookup Created Status:" + lookupCreatedOutput);
		} else {
			lookup = (LookupDomain) mapper.readValue(String.valueOf(object), LookupDomain.class);
			if (!lookup.childIds.contains(entity.getId())) {
				childIds = lookup.getChildIds();
				childIds.add(entity.getId());
				lookup.setChildIds(childIds);
				Boolean lookupCreatedOutput1 = CouchbaseWrapper.setDocument(CUSTOMER_ROOT,
						mapper.writerWithDefaultPrettyPrinter().writeValueAsString(lookup));
				logger.info("Customer Root Lookup Updated Status:" + lookupCreatedOutput1);
			}
		}

		ResponseDto resp = new ResponseDto();
		resp.setContent(Arrays.asList(entity.getId()));
		return resp;
	}

	@SuppressWarnings("rawtypes")
	public ResponseDto findOne(String id, Class<?> cls) throws JsonParseException, JsonMappingException, IOException {
		Object obj = CouchbaseWrapper.getDocument(id);
		ResponseDto rDto = new ResponseDto();
		rDto.setContent(Arrays.asList((Domain) mapper.readValue(String.valueOf(obj), cls)));
		return rDto;
	}

	@Override
	public ResponseDto findAll() throws JsonParseException, JsonMappingException, IOException {
		Object obj = CouchbaseWrapper.getDocument(CUSTOMER_ROOT);
		LookupDomain lookup = (LookupDomain) mapper.readValue(String.valueOf(obj), LookupDomain.class);

		Map<String, Object> childObjs = CouchbaseWrapper.getBulk(lookup.childIds);
		List<Domain> response = new ArrayList<Domain>();
		childObjs.values().stream().forEach(p -> {
			try {
				response.add((Domain) mapper.readValue(String.valueOf(p), Customer.class));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		ResponseDto resp = new ResponseDto();
		resp.setContent(response);
		return resp;
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
