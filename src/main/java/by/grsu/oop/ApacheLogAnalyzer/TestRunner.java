package by.grsu.oop.ApacheLogAnalyzer;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import by.grsu.oop.ApacheLogAnalyzer.statistics.representative.TextStatisticPresenter;

public class TestRunner {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ParseException {
		
		LogFileParser logFileParser = new LogFileParser();
		List<LogEntry> records = logFileParser.getRecords();
		
		TextStatisticPresenter tsp = new TextStatisticPresenter(logFileParser);
		System.out.println(tsp.showStatusFrequency());
		System.out.println(tsp.showStatusPercent());
		System.out.println(tsp.showStatusFrequencyByTime());
		System.out.println(tsp.showStatusFrequencyPerDay());
		System.out.println(tsp.showExtensionFrequency());

	}

}
