package me.lifetime.entity;

import java.util.Date;

public class Event {

	private int eventId;
	
	private int axisId;
	
	private String fromUserName;
	
	private String text;
	
	private Date createTime;

	public Event(){};
	
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

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
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
