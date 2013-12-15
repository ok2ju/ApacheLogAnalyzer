package by.grsu.oop.ApacheLogAnalyzer.statistics.statistic;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import by.grsu.oop.ApacheLogAnalyzer.LogEntry;
import by.grsu.oop.ApacheLogAnalyzer.LogFileParser;

public class FilesStatistic {
	
	private LogFileParser logFileParser;
	
	public FilesStatistic(LogFileParser logFilesParser){
		this.logFileParser = logFilesParser;
	}

	public Map<String, Integer> getNumberOfFiles() throws ParseException,
			IOException {
		Map<String, Integer> temporaryMap = new HashMap<String, Integer>();

		for (LogEntry logEntry : logFileParser.getRecords()) {
			String extension = logEntry.getPath().getExtension();
			Integer number = temporaryMap.get(extension);
			if (number != null) {
				temporaryMap.remove(extension);
				temporaryMap.put(extension, ++number);
			} else {
				temporaryMap.put(extension, 1);
			}
		}

		return temporaryMap;
	}

}
