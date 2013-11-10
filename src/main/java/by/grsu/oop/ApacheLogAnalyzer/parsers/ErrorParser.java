package by.grsu.oop.ApacheLogAnalyzer.parsers;

import by.grsu.oop.ApacheLogAnalyzer.model.Error;

public class ErrorParser {
	
	public Error getErrorObject(String textError){
		
		return new Error(textError);
		
	}
	
}
