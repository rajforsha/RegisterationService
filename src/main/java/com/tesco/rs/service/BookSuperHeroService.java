package com.tesco.rs.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tesco.rs.domain.BookSuperHero;
import com.tesco.rs.domain.BookingAcknowledgement;

/**
 * @author vagrant
 *
 */
public interface BookSuperHeroService extends GenericService {
	public BookingAcknowledgement bookSuperHero(BookSuperHero entity) throws JsonParseException, JsonMappingException, IOException;
}
