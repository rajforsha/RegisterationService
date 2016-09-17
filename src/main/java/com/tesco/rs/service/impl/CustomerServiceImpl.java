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
	private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CustomerServiceImpl.class);

	public CustomerServiceImpl() {
		this.mapper = new ObjectMapper();
	}

	private static String CUSTOMER_ROOT = "customer:root";

	public ResponseDto<String> create(Domain entity, Class<?> cls) throws JsonProcessingException, IOException {
		String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entity);
		CouchbaseWrapper.createDocument(entity.getId(), result);
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

		ResponseDto<String> resp = new ResponseDto<String>();
		resp.setContent(Arrays.asList(entity.getId()));
		return resp;
	}

	public ResponseDto<Customer> findOne(String id, Class<?> cls)
			throws JsonParseException, JsonMappingException, IOException {
		Object obj = CouchbaseWrapper.getDocument(id);
		ResponseDto<Customer> rDto = new ResponseDto<Customer>();
		rDto.setContent(Arrays.asList((Customer) mapper.readValue(String.valueOf(obj), cls)));
		return rDto;
	}

	@Override
	public ResponseDto<Customer> findAll() throws JsonParseException, JsonMappingException, IOException {
		Object obj = CouchbaseWrapper.getDocument(CUSTOMER_ROOT);
		LookupDomain lookup = (LookupDomain) mapper.readValue(String.valueOf(obj), LookupDomain.class);

		Map<String, Object> childObjs = CouchbaseWrapper.getBulk(lookup.childIds);
		List<Customer> response = new ArrayList<Customer>();
		childObjs.values().stream().forEach(p -> {
			try {
				response.add((Customer) mapper.readValue(String.valueOf(p), Customer.class));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		ResponseDto<Customer> resp = new ResponseDto<Customer>();
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
