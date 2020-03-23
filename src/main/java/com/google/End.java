package com.google;

import com.fasterxml.jackson.annotation.JsonProperty;

public class End{

	@JsonProperty("dateTime")
	private DateTime dateTime;

	@JsonProperty("timeZone")
	private String timeZone;

	public void setDateTime(DateTime dateTime){
		this.dateTime = dateTime;
	}

	public DateTime getDateTime(){
		return dateTime;
	}

	public void setTimeZone(String timeZone){
		this.timeZone = timeZone;
	}

	public String getTimeZone(){
		return timeZone;
	}

	@Override
 	public String toString(){
		return 
			"End{" + 
			"dateTime = '" + dateTime + '\'' + 
			",timeZone = '" + timeZone + '\'' + 
			"}";
		}
}