package com.workproject.simplewebapp.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category, String> {
	@Override
	public String convertToDatabaseColumn(Category attribute) {
	return attribute.getDatabaseRepresentation();
	}
	@Override
	public Category convertToEntityAttribute(String dbData) {
		for (Category cat : Category.values()) {
		if (dbData.equals(cat.getDatabaseRepresentation())) {
		return cat;
		}
	}
	throw new IllegalArgumentException("Unknown attribute value " +	dbData);
	}

}