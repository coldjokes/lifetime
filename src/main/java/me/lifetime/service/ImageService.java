package me.lifetime.service;

import me.lifetime.db.mapper.ImageMapper;
import me.lifetime.entity.Image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

	@Autowired
	private ImageMapper imageMapper;
	
	public int insert(int axisId, String mediaId){
		Image image = new Image();
		image.setAxisId(axisId);
		
		
		return imageMapper.insert(image);
		
		
	}
	
	
}
