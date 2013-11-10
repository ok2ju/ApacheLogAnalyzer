package by.grsu.oop.ApacheLogAnalyzer.parsers;

import by.grsu.oop.ApacheLogAnalyzer.model.Client;

public class ClientParser {
	
	public Client getClientObject(String textClient){
		
		return new Client(textClient);
		
	}
	
}
