package com.workproject.simplewebapp.entity;

public enum Category {
	REMINDER("Reminder", "reminder"),
	MINUTES("Minutes","minutes"),
	STUDY("Study","study"),
	HOLIDAY("Holiday","holiday");

	private final String label;
	private final String dbRepresentation;
	
	private Category(String label, String dbRepresentation){
		this.label = label;
		this.dbRepresentation = dbRepresentation;
	}
	
	public String getLabel() {
		return label;
	}
	
	public String getDatabaseRepresentation() {
		return dbRepresentation;
	}
}
