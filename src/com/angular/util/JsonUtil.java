package com.angular.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil
{
	private static ObjectMapper objectMapper = null;
	
	static
	{
		objectMapper = new ObjectMapper();
	}
	
	public static String convertJavaToJson(Object obj)
	{
		String jsonString = null;
		try
		{
			jsonString = objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonString;
	}
}
