package by.grsu.oop.ApacheLogAnalyzer.statistics.statistic;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import by.grsu.oop.ApacheLogAnalyzer.LogEntry;
import by.grsu.oop.ApacheLogAnalyzer.LogFileParser;

public class DailyRequestStatistic {
	
	private LogFileParser logFileParser;
	
	public DailyRequestStatistic(LogFileParser logFileParser){
		this.logFileParser = logFileParser;
	}

	public Map<Integer, Integer> getStatusFrequencyByTime()
			throws ParseException, IOException {
		Map<Integer, Integer> temporaryMap = new HashMap<Integer, Integer>();

		for (LogEntry logEntry : logFileParser.getRecords()) {
			Integer hour = logEntry.getDate().getGregorianCalendar()
					.get(Calendar.HOUR_OF_DAY);
			Integer number = temporaryMap.get(hour);
			if (number != null) {
				// map.remove(hour);
				temporaryMap.put(hour, ++number);
			} else {
				temporaryMap.put(hour, 1);
			}
		}

		return temporaryMap;
	}

	private String getTimeOfDay(Integer currentTime) {
		if (currentTime >= 7 && currentTime <= 12) {
			return "MORNING";
		} else if (currentTime > 12 && currentTime <= 18) {
			return "AFTERNOON";
		} else if (currentTime > 18 && currentTime <= 23 || currentTime == 0) {
			return "EVENING";
		} else {
			return "NIGHT";
		}
	}

	public Map<String, Integer> getStatusFrequencyPerDay()
			throws ParseException, IOException {
		Map<String, Integer> temporaryMap = new HashMap<String, Integer>();

		for (LogEntry logEntry : logFileParser.getRecords()) {
			Integer hour = logEntry.getDate().getGregorianCalendar()
					.get(Calendar.HOUR_OF_DAY);
			String partOfDay = getTimeOfDay(hour);
			Integer number = temporaryMap.get(partOfDay);
			if (number != null) {
				temporaryMap.remove(partOfDay);
				temporaryMap.put(partOfDay, ++number);
			} else {
				temporaryMap.put(partOfDay, 1);
			}
		}

		return temporaryMap;
	}
	
}
