package me.lifetime.thread;

import me.lifetime.common.AppConsts;
import me.lifetime.entity.wx.AccessToken;
import me.lifetime.util.NetWorkHelper;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * token管理线程
 * 
 * 这个进程中定义一个无限循环的方法，用来获取access_token
 * 当获取成功后，此进程休眠7000秒，否则休眠3秒钟继续获取
 */
public class TokenThread implements Runnable {
	
	private static final Logger log = Logger.getLogger(TokenThread.class);
	
	public static String appId = "";
	public static String appSecret = "";

	// 注意是静态的
	public static AccessToken accessToken = null;

	public void run() {
		while (true) {
			try {
				accessToken = this.getAccessToken();
				if (null != accessToken) {
					log.debug("accessToken:" + accessToken.getAccessToken());
					// 获取到access_token 休眠7000秒
					Thread.sleep(7000 * 1000); 
				} else {
					// 获取的access_token为空 休眠3秒
					Thread.sleep(1000 * 3); 
				}
			} catch (Exception e) {
				log.error(AppConsts.EXP_ACCESS_TOEKN_GET, e);
				try {
					// 发生异常休眠1秒
					Thread.sleep(1000 * 10); 
				} catch (Exception e1) {
					log.error(AppConsts.EXP_SYSTEM, e1);
				}
			}
		}
	}

	/**
	 * 获取access_token
	 */
	private AccessToken getAccessToken() {
		NetWorkHelper netHelper = new NetWorkHelper();
		String Url = String
				.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s",
						TokenThread.appId, TokenThread.appSecret);
		String result = netHelper.getHttpsResponse(Url, "");
		log.debug("Resut of getting access token is :" + result);
		// response.getWriter().println(result);
		JSONObject json = JSON.parseObject(result);
		AccessToken token = new AccessToken();
		token.setAccessToken(json.getString("access_token"));
		token.setExpiresin(json.getInteger("expires_in"));
		return token;
	}
}
