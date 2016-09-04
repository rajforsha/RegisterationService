package com.tesco.rs;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tesco.rs.domain.RegisterationServiceConfiguration;
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

}
