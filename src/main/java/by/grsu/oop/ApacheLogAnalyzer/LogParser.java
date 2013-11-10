package by.grsu.oop.ApacheLogAnalyzer;

import java.text.ParseException;

import by.grsu.oop.ApacheLogAnalyzer.parsers.ClientParser;
import by.grsu.oop.ApacheLogAnalyzer.parsers.DateParser;
import by.grsu.oop.ApacheLogAnalyzer.parsers.ErrorParser;
import by.grsu.oop.ApacheLogAnalyzer.parsers.IpParser;
import by.grsu.oop.ApacheLogAnalyzer.parsers.MethodParser;
import by.grsu.oop.ApacheLogAnalyzer.parsers.ObjectSizeParser;
import by.grsu.oop.ApacheLogAnalyzer.parsers.PathParser;
import by.grsu.oop.ApacheLogAnalyzer.parsers.ProtocolParser;

public class LogParser {
	
	private ClientParser clientParser = new ClientParser();
	private DateParser dateParser = new DateParser();
	private ErrorParser errorParser = new ErrorParser();
	private IpParser ipParser = new IpParser();
	private MethodParser methodParser = new MethodParser();
	private ObjectSizeParser objectSizeParser = new ObjectSizeParser();
	private PathParser pathParser = new PathParser();
	private ProtocolParser protocolParser = new ProtocolParser();
	
	public LogEntry parse(String logString) throws ParseException{
		
		LogEntry logEntry = new LogEntry();
		
		//ip
		String[] parts = logString.split(" ", 2);
		logEntry.setIp(ipParser.getIpObject(parts[0]));
		
		//- 
		String[] parts1 = parts[1].split(" ", 2);
		
		//client
		String[] parts2 = parts1[1].split(" ", 2);
		logEntry.setClient(clientParser.getClientObject(parts2[0]));
		
		//date
		String[] parts3 = parts2[1].split("\\] \"");
		String dateText = parts3[0].substring(1);
		logEntry.setDate(dateParser.getDateObject(dateText));
		
		//Method
		String[] parts4 = parts3[1].split(" ", 2);
		logEntry.setMethod(methodParser.getMethodObject(parts4[0]));
		
		//Path
		String[] parts5 = parts4[1].split(" ", 2);
		logEntry.setPath(pathParser.getPathObject(parts5[0]));
		
		//Protocol
		String[] parts6 = parts5[1].split("\" ", 2);
		logEntry.setProtocol(protocolParser.getProtocolObject(parts6[0]));
		
		//Error
		String[] parts7 = parts6[1].split(" ", 2);
		logEntry.setError(errorParser.getErrorObject(parts7[0]));
		
		//ObjectSize
		logEntry.setObjectSize(objectSizeParser.getObjectSizeObject(parts7[1]));
		
		return logEntry;
	}
	
}
