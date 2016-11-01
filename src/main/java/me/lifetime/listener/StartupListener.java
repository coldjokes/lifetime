package me.lifetime.listener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import me.lifetime.common.AppConsts;
import me.lifetime.thread.TokenThread;

import org.apache.log4j.Logger;

public class StartupListener implements ServletContextListener {
	
	private static final Logger log = Logger.getLogger(StartupListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		// 启动token管理进程
		TokenThread.appId = AppConsts.PROP_WX_APP_ID;
		TokenThread.appSecret = AppConsts.PROP_WX_SECRET_ID;
		new Thread(new TokenThread()).start();
		
		//生成照片磁盘存放路径
		String pathDisk = AppConsts.IMAGE_SAVE_PATH;
		File file = new File(pathDisk);
		if(!file.exists()){
			file.mkdirs();
			log.info("照片路径生成成功：" + pathDisk);
		}
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {}

}
