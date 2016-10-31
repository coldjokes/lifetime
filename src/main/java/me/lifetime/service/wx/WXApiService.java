package me.lifetime.service.wx;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import me.lifetime.thread.TokenThread;

import org.springframework.stereotype.Service;

@Service
public class WXApiService {
	
	 public void saveImageToDisk(String mediaId, String pathDisk) throws Exception {
	       InputStream inputStream = getInputStream(mediaId);
	       byte[] data = new byte[1024];
	       int len = 0;
	       FileOutputStream fileOutputStream = null;
	       try {
	           fileOutputStream = new FileOutputStream(pathDisk);
	           while ((len = inputStream.read(data)) != -1) {
	               fileOutputStream.write(data, 0, len);
	           }
	       } catch (IOException e) {
	           e.printStackTrace();
	       } finally {
	           if (inputStream != null) {
	               try {
	                   inputStream.close();
	               } catch (IOException e) {
	                   e.printStackTrace();
	               }
	           }
	           if (fileOutputStream != null) {
	               try {
	                   fileOutputStream.close();
	               } catch (IOException e) {
	                   e.printStackTrace();
	               }
	           }
	       }
	   }
	
	public InputStream getInputStream(String mediaId) {
		String accessToken = TokenThread.accessToken.getAccessToken();
		InputStream is = null;
		String url = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token="
				+ accessToken + "&media_id=" + mediaId;
		try {
			URL urlGet = new URL(url);
			HttpURLConnection http = (HttpURLConnection) urlGet .openConnection();
			http.setRequestMethod("GET"); // 必须是get方式请求
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒

			http.connect();

			// 获取文件转化为byte流

			is = http.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}

}
