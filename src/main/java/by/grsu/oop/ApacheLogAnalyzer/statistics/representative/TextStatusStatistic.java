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

public class TextStatusStatistic {
	
	private String newLine = System.getProperty("line.separator");
	private StatisticEntry statisticEntry;
	
	public TextStatusStatistic(StatisticEntry statisticEntry){
		this.statisticEntry = statisticEntry;
	}

	public String showStatusFrequency() throws ParseException, IOException {
		Map<String, Integer> map = statisticEntry.getStatusStatistic()
				.getNumberOfStatus();
		StringBuilder sb = new StringBuilder();

		List<Entry<String, Integer>> entries = new ArrayList<Entry<String, Integer>>(
				map.entrySet());
		Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> object1,
					Entry<String, Integer> object2) {
				return object2.getValue() - object1.getValue();
			}
		});

		for (Entry<String, Integer> status : entries) {
			sb.append(status.getKey());
			sb.append(" - ");
			sb.append(status.getValue());
			sb.append(newLine);
		}
		return sb.toString();
	}

	public String showStatusPercent() throws ParseException, IOException {
		Map<String, Double> map = statisticEntry.getStatusStatistic()
				.getStatusPercentageRatio();
		StringBuilder sb = new StringBuilder();

		List<Entry<String, Double>> entries = new ArrayList<Entry<String, Double>>(
				map.entrySet());
		Collections.sort(entries, new Comparator<Entry<String, Double>>() {
			public int compare(Entry<String, Double> object1,
					Entry<String, Double> object2) {
				return (int) (object2.getValue() - object1.getValue());
			}
		});

		for (Entry<String, Double> status : entries) {
			sb.append(status.getKey());
			sb.append(" - ");
			sb.append(status.getValue() + "%");
			sb.append(newLine);
		}
		return sb.toString();
	}
}
