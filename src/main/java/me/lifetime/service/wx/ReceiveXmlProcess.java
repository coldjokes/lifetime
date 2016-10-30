package me.lifetime.service.wx;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

import me.lifetime.common.AppConsts;
import me.lifetime.entity.wx.ReceiveXmlEntity;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

/**
 * 解析接收到的微信xml，返回消息对象
 */
@Service
public class ReceiveXmlProcess {

	private static final Logger log = Logger.getLogger(ReceiveXmlProcess.class);

	public ReceiveXmlEntity getMsgEntity(String strXml) {
		if (StringUtils.isEmpty(strXml))
			return null;

		ReceiveXmlEntity msg = null;

		try {
			// 将字符串转化为XML文档对象
			Document document = DocumentHelper.parseText(strXml);
			// 获取文档的根节点
			Element root = document.getRootElement();
			// 遍历根节点下所有的子节点
			Iterator<?> iter = root.elementIterator();

			// 遍历所有节点
			msg = new ReceiveXmlEntity();

			// 利用反射机制，调用set方法
			// 获取该实体的元类型
			Class<?> c = Class
					.forName("me.lifetime.entity.wx.ReceiveXmlEntity");
			// 创建这个实体的对象
			msg = (ReceiveXmlEntity) c.newInstance();

			while (iter.hasNext()) {
				Element ele = (Element) iter.next();

				// 获取set方法中的参数字段（实体类的属性）
				Field field = c.getDeclaredField(ele.getName());
				// 获取set方法，field.getType()获取它的参数数据类型
				Method method = c.getDeclaredMethod("set" + ele.getName(), field.getType());
				// 调用ser方法
				method.invoke(msg, ele.getText());
			}
		} catch (Exception e) {
			log.error(AppConsts.EXP_XML_PARSE + strXml, e);
		}

		return msg;
	}

}
