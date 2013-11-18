package by.grsu.oop.ApacheLogAnalyzer;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.grsu.oop.ApacheLogAnalyzer.parsers.DateParser;
import by.grsu.oop.ApacheLogAnalyzer.parsers.StatusParser;
import by.grsu.oop.ApacheLogAnalyzer.parsers.IpParser;
import by.grsu.oop.ApacheLogAnalyzer.parsers.MethodParser;
import by.grsu.oop.ApacheLogAnalyzer.parsers.ObjectSizeParser;
import by.grsu.oop.ApacheLogAnalyzer.parsers.PathParser;
import by.grsu.oop.ApacheLogAnalyzer.parsers.ProtocolParser;

public class LogParser {
	
	private DateParser dateParser = new DateParser();
	private StatusParser errorParser = new StatusParser();
	private IpParser ipParser = new IpParser();
	private MethodParser methodParser = new MethodParser();
	private ObjectSizeParser objectSizeParser = new ObjectSizeParser();
	private PathParser pathParser = new PathParser();
	private ProtocolParser protocolParser = new ProtocolParser();
	
	public LogEntry parse(String logString) throws ParseException{
		
		LogEntry logEntry = new LogEntry();
		
		//Ip
		Pattern ipPattern = Pattern.compile("[1-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}");
		Matcher m = ipPattern.matcher(logString);
		
		if(m.find()){
			logEntry.setIp(ipParser.getIpObject(m.group()));
		}
		
		//Date regex 18/Jul/2013:16:43:19 +2300
		//"(0[1-9]|[12][0-9]|3[01])[- ///](Jun|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)[- ///](19|20\\d\\d)[- //:]([0-1]\\d|2[0-3])[- //:]([0-5]\\d)[- //:]([0-5]\\d)\\s([- //+]\\d{4})"
		//Date regex 29.10.2013 16:43:19 +0300
		// "(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4} (0[0-9]|1[0-9]|2[0-3])(:[0-5][0-9]){2} ([- /+|-]\d{4})"
		Pattern datePattern = Pattern.compile("(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4} (0[0-9]|1[0-9]|2[0-3])(:[0-5][0-9]){2} ([- /+|-]\\d{4})");
		Matcher dateMatcher = datePattern.matcher(logString);
		
		if(dateMatcher.find()){
			//переделать формат даты в {Day}/{Month 3 letter}/{year}:{hours}:{minutes}:{seconds} +{time offset, 4 digits}
			logEntry.setDate(dateParser.getDateObject(dateMatcher.group()));
		}
		
		//Method
		Pattern methodPattern = Pattern.compile("(POST|GET|HEAD|OPTIONS|PUT|PATCH|DELETE|TRACE|LINK|UNLINK|CONNECT)");
		Matcher methodMatcher = methodPattern.matcher(logString);
		
		if(methodMatcher.find()){
			logEntry.setMethod(methodParser.getMethodObject(methodMatcher.group()));
		}
		
		//Protocol
		Pattern protocolPattern = Pattern.compile("(HTTP|FTP|POP|SMTP|telnet|DTN)[- //][0-9][- /.][0-9]");
		Matcher protocolMatcher = protocolPattern.matcher(logString);
		
		if(protocolMatcher.find()){
			logEntry.setProtocol(protocolParser.getProtocolObject(protocolMatcher.group()));
		}
		
		//Path
		Pattern pathPattern = Pattern.compile("\\/((([A-z]|[0-9]|[.,*!?+:Е-])+\\/)*([A-z]|[0-9]|[.,*!?+Е-])+\\.[A-Za-z]+)");
		Matcher pathMatcher = pathPattern.matcher(logString);
		
		if(pathMatcher.find()){
			logEntry.setPath(pathParser.getPathObject(pathMatcher.group()));
		}
		
		//Status + ObjectSize
		Pattern statusAndObjPattern = Pattern.compile("[1|2|3|4|5][0-9]{2} [0-9]{1,}");
		Matcher statusAndObjMatcher = statusAndObjPattern.matcher(logString);
		
		if(statusAndObjMatcher.find()){
			String[] statusAndObjSize = statusAndObjMatcher.group().split(" ");
			logEntry.setStatus(errorParser.getErrorObject(statusAndObjSize[0]));
			logEntry.setObjectSize(objectSizeParser.getObjectSizeObject(statusAndObjSize[1]));
		}
		
		return logEntry;
	}
	
}
