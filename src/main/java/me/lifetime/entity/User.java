package me.lifetime.entity;

import java.util.Date;


public class User {

	private String fromUserName;
	
	private Date subscribeTime;
	
	private Date unsubscribeTime;

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Date getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(Date subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public Date getUnsubscribeTime() {
		return unsubscribeTime;
	}

	public void setUnsubscribeTime(Date unsubscribeTime) {
		this.unsubscribeTime = unsubscribeTime;
	}
	
	
}


