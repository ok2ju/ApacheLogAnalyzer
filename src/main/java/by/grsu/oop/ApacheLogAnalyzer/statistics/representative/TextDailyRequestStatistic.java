package by.grsu.oop.ApacheLogAnalyzer.statistics.representative;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import by.grsu.oop.ApacheLogAnalyzer.statistics.StatisticEntry;

public class TextDailyRequestStatistic {
	
	private StatisticEntry statisticEntry;
	private String newLine = System.getProperty("line.separator");
	
	public TextDailyRequestStatistic(StatisticEntry statisticEntry){
		this.statisticEntry = statisticEntry;
	}

	public String showStatusFrequencyByTime() throws ParseException, IOException {
		Map<Integer, Integer> map = statisticEntry.getDailyRequestStatistic()
				.getStatusFrequencyByTime();
		StringBuilder sb = new StringBuilder();

		List<Entry<Integer, Integer>> entries = new ArrayList<Entry<Integer, Integer>>(
				map.entrySet());
		Collections.sort(entries, new Comparator<Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> object1,
					Entry<Integer, Integer> object2) {
				return object2.getValue() - object1.getValue();
			}
		});

		for (Entry<Integer, Integer> hour : entries) {
			sb.append(hour.getKey() + " hours");
			sb.append(" - ");
			sb.append(hour.getValue());
			sb.append(newLine);
		}
		return sb.toString();
	}

	public String showStatusFrequencyPerDay() throws ParseException, IOException {
		Map<String, Integer> map = statisticEntry.getDailyRequestStatistic()
				.getStatusFrequencyPerDay();
		StringBuilder sb = new StringBuilder();

		List<Entry<String, Integer>> entries = new ArrayList<Entry<String, Integer>>(
				map.entrySet());
		Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> object1,
					Entry<String, Integer> object2) {
				return object2.getValue() - object1.getValue();
			}
		});

		for (Entry<String, Integer> partOfDay : entries) {
			sb.append(partOfDay.getKey());
			sb.append(" - ");
			sb.append(partOfDay.getValue());
			sb.append(newLine);
		}
		return sb.toString();
	}
}
