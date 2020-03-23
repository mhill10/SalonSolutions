package com.google;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Updated{

	@JsonProperty("dateOnly")
	private boolean dateOnly;

	@JsonProperty("tzShift")
	private int tzShift;

	@JsonProperty("value")
	private long value;

	public void setDateOnly(boolean dateOnly){
		this.dateOnly = dateOnly;
	}

	public boolean isDateOnly(){
		return dateOnly;
	}

	public void setTzShift(int tzShift){
		this.tzShift = tzShift;
	}

	public int getTzShift(){
		return tzShift;
	}

	public void setValue(long value){
		this.value = value;
	}

	public long getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"Updated{" + 
			"dateOnly = '" + dateOnly + '\'' + 
			",tzShift = '" + tzShift + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}