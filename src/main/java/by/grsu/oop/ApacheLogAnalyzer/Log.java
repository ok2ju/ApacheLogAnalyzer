package by.grsu.oop.ApacheLogAnalyzer;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Log {
	
	public List<LogEntry> parse(List<String> logTextStrings) throws ParseException{
		
		List<LogEntry> records = new ArrayList<LogEntry>();
		
		for(String logString: logTextStrings){
			LogParser logParser = new LogParser();
			records.add(logParser.parse(logString));
		}
		
		return records;
	}
	
}
