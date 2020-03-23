package com.google;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpcomingEventsItem{

	@JsonProperty("Update Website and Facebook Marketing!")
	private String updateWebsiteAndFacebookMarketing;

	@JsonProperty("Work at Salon")
	private String workAtSalon;

	@JsonProperty("Pay Day from CWC!")
	private String payDayFromCWC;

	@JsonProperty("Haircut with Keazia!")
	private String haircutWithKeazia;

	@JsonProperty("Dentist appt!")
	private String dentistAppt;

	public void setUpdateWebsiteAndFacebookMarketing(String updateWebsiteAndFacebookMarketing){
		this.updateWebsiteAndFacebookMarketing = updateWebsiteAndFacebookMarketing;
	}

	public String getUpdateWebsiteAndFacebookMarketing(){
		return updateWebsiteAndFacebookMarketing;
	}

	public void setWorkAtSalon(String workAtSalon){
		this.workAtSalon = workAtSalon;
	}

	public String getWorkAtSalon(){
		return workAtSalon;
	}

	public void setPayDayFromCWC(String payDayFromCWC){
		this.payDayFromCWC = payDayFromCWC;
	}

	public String getPayDayFromCWC(){
		return payDayFromCWC;
	}

	public void setHaircutWithKeazia(String haircutWithKeazia){
		this.haircutWithKeazia = haircutWithKeazia;
	}

	public String getHaircutWithKeazia(){
		return haircutWithKeazia;
	}

	public void setDentistAppt(String dentistAppt){
		this.dentistAppt = dentistAppt;
	}

	public String getDentistAppt(){
		return dentistAppt;
	}

	@Override
 	public String toString(){
		return 
			"UpcomingEventsItem{" + 
			"update Website and Facebook Marketing! = '" + updateWebsiteAndFacebookMarketing + '\'' + 
			",work at Salon = '" + workAtSalon + '\'' + 
			",pay Day from CWC! = '" + payDayFromCWC + '\'' + 
			",haircut with Keazia! = '" + haircutWithKeazia + '\'' + 
			",dentist appt! = '" + dentistAppt + '\'' + 
			"}";
		}
}