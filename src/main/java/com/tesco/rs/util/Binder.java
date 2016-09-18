package com.tesco.rs.util;

import com.google.inject.AbstractModule;
import com.tesco.rs.service.CustomerService;
import com.tesco.rs.service.DestinationLocationService;
import com.tesco.rs.service.DriverLocationService;
import com.tesco.rs.service.ProductLocationService;
import com.tesco.rs.service.ProductService;
import com.tesco.rs.service.RegisterationService;
import com.tesco.rs.service.SuperHeroService;
import com.tesco.rs.service.impl.CustomerServiceImpl;
import com.tesco.rs.service.impl.DestinationLocationServiceImpl;
import com.tesco.rs.service.impl.DriverLocationServiceImpl;
import com.tesco.rs.service.impl.ProductLocationServiceImpl;
import com.tesco.rs.service.impl.ProductServiceImpl;
import com.tesco.rs.service.impl.RegisterationServiceImpl;
import com.tesco.rs.service.impl.SuperHeroServiceImpl;

/**
 * @author vagrant
 *
 */
public class Binder extends AbstractModule {

	@Override
	protected void configure() {
		binder().bind(RegisterationService.class).to(RegisterationServiceImpl.class);
		binder().bind(DestinationLocationService.class).to(DestinationLocationServiceImpl.class);
		binder().bind(ProductLocationService.class).to(ProductLocationServiceImpl.class);
		binder().bind(DriverLocationService.class).to(DriverLocationServiceImpl.class);
		binder().bind(ProductService.class).to(ProductServiceImpl.class);
		binder().bind(CustomerService.class).to(CustomerServiceImpl.class);
		binder().bind(SuperHeroService.class).to(SuperHeroServiceImpl.class);
	}
}
