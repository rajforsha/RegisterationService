package com.tesco.rs.bundle;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tesco.rs.couchbase.CouchbaseResource;
import com.tesco.rs.domain.CouchbaseConfiguration;
import com.tesco.rs.domain.RegisterationServiceConfiguration;
import com.tesco.rs.filter.CorsFilter;
import com.tesco.rs.healthcheck.CouchbaseHealthCheckUp;
import com.tesco.rs.resource.BookSuperHeroResource;
import com.tesco.rs.resource.CustomerResource;
import com.tesco.rs.resource.DestinationLocationResource;
import com.tesco.rs.resource.DriverLocationResource;
import com.tesco.rs.resource.ProductLocationResource;
import com.tesco.rs.resource.ProductResource;
import com.tesco.rs.resource.RegisterationResource;
import com.tesco.rs.resource.SuperHeroResource;

import io.dropwizard.Configuration;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * @author shashi
 *
 */
public class RegisterationCdiBundle<T extends Configuration> implements ConfiguredBundle<T> {

	@Override
	public void run(T configuration, Environment environment) throws Exception {

		Injector injector = Guice.createInjector(new com.tesco.rs.util.Binder());
		RegisterationResource resource = injector.getInstance(RegisterationResource.class);
		environment.jersey().register(resource);
		DriverLocationResource driverResource = injector.getInstance(DriverLocationResource.class);
		environment.jersey().register(driverResource);
		ProductLocationResource productResource = injector.getInstance(ProductLocationResource.class);
		environment.jersey().register(productResource);
		DestinationLocationResource destinationResource = injector.getInstance(DestinationLocationResource.class);
		environment.jersey().register(destinationResource);
		ProductResource producResource = injector.getInstance(ProductResource.class);
		environment.jersey().register(producResource);
		CustomerResource customerResource = injector.getInstance(CustomerResource.class);
		environment.jersey().register(customerResource);
		SuperHeroResource superHeroResource = injector.getInstance(SuperHeroResource.class);
		environment.jersey().register(superHeroResource);
		BookSuperHeroResource bookSuperHeroResource = injector.getInstance(BookSuperHeroResource.class);
		environment.jersey().register(bookSuperHeroResource);

		
		CouchbaseHealthCheckUp args = new CouchbaseHealthCheckUp();
		environment.healthChecks().register("", args);
		CorsFilter corsFilter = new CorsFilter();
		environment.servlets().addFilter("corsFilter", corsFilter)
				.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
		createCouchbaseConnection(
				getRegisterationCdiBundleConfiguration((RegisterationServiceConfiguration) configuration)
						.getCouchbaseConfig());
	}

	@Override
	public void initialize(Bootstrap<?> bootstrap) {

	}

	protected RegisterationServiceConfiguration getRegisterationCdiBundleConfiguration(
			RegisterationServiceConfiguration configuration) {
		return configuration;
	}

	public void createCouchbaseConnection(CouchbaseConfiguration couchbaseConfiguration) {
		CouchbaseResource.createConnection(couchbaseConfiguration);
	}

}
