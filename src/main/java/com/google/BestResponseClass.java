package com.google;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BestResponseClass{

	@JsonProperty("reminders")
	private Reminders reminders;

	@JsonProperty("summary")
	private String summary;

	@JsonProperty("creator")
	private Creator creator;

	@JsonProperty("created")
	private Created created;

	@JsonProperty("htmlLink")
	private String htmlLink;

	@JsonProperty("kind")
	private String kind;

	@JsonProperty("iCalUID")
	private String iCalUID;

	@JsonProperty("start")
	private Start start;

	@JsonProperty("originalStartTime")
	private OriginalStartTime originalStartTime;

	@JsonProperty("sequence")
	private int sequence;

	@JsonProperty("recurringEventId")
	private String recurringEventId;

	@JsonProperty("organizer")
	private Organizer organizer;

	@JsonProperty("end")
	private End end;

	@JsonProperty("etag")
	private String etag;

	@JsonProperty("id")
	private String id;

	@JsonProperty("updated")
	private Updated updated;

	@JsonProperty("status")
	private String status;

	public void setReminders(Reminders reminders){
		this.reminders = reminders;
	}

	public Reminders getReminders(){
		return reminders;
	}

	public void setSummary(String summary){
		this.summary = summary;
	}

	public String getSummary(){
		return summary;
	}

	public void setCreator(Creator creator){
		this.creator = creator;
	}

	public Creator getCreator(){
		return creator;
	}

	public void setCreated(Created created){
		this.created = created;
	}

	public Created getCreated(){
		return created;
	}

	public void setHtmlLink(String htmlLink){
		this.htmlLink = htmlLink;
	}

	public String getHtmlLink(){
		return htmlLink;
	}

	public void setKind(String kind){
		this.kind = kind;
	}

	public String getKind(){
		return kind;
	}

	public void setICalUID(String iCalUID){
		this.iCalUID = iCalUID;
	}

	public String getICalUID(){
		return iCalUID;
	}

	public void setStart(Start start){
		this.start = start;
	}

	public Start getStart(){
		return start;
	}

	public void setOriginalStartTime(OriginalStartTime originalStartTime){
		this.originalStartTime = originalStartTime;
	}

	public OriginalStartTime getOriginalStartTime(){
		return originalStartTime;
	}

	public void setSequence(int sequence){
		this.sequence = sequence;
	}

	public int getSequence(){
		return sequence;
	}

	public void setRecurringEventId(String recurringEventId){
		this.recurringEventId = recurringEventId;
	}

	public String getRecurringEventId(){
		return recurringEventId;
	}

	public void setOrganizer(Organizer organizer){
		this.organizer = organizer;
	}

	public Organizer getOrganizer(){
		return organizer;
	}

	public void setEnd(End end){
		this.end = end;
	}

	public End getEnd(){
		return end;
	}

	public void setEtag(String etag){
		this.etag = etag;
	}

	public String getEtag(){
		return etag;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setUpdated(Updated updated){
		this.updated = updated;
	}

	public Updated getUpdated(){
		return updated;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"BestResponseClass{" + 
			"reminders = '" + reminders + '\'' + 
			",summary = '" + summary + '\'' + 
			",creator = '" + creator + '\'' + 
			",created = '" + created + '\'' + 
			",htmlLink = '" + htmlLink + '\'' + 
			",kind = '" + kind + '\'' + 
			",iCalUID = '" + iCalUID + '\'' + 
			",start = '" + start + '\'' + 
			",originalStartTime = '" + originalStartTime + '\'' + 
			",sequence = '" + sequence + '\'' + 
			",recurringEventId = '" + recurringEventId + '\'' + 
			",organizer = '" + organizer + '\'' + 
			",end = '" + end + '\'' + 
			",etag = '" + etag + '\'' + 
			",id = '" + id + '\'' + 
			",updated = '" + updated + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}