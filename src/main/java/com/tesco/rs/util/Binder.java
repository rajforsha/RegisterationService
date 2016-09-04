package com.tesco.rs.util;

import com.google.inject.AbstractModule;
import com.tesco.rs.service.RegisterationService;
import com.tesco.rs.service.impl.RegisterationServiceImpl;

/**
 * @author vagrant
 *
 */
public class Binder extends AbstractModule {

	@Override
	protected void configure() {
		binder().bind(RegisterationService.class).to(RegisterationServiceImpl.class);
	}

}
