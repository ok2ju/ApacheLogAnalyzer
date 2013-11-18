package by.grsu.oop.ApacheLogAnalyzer.model;

import java.util.GregorianCalendar;

public class Date {
	
	private GregorianCalendar gregorianCalendar;
	
	public Date(GregorianCalendar gregorianCalendar){
		this.gregorianCalendar = gregorianCalendar;
	}

	public GregorianCalendar getGregorianCalendar() {
		return gregorianCalendar;
	}

	public void setGregorianCalendar(GregorianCalendar gregorianCalendar) {
		this.gregorianCalendar = gregorianCalendar;
	}

}
