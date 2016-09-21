package com.tesco.rs.resource;

import java.io.IOException;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Inject;
import com.tesco.rs.domain.BookSuperHero;
import com.tesco.rs.domain.BookingAcknowledgement;
import com.tesco.rs.domain.Product;
import com.tesco.rs.dto.ProductDto;
import com.tesco.rs.service.BookSuperHeroService;
import com.tesco.rs.service.GenericService;
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
@Path("/v1/superhero/book")
@Api(value = "SuperHero", description = "product operations")
public class BookSuperHeroResource extends AbstractResource<Product, ProductDto> {

	@Inject
	private BookSuperHeroService bookSuperHeroService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "get registeredUser by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 500, message = "server error") })
	public Response crateProduct(@ApiParam BookSuperHero object) throws JsonProcessingException, IOException {
		String id = UUID.randomUUID().toString();
		object.setId("super:hero:booking:id:" + id);
		BookingAcknowledgement ack = bookSuperHeroService.bookSuperHero(object);
		return Response.ok(ack).header("id", "product:id:" + id).status(201).build();
	}


	@Override
	public GenericService getGenericService() {
		return bookSuperHeroService;
	}
}
