package com.tesco.rs;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tesco.rs.couchbase.CouchbaseResource;
import com.tesco.rs.domain.CouchbaseConfiguration;
import com.tesco.rs.domain.RegisterationServiceConfiguration;
import com.tesco.rs.filter.CorsFilter;
import com.tesco.rs.resource.DestinationLocationResource;
import com.tesco.rs.resource.DriverLocationResource;
import com.tesco.rs.resource.ProductLocationResource;
import com.tesco.rs.resource.RegisterationResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

/**
 * @author vagrant
 *
 */
public class RegisterationServiceApplication extends Application<RegisterationServiceConfiguration> {

	public static void main(String[] args) throws Exception {
		new RegisterationServiceApplication().run(args);
	}

	@Override
	public void run(RegisterationServiceConfiguration config, Environment environment) throws Exception {
		Injector injector = Guice.createInjector(new com.tesco.rs.util.Binder());
		RegisterationResource resource = injector.getInstance(RegisterationResource.class);
		environment.jersey().register(resource);
		DriverLocationResource driverResource = injector.getInstance(DriverLocationResource.class);
		environment.jersey().register(driverResource);
		ProductLocationResource productResource = injector.getInstance(ProductLocationResource.class);
		environment.jersey().register(productResource);
		DestinationLocationResource destinationResource = injector.getInstance(DestinationLocationResource.class);
		environment.jersey().register(destinationResource);
		CorsFilter corsFilter = new CorsFilter();
		environment.servlets().addFilter("corsFilter", corsFilter)
				.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
		;
		createCouchbaseConnection(config.getConfig());
	}

	@Override
	public void initialize(Bootstrap<RegisterationServiceConfiguration> bootstrap) {

		bootstrap.addBundle(new SwaggerBundle<RegisterationServiceConfiguration>() {
			@Override
			protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
					RegisterationServiceConfiguration configuration) {
				return configuration.swaggerBundleConfiguration;
			}
		});
	}

	public void createCouchbaseConnection(CouchbaseConfiguration couchbaseConfiguration) {
		CouchbaseResource.createConnection(couchbaseConfiguration);
	}

}
