package by.grsu.oop.ApacheLogAnalyzer.file_worker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextReader {
	
	public List<String> getLogRecords() throws IOException{
		List<String> lines = new ArrayList<String>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader("Text-ApacheAccessLog.txt"));
		
		String line;
		while((line = bufferedReader.readLine())!=null){
			lines.add(line);
		}
		
		return lines;
		
	}
	
}
