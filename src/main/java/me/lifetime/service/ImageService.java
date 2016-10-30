package me.lifetime.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import me.lifetime.db.mapper.ImageMapper;
import me.lifetime.entity.Image;
import me.lifetime.thread.TokenThread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

	@Autowired
	private ImageMapper imageMapper;
	@Autowired
	private QiniuService qiniuSvc;

	public int insert(int axisId, String fromUserName, String mediaId, String picUrl) {
		Image image = new Image();
		image.setAxisId(axisId);
		image.setFromUserName(fromUserName);
		image.setMediaId(mediaId);
		image.setPathWX(picUrl);
		
		Date current = new Date();

		
		image.setCreateTime(current);

		String name = new SimpleDateFormat("yyyyMMddHHmmss").format(current);
		
		System.out.println("mediaId===" + mediaId);
		System.out.println("mediaId===" + name);

		
		saveFileFromWX(mediaId);
		try {
			saveImageToDisk(mediaId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		String qiniuPath = qiniuSvc.getQiniuPath(mediaId, file, name);
//		image.setPathQiniu(qiniuPath);

		return imageMapper.insert(image);
	}

	public Image getLastImage(String fromUserName) {
		return imageMapper.getLastImage(fromUserName);
	}

	public int updateImageName(String fromUserName, String name) {
		return imageMapper.updateImageName(fromUserName, name);
	}

	public int updateImageDescription(String fromUserName, String description) {
		return imageMapper.updateImageDescription(fromUserName, description);
	}

	public File saveFileFromWX(String mediaId) {

		return new File("");
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
	
	 public void saveImageToDisk(String mediaId) throws Exception {
	       InputStream inputStream = getInputStream(mediaId);
	       byte[] data = new byte[1024];
	       int len = 0;
	       FileOutputStream fileOutputStream = null;
	       try {
	           fileOutputStream = new FileOutputStream("c:\\test1.jpg");
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
}
