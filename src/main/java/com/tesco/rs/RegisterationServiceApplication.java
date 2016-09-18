package com.tesco.rs;

import com.tesco.rs.bundle.RegisterationCdiBundle;
import com.tesco.rs.domain.RegisterationServiceConfiguration;

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

		bootstrap.addBundle(new RegisterationCdiBundle<RegisterationServiceConfiguration>() {
			@Override
			protected RegisterationServiceConfiguration getRegisterationCdiBundleConfiguration(
					RegisterationServiceConfiguration registerationServiceConfiguration) {
				return registerationServiceConfiguration;
			}
		});
	}

}
