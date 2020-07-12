package com.nida.model;

import java.io.IOException;
import java.util.Map;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HashMapConverter implements AttributeConverter<Map<String, String>, String> {
	
	private final ObjectMapper objectMapper = new ObjectMapper();


	@Override
	public String convertToDatabaseColumn(Map<String, String> address) {
		// TODO Auto-generated method stub
		 String addressJson = null;
	        try {
	            addressJson = objectMapper.writeValueAsString(address);
	        } catch (final JsonProcessingException e) {
	            System.err.println(e);
	        }
	 
	        return addressJson;
	    }
	

	@Override
	public Map<String, String> convertToEntityAttribute(String addressJson) {
		// TODO Auto-generated method stub
		Map<String, String> address = null;
        try {
            address = objectMapper.readValue(addressJson, Map.class);
        } catch (final IOException e) {
            System.err.println(e);
        }
 
        return address;
    }
	

}
