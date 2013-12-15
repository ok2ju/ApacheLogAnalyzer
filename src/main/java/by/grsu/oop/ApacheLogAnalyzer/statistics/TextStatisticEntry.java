package by.grsu.oop.ApacheLogAnalyzer.statistics;

import by.grsu.oop.ApacheLogAnalyzer.LogFileParser;
import by.grsu.oop.ApacheLogAnalyzer.statistics.representative.TextDailyRequestStatistic;
import by.grsu.oop.ApacheLogAnalyzer.statistics.representative.TextFilesStatistic;
import by.grsu.oop.ApacheLogAnalyzer.statistics.representative.TextStatusStatistic;

public class TextStatisticEntry {

	private StatisticEntry statisticEntry;
	private TextStatusStatistic textStatusStatistic;
	private TextFilesStatistic textFilesStatistic;
	private TextDailyRequestStatistic textDailyRequestStatistic;

	public TextStatisticEntry(LogFileParser logFileParser) {
		this.statisticEntry = new StatisticEntry(logFileParser);
		textStatusStatistic = new TextStatusStatistic(statisticEntry);
		textFilesStatistic = new TextFilesStatistic(statisticEntry);
		textDailyRequestStatistic = new TextDailyRequestStatistic(statisticEntry);
	}

	public TextStatusStatistic getTextStatusStatistic() {
		return textStatusStatistic;
	}

	public void setTextStatusStatistic(TextStatusStatistic textStatusStatistic) {
		this.textStatusStatistic = textStatusStatistic;
	}

	public TextFilesStatistic getTextFilesStatistic() {
		return textFilesStatistic;
	}

	public void setTextFilesStatistic(TextFilesStatistic textFilesStatistic) {
		this.textFilesStatistic = textFilesStatistic;
	}

	public TextDailyRequestStatistic getTextDailyRequestStatistic() {
		return textDailyRequestStatistic;
	}

	public void setTextDailyRequestStatistic(
			TextDailyRequestStatistic textDailyRequestStatistic) {
		this.textDailyRequestStatistic = textDailyRequestStatistic;
	}

}
