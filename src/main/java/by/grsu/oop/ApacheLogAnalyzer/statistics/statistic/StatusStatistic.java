package by.grsu.oop.ApacheLogAnalyzer.statistics.statistic;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import by.grsu.oop.ApacheLogAnalyzer.LogEntry;
import by.grsu.oop.ApacheLogAnalyzer.LogFileParser;

public class StatusStatistic {
	
	private LogFileParser logFileParser;
	
	public StatusStatistic(LogFileParser logFileParser){
		this.logFileParser = logFileParser;
	}

	public Map<String, Integer> getNumberOfStatus() throws ParseException,
			IOException {
		Map<String, Integer> temporaryMap = new HashMap<String, Integer>();

		for (LogEntry logEntry : logFileParser.getRecords()) {
			String status = logEntry.getStatus().getStatus();
			Integer number = temporaryMap.get(status);

			if (number != null) {
				temporaryMap.remove(status);
				temporaryMap.put(status, ++number);
			} else {
				temporaryMap.put(status, 1);
			}
		}

		return temporaryMap;

	}

	public Map<String, Double> getStatusPercentageRatio()
			throws ParseException, IOException {
		Map<String, Integer> countOfStatusMap = getNumberOfStatus();
		Map<String, Double> percentRatioMap = new HashMap<String, Double>();

		Integer count = logFileParser.getRecords().size();
		for (Entry<String, Integer> status : countOfStatusMap.entrySet()) {
			percentRatioMap.put(status.getKey(), (double) status.getValue()
					/ count * 100);
		}

		return percentRatioMap;
	}
	
}
