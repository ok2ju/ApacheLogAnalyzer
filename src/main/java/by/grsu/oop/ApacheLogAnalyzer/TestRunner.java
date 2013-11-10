package by.grsu.oop.ApacheLogAnalyzer;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class TestRunner {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ParseException {
		
		LogFileParser logFileParser = new LogFileParser();
		List<LogEntry> records = logFileParser.getRecords();
		String client = records.get(0).getClient().toString();
		
		System.out.println(client);

	}

}
