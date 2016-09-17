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
import com.tesco.rs.domain.LookupDomain;
import com.tesco.rs.domain.SuperHero;
import com.tesco.rs.dto.ResponseDto;
import com.tesco.rs.dto.SuperHeroDto;
import com.tesco.rs.service.SuperHeroService;

/**
 * @author vagrant
 *
 */
public class SuperHeroServiceImpl implements SuperHeroService {
	private ObjectMapper mapper;
	@SuppressWarnings("unused")
	private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SuperHeroServiceImpl.class);

	public SuperHeroServiceImpl() {
		this.mapper = new ObjectMapper();
	}

	private static String SUPER_HERO_ROOT = "super:hero:root";

	@SuppressWarnings("static-access")
	public ResponseDto<SuperHeroDto> create(Domain entity, Class<?> cls) throws JsonProcessingException, IOException {

		Boolean output = CouchbaseWrapper.createDocument(entity.getId(),
				mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entity));

		Object object = CouchbaseWrapper.getDocument(SUPER_HERO_ROOT);
		LookupDomain lookup;
		List<String> childIds;
		if (object == null) {
			lookup = new LookupDomain();
			lookup.setRootId(SUPER_HERO_ROOT);
			childIds = new ArrayList<String>();
			childIds.add(entity.getId());
			lookup.setChildIds(childIds);
			Boolean lookupCreatedOutput = CouchbaseWrapper.createDocument(SUPER_HERO_ROOT,
					mapper.writerWithDefaultPrettyPrinter().writeValueAsString(lookup));
			logger.info("Product Root Lookup Created Status:" + lookupCreatedOutput);
		} else {
			lookup = (LookupDomain) mapper.readValue(String.valueOf(object), LookupDomain.class);
			if (!(lookup.childIds.contains(entity.getId()))) {
				childIds = lookup.getChildIds();
				System.out.println("==9===" + childIds);
				childIds.add(entity.getId());
				lookup.setChildIds(childIds);
				System.out.println("==6===" + lookup.getChildIds());
				Boolean lookupCreatedOutput1 = CouchbaseWrapper.createDocument(SUPER_HERO_ROOT,
						mapper.writerWithDefaultPrettyPrinter().writeValueAsString(lookup));
				logger.info("Product Root Lookup Updated Status:" + lookupCreatedOutput1);
			}
		}
		ResponseDto rDto = new ResponseDto<>();
		rDto.setContent(Arrays.asList(entity.getId()));
		return rDto;
	}

	public ResponseDto findOne(String id, Class<?> cls) throws JsonParseException, JsonMappingException, IOException {
		Object obj = CouchbaseWrapper.getDocument(id);
		ResponseDto rDto = new ResponseDto<>();
		rDto.setContent(Arrays.asList((Domain) mapper.readValue(String.valueOf(obj), cls)));
		return rDto;
	}

	@Override
	public ResponseDto findAll() throws JsonParseException, JsonMappingException, IOException {
		List<Domain> response = new ArrayList<Domain>();
		Object obj = CouchbaseWrapper.getDocument(SUPER_HERO_ROOT);
		LookupDomain lookup = (LookupDomain) mapper.readValue(String.valueOf(obj), LookupDomain.class);

		Map<String, Object> childObjs = CouchbaseWrapper.getBulk(lookup.childIds);

		childObjs.values().stream().forEach(p -> {
			try {

				response.add((Domain) mapper.readValue(String.valueOf(p), SuperHero.class));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		ResponseDto rDto = new ResponseDto<>();
		rDto.setContent(response);
		return rDto;
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
