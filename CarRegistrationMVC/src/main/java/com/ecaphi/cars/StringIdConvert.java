package com.ecaphi.cars;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class StringIdConvert implements AttributeConverter<Integer, String> {

	
	@Override
	public String convertToDatabaseColumn(Integer attribute) {
		// TODO Auto-generated method stub
		return attribute.toString();
	}

	@Override
	public Integer convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		return Integer.parseInt(dbData);
	}

}
