package com.tesco.rs.service.impl;

import com.tesco.rs.service.CustomerService;
import com.tesco.rs.util.AbstractGenricService;

/**
 * @author vagrant
 *
 */
public class CustomerServiceImpl extends AbstractGenricService implements CustomerService {

	@Override
	public void beforeCreate() {
	}

	@Override
	public void afterCreate() {
		super.afterCreate();
	}
}
