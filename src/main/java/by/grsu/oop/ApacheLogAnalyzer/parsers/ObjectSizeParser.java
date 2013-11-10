package by.grsu.oop.ApacheLogAnalyzer.parsers;

import by.grsu.oop.ApacheLogAnalyzer.model.ObjectSize;

public class ObjectSizeParser {
	
	public ObjectSize getObjectSizeObject(String textObjectSize){
		
		int intObjSize = Integer.parseInt(textObjectSize);
		
		return new ObjectSize(intObjSize);
		
	}
	
}
