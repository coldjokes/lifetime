package me.lifetime.service;

import java.util.Date;

import me.lifetime.db.mapper.ImageMapper;
import me.lifetime.entity.Image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

	@Autowired
	private ImageMapper imageMapper;
	@Autowired
	private QiniuService qiniuSvc;
	
	
	public int insert(int axisId,String fromUserName, String mediaId){
		Image image = new Image();
		image.setFromUserName(fromUserName);
		image.setCreateTime(new Date());
		image.setAxisId(axisId);
		
		System.out.println(mediaId);
		String qiniuPath = qiniuSvc.getQiniuPath(mediaId);
		
		image.setPathQiniu(qiniuPath);
		
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

}
