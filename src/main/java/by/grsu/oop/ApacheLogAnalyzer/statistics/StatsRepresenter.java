package by.grsu.oop.ApacheLogAnalyzer.statistics;

import java.io.IOException;
import java.text.ParseException;

import by.grsu.oop.ApacheLogAnalyzer.LogFileParser;
import by.grsu.oop.ApacheLogAnalyzer.file_worker.TextWriter;

public class StatsRepresenter {
	
	private TextStatisticEntry textStatisticEntry;
	
	private String newLine = System.getProperty("line.separator");
	
	public StatsRepresenter(LogFileParser logFileParser){
		textStatisticEntry = new TextStatisticEntry(logFileParser);
	}
	
	public void showInConsole() throws ParseException, IOException{
		System.out.println("Number of different files:");
		System.out.println("__________________________");
		System.out.println(textStatisticEntry.getTextFilesStatistic().showExtensionFrequency());
		System.out.println("Number of different statuses:");
		System.out.println(textStatisticEntry.getTextStatusStatistic().showStatusFrequency());
		System.out.println("Status percent ratio:");
		System.out.println(textStatisticEntry.getTextStatusStatistic().showStatusPercent());
		System.out.println("Daily requests:");
		System.out.println(textStatisticEntry.getTextDailyRequestStatistic().showStatusFrequencyByTime());
		System.out.println(textStatisticEntry.getTextDailyRequestStatistic().showStatusFrequencyPerDay());
	}
	
	public void saveToFile(String fileName) throws ParseException, IOException{
		TextWriter textWriter = new TextWriter();
		StringBuilder sb = new StringBuilder();
		
		sb.append("Number of different files:");
		sb.append(newLine);
		sb.append(textStatisticEntry.getTextFilesStatistic().showExtensionFrequency());
		sb.append("Number of different statuses:");
		sb.append(newLine);
		sb.append(textStatisticEntry.getTextStatusStatistic().showStatusFrequency());
		sb.append("Status percent ratio:");
		sb.append(newLine);
		sb.append(textStatisticEntry.getTextStatusStatistic().showStatusPercent());
		sb.append("Daily requests:");
		sb.append(newLine);
		sb.append(textStatisticEntry.getTextDailyRequestStatistic().showStatusFrequencyByTime());
		sb.append(textStatisticEntry.getTextDailyRequestStatistic().showStatusFrequencyPerDay());
		
		textWriter.writeToTextFile(sb.toString(), fileName);
	}
	
}
