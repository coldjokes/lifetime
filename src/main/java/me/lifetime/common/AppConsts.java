package me.lifetime.common;

public class AppConsts {

	//wx common
	public static final String WX_TOKEN 						= "thisisatoken";
	//磁盘路径
//	public static final String IMAGE_SAVE_PATH					= "D:\\lifetime\\images\\";
	public static final String IMAGE_SAVE_PATH					= "/home/pi/if/lifetime/images/";
	
	//wx message type
	public static final String MESSAGE_TYPE_TEXT				= "text";
	public static final String MESSAGE_TYPE_IMAGE				= "image";
	public static final String MESSAGE_TYPE_LOCATION			= "location";
	public static final String MESSAGE_TYPE_SHORT_VIDEO			= "shortvideo";
	public static final String MESSAGE_TYPE_VOICE				= "voice";
	public static final String MESSAGE_TYPE_LINK				= "link";
	public static final String MESSAGE_TYPE_EVENT				= "event";
	public static final String MESSAGE_TYPE_SUBSCRIBE			= "subscribe";
	public static final String MESSAGE_TYPE_UNSUBSCRIBE 		= "unsubscribe";
	
	public static final String MESSAGE_CLICK					= "CLICK";
	public static final String MESSAGE_VIEW						= "VIEW";
	
	//微信返回信息messages.properties
	public static final String MSG_NO_RECORD	 				= Messages.get("message.no.record");
	public static final String MSG_SUCCESS	 					= Messages.get("message.success");
	public static final String MSG_SUCCESS_TEXT	 				= Messages.get("message.success.text");
	public static final String MSG_SUCCESS_IMAGE	 			= Messages.get("message.success.image");
	public static final String MSG_IMAGE_NAME					= Messages.get("message.image.name");
	public static final String MSG_IMAGE_DESCRIPTION			= Messages.get("message.image.description");
	public static final String MSG_SUCCESS_IMAGE_NAME			= Messages.get("message.success.image.name");
	public static final String MSG_SUCCESS_IMAGE_DESCRIPTION	= Messages.get("message.success.image.description");
	public static final String MSG_SUCCESS_IMAGE_DETAILS		= Messages.get("message.success.image.details");
	public static final String MSG_SUCCESS_LOCATION	 			= Messages.get("message.success.location");
	
	public static final String MSG_SUCCESS_SUBSCRIBE 			= Messages.get("message.success.subscribe");
	public static final String MSG_SUCCESS_SUBSCRIBE_AG			= Messages.get("message.success.subscribe.ag");
	
	//出现错误或异常返回信息 message.properties
	public static final String EXP_SYSTEM						= Messages.get("exception.system");
	public static final String EXP_XML_DATA						= Messages.get("exception.xml.data");
	public static final String EXP_XML_PARSE					= Messages.get("exception.xml.parse");
	public static final String EXP_ACCESS_TOEKN_GET				= Messages.get("exception.access.token.get");
	
	
	//主要配置文件信息 lifetime.properties
	public static final String PROP_WX_APP_ID	 				= Config.get("wx.app.id");
	public static final String PROP_WX_SECRET_ID 				= Config.get("wx.app.secret");
	public static final String PROP_QINIU_ACCESS_KEY			= Config.get("qiniu.access.key");
	public static final String PROP_QINIU_SECRET_KEY			= Config.get("qiniu.secret.key");

	//七牛
	public static final String QINIU_URL						= "http://ofk6e08bd.bkt.clouddn.com/";
	public static final String QINIU_BUCKET_NAME				= "lifetime";
	

}


