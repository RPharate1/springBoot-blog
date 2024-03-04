package com.springboot.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	private String resourceName;
	private String fieldname;
	private long filedValue;
	
	
	public ResourceNotFoundException(String resourceName, String fieldname, long filedValue) {
		super(String.format("%s not found with %s : '%s'",resourceName,fieldname,filedValue));
		this.resourceName = resourceName;
		this.fieldname = fieldname;
		this.filedValue = filedValue;
	}
	
	public String getResourceName() {
		return resourceName;
	}
	public String getFieldname() {
		return fieldname;
	}
	public long getFiledValue() {
		return filedValue;
	}
	
	
	
	

}
