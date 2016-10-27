package me.lifetime.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lifetime.thread.TokenThread;

import org.apache.log4j.Logger;

/**
 * 获取access token的servlet
 */
public class AccessTokenServlet extends HttpServlet {

	private static final Logger log = Logger.getLogger(AccessTokenServlet.class);

	private static final long serialVersionUID = 3006987391615338129L;

	public void init() throws ServletException {
		// 获取servlet初始参数appid和appsecret
		TokenThread.appId = getInitParameter("appid");
		TokenThread.appSecret = getInitParameter("appsecret");
		log.debug("appid:" + TokenThread.appId);
		log.debug("appSecret:" + TokenThread.appSecret);

		// 启动token管理进程
		new Thread(new TokenThread()).start();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

}
