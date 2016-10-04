package com.tesco.rs.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tesco.rs.couchbase.CouchbaseWrapper;
import com.tesco.rs.domain.BookSuperHero;
import com.tesco.rs.domain.BookingAcknowledgement;
import com.tesco.rs.domain.LookupDomain;
import com.tesco.rs.domain.SuperHeroAcknowledgement;
import com.tesco.rs.service.BookSuperHeroService;
import com.tesco.rs.util.AbstractGenricService;

/**
 * @author vagrant
 *
 */
public class BookSuperHeroServiceImpl extends AbstractGenricService implements BookSuperHeroService {
	private static ObjectMapper mapper = new ObjectMapper();

	@Override
	public BookingAcknowledgement bookSuperHero(BookSuperHero entity)
			throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		// Get the Near By Super Heros
		List<String> foundSuperHeros = new ArrayList<String>();
		String superHeroObj = (String) CouchbaseWrapper.getDocument("superhero:root");
		LookupDomain lkup = mapper.readValue(superHeroObj, LookupDomain.class);
		foundSuperHeros.addAll(lkup.getChildIds());
		SuperHeroAcknowledgement newAck = new SuperHeroAcknowledgement();
		newAck.setId(entity.getId());
		CouchbaseWrapper.setDocument(entity.getId(),
				mapper.writerWithDefaultPrettyPrinter().writeValueAsString(newAck));
		// Send Notification

		// Listen responses - proceed once first response is acknowledged by
		// Super Hero
		SuperHeroAcknowledgement ack;
		int count = 0;
		BookingAcknowledgement ackReply = new BookingAcknowledgement();
		ackReply.setId(entity.getId());
		ackReply.setStatus("ERROR");
		while (true) {
			Object resp = CouchbaseWrapper.getDocument(entity.getId());
			ack = mapper.readValue(String.valueOf(resp), SuperHeroAcknowledgement.class);
			if (ack != null && ack.acknowledged!=null && ack.acknowledged.booleanValue() || count > 2) {
				if (ack.acknowledged!=null && ack.acknowledged.booleanValue()) {
					ackReply.setStatus("SUCCESS");
					ackReply.setSuperHeroName(ack.getSuperHeroName());
				}
				break;
			} else {
				count++;
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// Create Response Object

		return ackReply;
	}
}
