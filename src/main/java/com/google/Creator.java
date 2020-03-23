package com.google;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Creator{

	@JsonProperty("displayName")
	private String displayName;

	@JsonProperty("self")
	private boolean self;

	@JsonProperty("email")
	private String email;

	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}

	public String getDisplayName(){
		return displayName;
	}

	public void setSelf(boolean self){
		this.self = self;
	}

	public boolean isSelf(){
		return self;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"Creator{" + 
			"displayName = '" + displayName + '\'' + 
			",self = '" + self + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}