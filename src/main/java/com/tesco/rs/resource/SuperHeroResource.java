package com.tesco.rs.resource;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.inject.Inject;
import com.tesco.rs.constant.RootIdConstant;
import com.tesco.rs.domain.SuperHero;
import com.tesco.rs.dto.SuperHeroDto;
import com.tesco.rs.service.GenericService;
import com.tesco.rs.service.SuperHeroService;
import com.tesco.rs.util.AbstractResource;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @author vagrant
 *
 */
@Path("/v1/superheros")
@Api(value = "superheros", description = "product operations")
public class SuperHeroResource extends AbstractResource<SuperHero, SuperHeroDto> {

	@Inject
	private SuperHeroService superHeroService;

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "get registeredUser by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 500, message = "server error") })
	public Response getSuperHeros(@QueryParam(value = "id") String id)
			throws JsonParseException, JsonMappingException, IOException {
		if (id != null) {
			return Response.ok(superHeroService.findOne(id, getDomainType())).status(200).build();
		} else {
			return Response.ok(superHeroService.findAll()).status(200).build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "get registeredUser by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 500, message = "server error") })
	public Response crateProduct(@ApiParam SuperHero object) throws JsonProcessingException, IOException {
		object.setId("super:hero:id:" + RootIdConstant.uid.randomUUID().toString());
		return Response.ok(superHeroService.create(object, getDomainType())).status(201).build();
	}

	@Override
	public GenericService getGenericService() {
		return superHeroService;
	}
}
