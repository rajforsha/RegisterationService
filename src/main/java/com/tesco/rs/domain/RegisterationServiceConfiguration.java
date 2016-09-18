package com.tesco.rs.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

/**
 * @author vagrant
 *
 */
public class RegisterationServiceConfiguration extends Configuration {

	@JsonProperty("swagger")
	public SwaggerBundleConfiguration swaggerBundleConfiguration;

	@JsonProperty("couchbase")
	public CouchbaseConfiguration couchbaseConfig;

	/**
	 * @return the couchbaseConfig
	 */
	public CouchbaseConfiguration getCouchbaseConfig() {
		return couchbaseConfig;
	}

	/**
	 * @param couchbaseConfig
	 *            the couchbaseConfig to set
	 */
	public void setCouchbaseConfig(CouchbaseConfiguration couchbaseConfig) {
		this.couchbaseConfig = couchbaseConfig;
	}

}
