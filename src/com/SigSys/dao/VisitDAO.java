package com.SigSys.dao;

import java.util.List;

import org.joda.time.DateTime;

import com.SigSys.model.Company;
import com.SigSys.model.Visit;

public interface VisitDAO {

	public void addVisit(Visit visit);
	
	public void updateVisit(Visit visit);
	
	public boolean deleteVisit(int id);
	
	public Visit getVisitById(int id);
	
	public List<Visit> getAllVisits();
	
	public List<Visit> getVisitsByCompany(Company company);
	
	public List<Visit> getVisitsBeforeTimeIn(DateTime dateTime);
	
	public List<Visit> getVisitsAfterTimeIn(DateTime dateTime);
	
	public List<Visit> getVisitsBeforeTimeOut(DateTime dateTime);
	
	public List<Visit> getVisitsAfterTimeOut(DateTime dateTime);
	
}
