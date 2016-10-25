package me.lifetime.db.mapper;

import me.lifetime.entity.Image;

public interface ImageMapper {

    int insert(Image image);

	Image getLastImage(String fromUserName);
	
	int updateImageName(String fromUserName,String name);

	int updateImageDescription(String fromUserName, String description);
}
