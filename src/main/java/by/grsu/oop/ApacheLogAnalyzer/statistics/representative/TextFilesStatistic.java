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

public class TextFilesStatistic {
	
	private StatisticEntry statisticEntry;
	private String newLine = System.getProperty("line.separator");
	
	public TextFilesStatistic(StatisticEntry statisticEntry){
		this.statisticEntry = statisticEntry;
	}

	public String showExtensionFrequency() throws ParseException, IOException {
		Map<String, Integer> map = statisticEntry.getFilesStatistic()
				.getNumberOfFiles();
		StringBuilder sb = new StringBuilder();

		List<Entry<String, Integer>> entries = new ArrayList<Entry<String, Integer>>(
				map.entrySet());
		Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> object1,
					Entry<String, Integer> object2) {
				return object2.getValue() - object1.getValue();
			}
		});

		for (Entry<String, Integer> extension : entries) {
			sb.append(extension.getKey());
			sb.append(" - ");
			sb.append(extension.getValue());
			sb.append(newLine);
		}
		return sb.toString();
	}
}
