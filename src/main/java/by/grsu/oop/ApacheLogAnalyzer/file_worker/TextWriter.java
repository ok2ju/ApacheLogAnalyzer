package by.grsu.oop.ApacheLogAnalyzer.file_worker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextWriter {

	public void writeToTextFile(String source, String fileName) throws IOException {
		File file = new File(fileName);

		FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);
		fileWriter.write(source);
		fileWriter.close();
	}
	
}
