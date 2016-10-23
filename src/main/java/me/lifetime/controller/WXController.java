package me.lifetime.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import me.lifetime.service.WXService;
import me.lifetime.util.MessageUtil;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WXController {

	
	private static final Logger log = Logger.getLogger(WXController.class);
	
	@Autowired
	private WXService wxSvc;

	
	@RequestMapping(value="/wx",method = {RequestMethod.POST})
	@ResponseBody
	public String clientMsg(HttpServletRequest req){
		Map<String, String> map = null;
		try {
			map = MessageUtil.xmlToMap(req);
		} catch (IOException | DocumentException e) {
			log.error("Failed to get client message", e);
		}
		
		return wxSvc.handleMsg(map);
	}
	
	@RequestMapping(value="/wx",method = {RequestMethod.GET})
	@ResponseBody
	public String accessToken(HttpServletRequest req){
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		if (wxSvc.checkToken(signature, timestamp, nonce)) {
			return echostr;
		}else{
			log.error("Access token validate failure!");
		}
		return "";
	}

	
	@RequestMapping(value="/end",method = {RequestMethod.GET})
	public void end(HttpServletRequest req){
		System.out.println(11111);
	}
}
