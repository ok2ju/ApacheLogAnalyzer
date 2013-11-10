package by.grsu.oop.ApacheLogAnalyzer.parsers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import by.grsu.oop.ApacheLogAnalyzer.model.Date;

public class DateParser {
	
	public Date getDateObject(String textData) throws ParseException{
		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss Z");
		
		java.util.Date newDate = dateFormat.parse(textData);
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(newDate);
		date.setGregorianCalendar(gregorianCalendar);
		
		return date;
	}

}
