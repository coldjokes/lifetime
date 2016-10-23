package me.lifetime.entity;

import java.util.Date;

public class Axis {

	private int axisId;
	
	private Date time;

	private int status;//0 表示结束，1表示还未结束
	
	public Axis(){
		this.time = new Date();
		this.status = 1;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
