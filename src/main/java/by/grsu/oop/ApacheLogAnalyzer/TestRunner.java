package by.grsu.oop.ApacheLogAnalyzer;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import by.grsu.oop.ApacheLogAnalyzer.statistics.StatsRepresenter;

public class TestRunner {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ParseException {
		
		LogFileParser logFileParser = new LogFileParser();
		List<LogEntry> records = logFileParser.getRecords();
		
		StatsRepresenter statsRepresenter = new StatsRepresenter(logFileParser);
		statsRepresenter.showInConsole();
		statsRepresenter.saveToFile("LogStatistic.txt");

	}

}
