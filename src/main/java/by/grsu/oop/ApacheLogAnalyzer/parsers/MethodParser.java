package by.grsu.oop.ApacheLogAnalyzer.parsers;

import by.grsu.oop.ApacheLogAnalyzer.model.Method;

public class MethodParser {
	
	public Method getMethodObject(String textMethod){
		
		return new Method(textMethod);
		
	}
	
}
