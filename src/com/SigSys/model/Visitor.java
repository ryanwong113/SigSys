package com.SigSys.model;

public class Visitor {
	
	private int id;
	private String firstName;
	private String lastName;
	private String from;
	
	public Visitor(){
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFrom() {
		return from;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Visitor)) return false;
		Visitor v1 = (Visitor) o;
		if (!this.firstName.equals(v1.firstName)) return false;
		if (!this.lastName.equals(v1.lastName)) return false;
		if (!this.from.equals(v1.from)) return false;
		return true;
	}
}
