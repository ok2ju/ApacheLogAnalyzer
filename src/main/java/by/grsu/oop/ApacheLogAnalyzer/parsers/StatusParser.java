package by.grsu.oop.ApacheLogAnalyzer.parsers;

import by.grsu.oop.ApacheLogAnalyzer.model.Status;

public class StatusParser {
	
	public Status getErrorObject(String textError){
		
		return new Status(textError);
		
	}
	
}
