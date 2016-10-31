package me.lifetime.entity;

import java.util.Date;

public class Image {

	private int imageId;
	
	private int axisId;
	
	private String fromUserName;
	
	private String mediaId;
	
	private String name;
	
	private String description;
	
	private String pathQiniu;
	
	private String pathDisk;
	
	private String pathWX;
	
	
	private Date createTime;

	public Image(){};
	
	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
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

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPathQiniu() {
		return pathQiniu;
	}

	public void setPathQiniu(String pathQiniu) {
		this.pathQiniu = pathQiniu;
	}
	
	public String getPathDisk() {
		return pathDisk;
	}

	public void setPathDisk(String pathDisk) {
		this.pathDisk = pathDisk;
	}

	public String getPathWX() {
		return pathWX;
	}

	public void setPathWX(String pathWX) {
		this.pathWX = pathWX;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
