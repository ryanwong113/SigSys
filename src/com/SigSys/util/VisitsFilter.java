package com.SigSys.util;

import java.util.Iterator;
import java.util.List;

import org.joda.time.DateTime;

import com.SigSys.model.Company;
import com.SigSys.model.Visit;

public class VisitsFilter {

	public static List<Visit> filterVisitsByFullName(List<Visit> visits, final String firstName, final String lastName) {
		Iterator<Visit> it = visits.iterator();
		while (it.hasNext()) {
			Visit visit = it.next();
			if (!(firstName.equals(visit.getVisitor().getFirstName()) && lastName.equals(visit.getVisitor().getLastName()))) {
				it.remove();
			}
		}
		return visits;
	}
	
	public static List<Visit> filterVisitsByFirstName(List<Visit> visits, final String firstName) {
		Iterator<Visit> it = visits.iterator();
		while (it.hasNext()) {
			Visit visit = it.next();
			if (!firstName.equals(visit.getVisitor().getFirstName())) {
				it.remove();
			}
		}
		return visits;
	}
	
	public static List<Visit> filterVisitsByLastName(List<Visit> visits, final String lastName) {
		Iterator<Visit> it = visits.iterator();
		while (it.hasNext()) {
			Visit visit = it.next();
			if (!lastName.equals(visit.getVisitor().getLastName())) {
				it.remove();
			}
		}
		return visits;
	}
	
	public static List<Visit> filterVisitsByCompanies(List<Visit> visits, final List<Company> companies) {
		Iterator<Visit> it = visits.iterator();
		while (it.hasNext()) {
			Visit visit = it.next();
			if (!companies.contains(visit.getCompany())) {
				it.remove();
			}
		}
		return visits;
	}
	
	public static List<Visit> filterVisitsByTimeInBefore(List<Visit> visits, final DateTime timeIn) {
		Iterator<Visit> it = visits.iterator();
		while (it.hasNext()) {
			Visit visit = it.next();
			if (visit.getTimeIn().isAfter(timeIn)) {
				it.remove();
			}
		}
		return visits;
	}
	
	public static List<Visit> filterVisitsByTimeInAfter(List<Visit> visits, final DateTime timeIn) {
		Iterator<Visit> it = visits.iterator();
		while (it.hasNext()) {
			Visit visit = it.next();
			if (visit.getTimeIn().isBefore(timeIn)) {
				it.remove();
			}
		}
		return visits;
	}
	
	public static List<Visit> filterVisitsByTimeOutBefore(List<Visit> visits, final DateTime timeOut) {
		Iterator<Visit> it = visits.iterator();
		while (it.hasNext()) {
			Visit visit = it.next();
			if (visit.getTimeIn().isAfter(timeOut)) {
				it.remove();
			}
		}
		return visits;
	}
	
	public static List<Visit> filterVisitsByTimeOutAfter(List<Visit> visits, final DateTime timeOut) {
		Iterator<Visit> it = visits.iterator();
		while (it.hasNext()) {
			Visit visit = it.next();
			if (visit.getTimeIn().isBefore(timeOut)) {
				it.remove();
			}
		}
		return visits;
	}
	
}
