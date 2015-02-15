package com.SigSys.model;

import org.joda.time.DateTime;

public class Visit {
				
	private int id;
	private Visitor visitor;
	private Company company;
	private String visitReason;
	private DateTime timeIn;
	private DateTime timeOut;
	
	public Visit() {
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public Visitor getVisitor() {
		return visitor;
	}
	
	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public String getVisitReason() {
		return visitReason;
	}
	
	public void setVisitReason(String visitReason) {
		this.visitReason = visitReason;
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
	
	@Override
    public String toString() {
        return "Visit [id=" + id + ", visitor=" + visitor.getFirstName() + visitor.getLastName() + 
        		", company=" + company.name() + "]";
    }
	
}
