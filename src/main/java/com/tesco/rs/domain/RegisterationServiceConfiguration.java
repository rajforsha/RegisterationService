package com.tesco.rs.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

/**
 * @author vagrant
 *
 */
public class RegisterationServiceConfiguration extends Configuration {

	@JsonProperty("couchbase")
	public CouchbaseConfiguration config;

	@JsonProperty("swagger")
	public SwaggerBundleConfiguration swaggerBundleConfiguration;

	/**
	 * @return the config
	 */
	public CouchbaseConfiguration getConfig() {
		return config;
	}

	/**
	 * @param config
	 *            the config to set
	 */
	public void setConfig(CouchbaseConfiguration config) {
		this.config = config;
	}
}
