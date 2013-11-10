package by.grsu.oop.ApacheLogAnalyzer.parsers;

import by.grsu.oop.ApacheLogAnalyzer.model.Protocol;

public class ProtocolParser {
	
	public Protocol getProtocolObject(String textProtocol){
		
		String[] protocolParts = textProtocol.split("/");
		
		return new Protocol(protocolParts[0], protocolParts[1]);
		
	}
	
}
