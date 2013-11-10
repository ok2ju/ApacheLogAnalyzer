package by.grsu.oop.ApacheLogAnalyzer.model;

public class Protocol {
	
	private String protocol;
	private String version;
	
	public Protocol(String protocol, String version){
		this.protocol = protocol;
		this.version = version;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
}
