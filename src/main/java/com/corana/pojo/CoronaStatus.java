package com.corana.pojo;

public class CoronaStatus {
private String state;
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public int getTotalCases() {
	return totalCases;
}
public void setTotalCases(int totalCases) {
	this.totalCases = totalCases;
}
private String country;
private int totalCases;
public CoronaStatus() {
	super();
}
public CoronaStatus(String state, String country, int totalCases) {
	super();
	this.state = state;
	this.country = country;
	this.totalCases = totalCases;
}
@Override
public String toString() {
	return "CoronaStatus [state=" + state + ", country=" + country + ", totalCases=" + totalCases + "]";
}

}
