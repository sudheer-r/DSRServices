package com.bus.service.beans;

public class Ticket {
	private String name;
	private String source;
	private String destination;
	private String date1;
	private String travels;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date) {
		this.date1 = date;
	}

	public String getTravels() {
		return travels;
	}

	public void setTravels(String travels) {
		this.travels = travels;
	}
}
