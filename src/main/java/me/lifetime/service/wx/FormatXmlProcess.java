package me.lifetime.service.wx;

import java.util.Date;

import me.lifetime.common.AppConsts;
import me.lifetime.entity.wx.TextMessage;

import org.springframework.stereotype.Service;

import com.thoughtworks.xstream.XStream;

/**
 *  封装最终的xml格式结果
 */
@Service
public class FormatXmlProcess {

	/**
	 * 封装文字类的返回消息 
	 * @param to
	 * @param from
	 * @param content
	 * @return
	 */
	public String formatXmlAnswer(String to, String from, String content) {  
		TextMessage text = new TextMessage();
		text.setFromUserName(from);
		text.setToUserName(to);
		text.setMsgType(AppConsts.MESSAGE_TYPE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
        return textMessageToXml(text);
    }  
	
	
	
	
	/**
	 * 消息对象转为xml
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage){
		XStream xStream = new XStream();
		xStream.alias("xml", textMessage.getClass());
		return xStream.toXML(textMessage);
	}
	
	
	
	
}
