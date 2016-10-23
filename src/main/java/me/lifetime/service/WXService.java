package me.lifetime.service;

import java.util.Arrays;
import java.util.Map;

import me.lifetime.common.AppConsts;
import me.lifetime.util.MessageUtil;
import me.lifetime.util.SHA1;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WXService {

	private static final Logger log = Logger.getLogger(WXService.class);
	
	private static final String TOKEN = "thisisatoken";
	
	@Autowired
	private AxisService axisSvc;
	@Autowired
	private EventService eventSvc;
	/**
	 * chat 用户消息交互
	 * @param map
	 * @return
	 */
	public String handleMsg(Map<String, String> map){
		String msgType = map.get(AppConsts.KEY_MSG_TYPE);
		
		String toUserName = map.get(AppConsts.KEY_TO_USER_NAME);
		String fromUserName = map.get(AppConsts.KEY_FROM_USER_NAME);
		String content = map.get(AppConsts.KEY_CONTENT);
		String eventType = map.get(AppConsts.KEY_EVENT);
		
		
		String returnMsg = null;

		if("0".equals(content)){
			axisSvc.updateLastStatus();
			returnMsg = AppConsts.MSG_SUCCESS;
		}else{
			if(AppConsts.MESSAGE_TYPE_EVENT.equals(msgType)){		//订阅、取消订阅事件
				if(AppConsts.MESSAGE_TYPE_SUBSCRIBE.equals(eventType)){
					
				}else if(AppConsts.MESSAGE_TYPE_UNSUBSCRIBE.equals(eventType)){
					
				}
			}else {
				
				int axisId = 0;
				int status = axisSvc.getLastStatus();
				
				if(status == 1){//还在更新中
					axisId = axisSvc.getLastId();
				}else{
					axisId = axisSvc.insertAndGetId();
				}
				
				
				if(AppConsts.MESSAGE_TYPE_TEXT.equals(msgType)){//文本事件
					
					eventSvc.insert(axisId, content);
					
//					returnMsg = "<a href='http://booscup.eicp.net/lifetime/end'>END</a>";
					returnMsg = AppConsts.MSG_SUCCESS_TEXT;
				}else if(AppConsts.MESSAGE_TYPE_IMAGE.equals(msgType)){
					returnMsg = "图片";
				}else if(AppConsts.MESSAGE_TYPE_LOCATION.equals(msgType)){
					returnMsg = "位置";
				}else if(AppConsts.MESSAGE_TYPE_SHORT_VIDEO.equals(msgType)){
					returnMsg = "小视频";
				}else if(AppConsts.MESSAGE_TYPE_VOICE.equals(msgType)){
					returnMsg = "语音";
				}
			}
		}
		

		return MessageUtil.initText(toUserName, fromUserName, returnMsg);
	}
	
	
	
	/**
	 * 验证token
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public boolean checkToken(String signature, String timestamp, String nonce) {
		String arr[] = new String[]{TOKEN,timestamp,nonce};
		//排序
		Arrays.sort(arr);
		
		//生成字符串
		StringBuffer content = new StringBuffer();
		for(String s:arr){
			content.append(s);
		}
		//sha1加密
		String temp = SHA1.hex_sha1(content.toString());
		return temp.equals(signature);
	}
	
}
