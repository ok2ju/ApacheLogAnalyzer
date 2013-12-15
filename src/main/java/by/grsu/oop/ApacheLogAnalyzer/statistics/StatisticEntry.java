package by.grsu.oop.ApacheLogAnalyzer.statistics;

import by.grsu.oop.ApacheLogAnalyzer.LogFileParser;
import by.grsu.oop.ApacheLogAnalyzer.statistics.statistic.DailyRequestStatistic;
import by.grsu.oop.ApacheLogAnalyzer.statistics.statistic.FilesStatistic;
import by.grsu.oop.ApacheLogAnalyzer.statistics.statistic.StatusStatistic;

public class StatisticEntry {
	
	private FilesStatistic filesStatistic;
	private DailyRequestStatistic dailyRequestStatistic;
	private StatusStatistic statusStatistic;
	
	public StatisticEntry(LogFileParser logFileParser){
		setFilesStatistic(new FilesStatistic(logFileParser));
		setDailyRequestStatistic(new DailyRequestStatistic(logFileParser));
		setStatusStatistic(new StatusStatistic(logFileParser));
	}

	public FilesStatistic getFilesStatistic() {
		return filesStatistic;
	}

	public void setFilesStatistic(FilesStatistic filesStatistic) {
		this.filesStatistic = filesStatistic;
	}

	public DailyRequestStatistic getDailyRequestStatistic() {
		return dailyRequestStatistic;
	}

	public void setDailyRequestStatistic(DailyRequestStatistic dailyRequestStatistic) {
		this.dailyRequestStatistic = dailyRequestStatistic;
	}

	public StatusStatistic getStatusStatistic() {
		return statusStatistic;
	}

	public void setStatusStatistic(StatusStatistic statusStatistic) {
		this.statusStatistic = statusStatistic;
	}
	
	
	
}
