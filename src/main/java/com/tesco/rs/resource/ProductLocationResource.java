package com.tesco.rs.resource;

import java.io.IOException;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.inject.Inject;
import com.tesco.rs.domain.ProductLocation;
import com.tesco.rs.dto.ProductLocationDto;
import com.tesco.rs.service.GenericService;
import com.tesco.rs.service.ProductLocationService;
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
@Path("/v1/productlocation")
@Api(value = "productLocation", description = "productlocation operations")
public class ProductLocationResource extends AbstractResource<ProductLocation, ProductLocationDto> {

	@Inject
	private ProductLocationService productLocationService;

	@Override
	public GenericService getGenericService() {
		return productLocationService;
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "get productLocation by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 500, message = "server error") })
	public Response getUsers(@QueryParam(value = "id") String id)
			throws JsonParseException, JsonMappingException, IOException {
		if (id != null) {
			return Response.ok(findOne(id)).status(200).build();
		} else {
			return Response.ok(findAll()).status(200).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Enter productLocation")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 500, message = "server error") })
	public Response createRegisteration(@ApiParam ProductLocation object) throws JsonProcessingException, IOException {
		String id = UUID.randomUUID().toString();
		object.setId("productLocation:id:" + id);
		create(object);
		return Response.ok().header("id", "productLocation:id:" + id).status(201).build();
	}

}
