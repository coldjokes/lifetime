package me.lifetime.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Axis {

	private int axisId;
	
	private Date time;

	private String label;
//	经度---lon---y轴
	private BigDecimal lontitude;
//	纬度---lat----x轴
	private BigDecimal latitude;
	
	private int scale;
	
	private double height;
	
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public BigDecimal getLontitude() {
		return lontitude;
	}

	public void setLontitude(BigDecimal lontitude) {
		this.lontitude = lontitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	
}
