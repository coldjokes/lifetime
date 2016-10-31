package me.lifetime.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import me.lifetime.common.AppConsts;
import me.lifetime.service.wx.ConnectToken;
import me.lifetime.service.wx.ReceiveXmlProcess;
import me.lifetime.service.wx.WXMessageService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WXController {
	
	private static final Logger log = Logger.getLogger(WXController.class);
	
	@Autowired
	private ConnectToken connectToken;
	@Autowired
	private ReceiveXmlProcess receiveXmlProcess;
	@Autowired
	private WXMessageService wxMsgSvc;
	
	/**
	 * 验证access token
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/wx",method = {RequestMethod.GET})
	@ResponseBody
	public String accessToken(HttpServletRequest req){
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		if (connectToken.checkToken(signature, timestamp, nonce)) {
			return echostr;
		}else{
			log.error("Access token validate failure!");
		}
		return "";
	}
	
	/**
	 * 处理微信消息
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/wx",method = {RequestMethod.POST})
	@ResponseBody
	public String clientMsg(HttpServletRequest req){
        StringBuffer sb = new StringBuffer();  
		try {
			InputStream is = req.getInputStream();
	        InputStreamReader isr = new InputStreamReader(is, "UTF-8");  
	        BufferedReader br = new BufferedReader(isr);  
	        String s = "";  
	        while ((s = br.readLine()) != null) {  
	            sb.append(s);  
	        }  
		} catch (IOException e) {
			log.error(AppConsts.EXP_XML_DATA, e);
		}  
		//微信端发来的信息
        String xml = sb.toString();  
		
		return wxMsgSvc.handleMsg(receiveXmlProcess.getMsgEntity(xml));
	}

}
