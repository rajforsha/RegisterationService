package com.tesco.rs.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtilsBean;

public class BeanUtils extends BeanUtilsBean {
	
	public void copyProperty(Object dest, String name, String value) throws IllegalAccessException, InvocationTargetException{
		if (value!=null){
			super.copyProperty(dest, name, value);
		}
	}

}
