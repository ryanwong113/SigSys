package com.SigSys.form;

import java.util.List;

import org.joda.time.DateTime;

import com.SigSys.model.Company;

public class FilterVisitsForm {
	
	private String firstName;
	private String lastName;
	private List<Company> companies;
	private DateTime timeIn;
	private DateTime timeOut;
	
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

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public DateTime getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(DateTime timeIn) {
		this.timeIn = timeIn;
	}

	public DateTime getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(DateTime timeOut) {
		this.timeOut = timeOut;
	}
	
}
