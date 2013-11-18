package JUnitObjectsTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import by.grsu.oop.ApacheLogAnalyzer.LogEntry;
import by.grsu.oop.ApacheLogAnalyzer.LogFileParser;
import by.grsu.oop.ApacheLogAnalyzer.LogParser;
import by.grsu.oop.ApacheLogAnalyzer.model.Date;
import by.grsu.oop.ApacheLogAnalyzer.model.Ip;
import by.grsu.oop.ApacheLogAnalyzer.model.Method;
import by.grsu.oop.ApacheLogAnalyzer.model.ObjectSize;
import by.grsu.oop.ApacheLogAnalyzer.model.Path;
import by.grsu.oop.ApacheLogAnalyzer.model.Protocol;
import by.grsu.oop.ApacheLogAnalyzer.model.Status;

public class ObjectsTest {

	@Test
	public void test() throws ParseException, IOException {
		
		LogFileParser lfp = new LogFileParser();
		List<LogEntry> records = lfp.getRecords();
		
		LogEntry logEntry = new LogEntry();
		
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss Z");
		java.util.Date newDate = dateFormat.parse("29.10.2013 16:43:19 +0300");
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(newDate);
		
		Date date = new Date(gregorianCalendar);
		logEntry.setDate(date);
		
		Ip ip = new Ip(231, 42, 212, 215);
		logEntry.setIp(ip);
		
		Method method = new Method("GET");
		logEntry.setMethod(method);
		
		ObjectSize objectSize = new ObjectSize(99381);
		logEntry.setObjectSize(objectSize);
		
		List<String> folders = new ArrayList<String>();
		folders.add("media");
		folders.add("documents");
		folders.add("books");
		Path path = new Path("red-book", "txt", folders);
		logEntry.setPath(path);
		
		Protocol protocol = new Protocol("HTTP", "1.0");
		logEntry.setProtocol(protocol);
		
		Status status = new Status("404");
		logEntry.setStatus(status);
		
		System.out.println(records.get(0).getMethod().getMethod());
		System.out.println(logEntry.getMethod().getMethod());
		
		assertNotNull(logEntry);
		assertNotNull(records.get(0));
		
		assertTrue(records.get(0).getMethod().equals(logEntry.getMethod().getMethod()));
		
		
		
	}

}
