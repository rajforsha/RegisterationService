package com.tesco.rs.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tesco.rs.constant.Domain;
import com.tesco.rs.couchbase.CouchbaseWrapper;
import com.tesco.rs.domain.LookupDomain;
import com.tesco.rs.dto.ResponseDto;
import com.tesco.rs.service.GenericService;

/**
 * @author shashi
 *
 */
public abstract class AbstractGenricService implements GenericService {

	private static ObjectMapper mapper = new ObjectMapper();
	BeanUtils beauUtils = new BeanUtils();
	


	public static String getRootId(Class<?> cls) {
		String rootid = "dummy";
		if (cls.toString().contains("Product")) {
			rootid = "product:root";
		} else if (cls.toString().contains("Customer")) {
			rootid = "customer:root";
		} else if (cls.toString().contains("SuperHero")) {
			rootid = "superhero:root";
		}
		return rootid;
	}

	public void create(Domain entity, Class<?> cls) throws JsonProcessingException, IOException {
		String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entity);
		CouchbaseWrapper.createDocument(entity.getId(), result);
		if (!"dummy".equals(getRootId(cls))) {
			Object object = CouchbaseWrapper.getDocument(getRootId(cls));

			LookupDomain lookup;
			List<String> childIds;
			if (object == null) {
				lookup = new LookupDomain();
				lookup.setRootId(cls.toString());
				childIds = new ArrayList<String>();
				childIds.add(entity.getId());
				lookup.setChildIds(childIds);
				CouchbaseWrapper.createDocument(getRootId(cls),
						mapper.writerWithDefaultPrettyPrinter().writeValueAsString(lookup));
			} else {
				lookup = (LookupDomain) mapper.readValue(String.valueOf(object), LookupDomain.class);
				if (!lookup.childIds.contains(entity.getId())) {
					childIds = lookup.getChildIds();
					childIds.add(entity.getId());
					lookup.setChildIds(childIds);
					CouchbaseWrapper.setDocument(getRootId(cls),
							mapper.writerWithDefaultPrettyPrinter().writeValueAsString(lookup));
				}
			}
		}
	}

	public ResponseDto<Domain> findOne(String id, Class<?> cls)
			throws JsonParseException, JsonMappingException, IOException {
		Object obj = CouchbaseWrapper.getDocument(id);
		ResponseDto<Domain> rDto = new ResponseDto<Domain>();
		rDto.setContent(Arrays.asList((Domain) mapper.readValue(String.valueOf(obj), cls)));
		return rDto;
	}

	public ResponseDto<Domain> findAll(Class<?> cls) throws JsonParseException, JsonMappingException, IOException {
		/*
		 * getting lookup document using id.
		 */
		Object obj = CouchbaseWrapper.getDocument(getRootId(cls));
		LookupDomain lookup = (LookupDomain) mapper.readValue(String.valueOf(obj), LookupDomain.class);

		Map<String, Object> childObjs = CouchbaseWrapper.getBulk(lookup.childIds);
		List<Domain> response = new ArrayList<Domain>();
		childObjs.values().stream().forEach(p -> {
			try {
				response.add((Domain) mapper.readValue(String.valueOf(p), cls));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		ResponseDto<Domain> resp = new ResponseDto<Domain>();
		if (response != null) {
			resp.setContent(response);
		}
		return resp;
	}

	public void update(Domain enity, Class<?> cls) throws JsonParseException, JsonMappingException, IOException {
		Object oldObject = CouchbaseWrapper.getDocument(enity.getId());
		Domain oldEntity =(Domain) mapper.readValue(String.valueOf(oldObject), cls);
		System.out.println("Before Entity-"+enity.toString());
		System.out.println("Before OldEntity-"+oldEntity.toString());

		try {
			beauUtils.copyProperties(oldEntity, enity);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Entity-"+enity.toString());
		System.out.println("OldEntity-"+oldEntity.toString());
		CouchbaseWrapper.setDocument(enity.getId(), mapper.writerWithDefaultPrettyPrinter().writeValueAsString(oldEntity));
	}

	public void delete(String id) throws JsonParseException, JsonMappingException, IOException {
		// CouchbaseWrapper.deleteDocument(id);
	}

	public void afterCreate(Domain user) throws JsonParseException, JsonMappingException, IOException {
	}

	public void afterDelete(String id) throws JsonParseException, JsonMappingException, IOException {
	}
}
