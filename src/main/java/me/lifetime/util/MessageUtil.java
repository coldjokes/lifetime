package me.lifetime.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import me.lifetime.common.AppConsts;
import me.lifetime.entity.TextMessage;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

public class MessageUtil {
	
//	private static final Logger log = Logger.getLogger(MessageUtil.class);

	
	
	/**
	 * xml转map
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String, String> map = new HashMap<String,String>();
		SAXReader reader = new SAXReader();
		
		InputStream ins = request.getInputStream();
		Document doc = reader.read(ins,"utf-8");
		Element root = doc.getRootElement();
		List<Element> list = root.elements();
		for(Element e:list){
			map.put(e.getName(), e.getText());
		}
		ins.close();
		return map;
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
	
	public static String initText(String toUserName,String fromUserName,String content){
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(AppConsts.MESSAGE_TYPE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		return textMessageToXml(text);
	}
	
	/**
	 * 主菜单
	 * @return
	 */
	public static String menuText(){
		StringBuffer sb = new StringBuffer();
		sb.append("AA");
		return sb.toString();
	}
}
