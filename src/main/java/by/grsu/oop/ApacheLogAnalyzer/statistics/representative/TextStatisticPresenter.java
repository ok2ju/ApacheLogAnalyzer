package by.grsu.oop.ApacheLogAnalyzer.statistics.representative;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import by.grsu.oop.ApacheLogAnalyzer.LogFileParser;
import by.grsu.oop.ApacheLogAnalyzer.statistics.LogStatistic;

public class TextStatisticPresenter {

	private LogStatistic logStatistic;
	private String newLine = System.getProperty("line.separator");

	public TextStatisticPresenter(LogFileParser logFileParser) {
		this.logStatistic = new LogStatistic(logFileParser);
	}

	public String showStatusFrequency() throws ParseException, IOException {
		Map<String, Integer> map = logStatistic.getNumberOfStatus();
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

	public String showExtensionFrequency() throws ParseException, IOException {
		Map<String, Integer> map = logStatistic.getNumberOfFiles();
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

	public String showStatusPercent() throws ParseException, IOException {
		Map<String, Double> map = logStatistic.getStatusPercentageRatio();
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
			sb.append(status.getValue()+"%");
			sb.append(newLine);
		}
		return sb.toString();
	}

	public String showStatusFrequencyByTime() throws ParseException, IOException {
		Map<Integer, Integer> map = logStatistic.getStatusFrequencyByTime();
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
			sb.append(hour.getKey()+" hours");
			sb.append(" - ");
			sb.append(hour.getValue());
			sb.append(newLine);
		}
		return sb.toString();
	}

	public String showStatusFrequencyPerDay() throws ParseException, IOException {
		Map<String, Integer> map = logStatistic.getStatusFrequencyPerDay();
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
