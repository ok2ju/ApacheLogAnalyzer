package by.grsu.oop.ApacheLogAnalyzer.model;

public class Ip {
	
	private int firstOctet;
	private int secondOctet;
	private int thirdOctet;
	private int fourthOctet;
	
	public Ip(int firstOctet, int secondOctet, int thirdOctet, int fourthOctet){
		this.firstOctet = firstOctet;
		this.secondOctet = secondOctet;
		this.thirdOctet = thirdOctet;
		this.fourthOctet = fourthOctet;
	}
	
	public Ip(int[] octetArray){
		this.firstOctet = octetArray[0];
		this.secondOctet = octetArray[1];
		this.thirdOctet = octetArray[2];
		this.fourthOctet = octetArray[3];
	}
	
	public int getFirstOctet() {
		return firstOctet;
	}
	
	public void setFirstOctet(int firstOctet) {
		this.firstOctet = firstOctet;
	}
	
	public int getSecondOctet() {
		return secondOctet;
	}
	
	public void setSecondOctet(int secondOctet) {
		this.secondOctet = secondOctet;
	}
	
	public int getThirdOctet() {
		return thirdOctet;
	}
	
	public void setThirdOctet(int thirdOctet) {
		this.thirdOctet = thirdOctet;
	}
	
	public int getFourthOctet() {
		return fourthOctet;
	}
	
	public void setFourthOctet(int fourthOctet) {
		this.fourthOctet = fourthOctet;
	}
	
}
