package me.lifetime.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Location {

	private int locationId;
	
	private int axisId;
	
	private String name;
	
	private BigDecimal lontitude;
	
	private BigDecimal latitude;
	
	private int scale;
	
	private double height;

	private Date createTime;
	
	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getAxisId() {
		return axisId;
	}

	public void setAxisId(int axisId) {
		this.axisId = axisId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
