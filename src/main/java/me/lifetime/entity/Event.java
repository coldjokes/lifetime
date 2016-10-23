package me.lifetime.entity;

import java.util.Date;

public class Event {

	private int eventId;
	
	private int axisId;
	
	private String text;
	
	private Date createTime;

	public Event(){};
	
	public Event(int axisId, String text){
		this.axisId = axisId;
		this.text = text;
		this.createTime = new Date();
	}
	
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getAxisId() {
		return axisId;
	}

	public void setAxisId(int axisId) {
		this.axisId = axisId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
