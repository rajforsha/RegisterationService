package com.tesco.rs.healthcheck;

import com.codahale.metrics.health.HealthCheck;

/**
 * @author shashi
 *
 */
public class CouchbaseHealthCheckUp extends HealthCheck {

	@Override
	protected Result check() throws Exception {
		return Result.healthy();
	}

}
