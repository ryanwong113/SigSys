package com.SigSys.model;

public enum Company {
	COMPANY_A("COMPANY A"), 
	COMPANY_B("COMPANY B"), 
	COMPANY_C("COMPANY C");
	
	private final String name;
	
	Company(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
