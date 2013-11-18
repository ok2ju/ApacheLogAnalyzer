package by.grsu.oop.ApacheLogAnalyzer;

import by.grsu.oop.ApacheLogAnalyzer.model.Date;
import by.grsu.oop.ApacheLogAnalyzer.model.Status;
import by.grsu.oop.ApacheLogAnalyzer.model.Ip;
import by.grsu.oop.ApacheLogAnalyzer.model.Method;
import by.grsu.oop.ApacheLogAnalyzer.model.ObjectSize;
import by.grsu.oop.ApacheLogAnalyzer.model.Path;
import by.grsu.oop.ApacheLogAnalyzer.model.Protocol;

public class LogEntry {
	
	private Date date;
	private Status status;
	private Ip ip;
	private Method method;
	private ObjectSize objectSize;
	private Path path;
	private Protocol protocol;
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Ip getIp() {
		return ip;
	}
	
	public void setIp(Ip ip) {
		this.ip = ip;
	}
	
	public Method getMethod() {
		return method;
	}
	
	public void setMethod(Method method) {
		this.method = method;
	}
	
	public ObjectSize getObjectSize() {
		return objectSize;
	}
	
	public void setObjectSize(ObjectSize objectSize) {
		this.objectSize = objectSize;
	}
	
	public Path getPath() {
		return path;
	}
	
	public void setPath(Path path) {
		this.path = path;
	}
	
	public Protocol getProtocol() {
		return protocol;
	}
	
	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}
	
}
