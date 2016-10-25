package me.lifetime.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import me.lifetime.common.AppConsts;
import me.lifetime.entity.Axis;
import me.lifetime.entity.User;
import me.lifetime.util.MessageUtil;
import me.lifetime.util.SHA1;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WXService {

	private static final Logger log = Logger.getLogger(WXService.class);
	
	@Autowired
	private UserService userSvc;
	@Autowired
	private AxisService axisSvc;
	@Autowired
	private EventService eventSvc;
	@Autowired
	private ImageService imageSvc;
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
		String mediaId = map.get(AppConsts.KEY_MEDIA_ID);
		String label = map.get(AppConsts.KEY_LABEL);
		String scale = map.get(AppConsts.KEY_SCALE);
		String locationX = map.get(AppConsts.KEY_LOCATION_X);
		String locationY = map.get(AppConsts.KEY_LOCATION_Y);
		
		String returnMsg = null;

		if(AppConsts.MESSAGE_TYPE_EVENT.equals(msgType)){		//订阅、取消订阅事件
			if(AppConsts.MESSAGE_TYPE_SUBSCRIBE.equals(eventType)){
				User user = userSvc.getUser(fromUserName);
				if(user != null){
					user.setSubscribeTime(new Date());
					user.setUnsubscribeTime(null);
					userSvc.update(user);
					returnMsg = AppConsts.MSG_SUCCESS_SUBSCRIBE_AG;
				}else{
					user = new User();
					user.setFromUserName(fromUserName);
					user.setSubscribeTime(new Date());
					userSvc.insert(user);
					returnMsg = AppConsts.MSG_SUCCESS_SUBSCRIBE;	
				}
				
			}else if(AppConsts.MESSAGE_TYPE_UNSUBSCRIBE.equals(eventType)){
				User user = userSvc.getUser(fromUserName);
				if(user != null){
					user.setUnsubscribeTime(new Date());
					userSvc.update(user);
				}
			}
		}else {
			
			//获取时间轴信息
			int axisId = 0;
			Axis axis = axisSvc.getLastAxis(fromUserName);
			if(axis != null && axis.getStatus() == 1){//还在更新中
				axisId = axis.getAxisId();
			}else{
				axisId = axisSvc.insertAndGetId(fromUserName);
			}
			
			if(AppConsts.MESSAGE_TYPE_TEXT.equals(msgType)){//文本事件
				
				if(StringUtils.isNotEmpty(content)){
					if("0".equals(content)){//表明结束该时间点记录
						//将最后axis标识为结束
						axisSvc.updateLastStatus(fromUserName);
						
						Axis a = axisSvc.getLastAxis(fromUserName);
						if(a != null){
							StringBuffer sb = new StringBuffer();
							sb.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(a.getTime()))
							.append("\n")
							.append(AppConsts.MSG_SUCCESS);
							returnMsg = sb.toString();
						}else{
							returnMsg = AppConsts.MSG_NO_RECORD;
						}
						
					} else if(content.startsWith("p/")){//为照片起名
						String name = null;
						String[] arr = content.split("p/");
						if(arr.length > 1){
							name = arr[1];
						}
						imageSvc.updateImageName(fromUserName, name);
						returnMsg = AppConsts.MSG_SUCCESS_IMAGE_NAME;
					} else if(content.startsWith("d/")){//为照片增加描述
						String description = null;
						String[] arr = content.split("d/");
						if(arr.length > 1){
							description = arr[1];
						}
						imageSvc.updateImageDescription(fromUserName, description);
						
						
						returnMsg = AppConsts.MSG_SUCCESS_IMAGE_DESCRIPTION;
					} else{
						eventSvc.insert(axisId, content);
						returnMsg = AppConsts.MSG_SUCCESS_TEXT;
					}
				}
			}else if(AppConsts.MESSAGE_TYPE_IMAGE.equals(msgType)){
				imageSvc.insert(axisId,fromUserName, mediaId);

				StringBuffer sb = new StringBuffer();
				
				sb.append(AppConsts.MSG_SUCCESS_IMAGE)
				.append("\n")
				.append(AppConsts.MSG_IMAGE_NAME)
				.append("\n")
				.append(AppConsts.MSG_IMAGE_DESCRIPTION);
				returnMsg = sb.toString();
			}else if(AppConsts.MESSAGE_TYPE_LOCATION.equals(msgType)){
				
				axis = axisSvc.getById(axisId);
				axis.setLabel(label);
				axis.setLontitude(new BigDecimal(locationY));
				axis.setLatitude(new BigDecimal(locationX));
				axis.setScale(Integer.valueOf(scale));
				axisSvc.updateAxis(axis);
				returnMsg = AppConsts.MSG_SUCCESS_LOCATION;

			}else if(AppConsts.MESSAGE_TYPE_SHORT_VIDEO.equals(msgType)){
				returnMsg = "小视频";
			}else if(AppConsts.MESSAGE_TYPE_VOICE.equals(msgType)){
				returnMsg = "语音";
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
		String arr[] = new String[]{AppConsts.WX_TOKEN,timestamp,nonce};
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
