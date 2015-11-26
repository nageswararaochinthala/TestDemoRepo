package com.caprusit.ems.domain;

import java.io.Serializable;

public class DayType implements Serializable{
	private static final long serialVersionUID = 1L;
	private int dayIndicator;
	private String dayName;
	
	public int getDayIndicator() {
		return dayIndicator;
	}
	public void setDayIndicator(int dayIndicator) {
		this.dayIndicator = dayIndicator;
	}
	public String getDayName() {
		return dayName;
	}
	public void setDayName(String dayName) {
		this.dayName = dayName;
	}
	@Override
	public String toString() {
		return "DayType [dayIndicator=" + dayIndicator + ", dayName=" + dayName + "]";
	}
	
	
}
