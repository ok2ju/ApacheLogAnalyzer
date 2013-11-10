package by.grsu.oop.ApacheLogAnalyzer;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import by.grsu.oop.ApacheLogAnalyzer.file_worker.TextReader;

public class LogFileParser {
	
	public List<LogEntry> getRecords() throws ParseException, IOException{
		
		TextReader textReader = new TextReader();
		Log log = new Log();
		
		return log.parse(textReader.getLogRecords());
	}
	
}
