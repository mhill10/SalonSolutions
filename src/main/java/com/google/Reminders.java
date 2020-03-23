package com.google;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reminders{

	@JsonProperty("useDefault")
	private boolean useDefault;

	public void setUseDefault(boolean useDefault){
		this.useDefault = useDefault;
	}

	public boolean isUseDefault(){
		return useDefault;
	}

	@Override
 	public String toString(){
		return 
			"Reminders{" + 
			"useDefault = '" + useDefault + '\'' + 
			"}";
		}
}