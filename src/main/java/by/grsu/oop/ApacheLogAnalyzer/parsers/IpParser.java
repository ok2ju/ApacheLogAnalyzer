package by.grsu.oop.ApacheLogAnalyzer.parsers;

import by.grsu.oop.ApacheLogAnalyzer.model.Ip;

public class IpParser {
	
	public Ip getIpObject(String textIp){
		
		String[] octetTextArray = textIp.split("\\.");
		int[] octetIntArray = new int[octetTextArray.length];
		
		for(int i=0;i<octetTextArray.length;i++){
			octetIntArray[i] = Integer.parseInt(octetTextArray[i]);
		}
		
		return new Ip(octetIntArray);
		
	}
	
}
