package JUnitObjectsTest;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import by.grsu.oop.ApacheLogAnalyzer.model.Date;
import by.grsu.oop.ApacheLogAnalyzer.parsers.DateParser;

public class DataParserTest {
	
	private Date date;
	private String dateString;
	
	@Before
	public void before(){
		GregorianCalendar gc = new GregorianCalendar();
		java.util.Date newDate = new java.util.Date();
		gc.setTime(newDate);
		
		date = new Date(gc);
		
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss Z");
		
		dateString = dateFormat.format(date.getGregorianCalendar().getTime());
		
		
	}

	@Test
	public void test() throws ParseException {
		
		DateParser dateParser = new DateParser();
			
		Date datenow = dateParser.getDateObject(dateString);
		assertEquals(datenow, date);
		
		
	}
	

}
