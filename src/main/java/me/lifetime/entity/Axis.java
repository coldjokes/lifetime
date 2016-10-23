package me.lifetime.entity;

import java.util.Date;

public class Axis {

	private int axisId;
	
	private Date time;

	public Axis(){
		this.time = new Date();
	}
	
	public int getAxisId() {
		return axisId;
	}

	public void setAxisId(int axisId) {
		this.axisId = axisId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
