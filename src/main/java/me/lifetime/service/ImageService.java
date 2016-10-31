package me.lifetime.service;

import java.util.Date;

import me.lifetime.common.AppConsts;
import me.lifetime.db.mapper.ImageMapper;
import me.lifetime.entity.Image;
import me.lifetime.service.wx.WXApiService;
import me.lifetime.util.DateTimeUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

	@Autowired
	private ImageMapper imageMapper;
	@Autowired
	private QiniuService qiniuSvc;
	@Autowired
	private WXApiService wxApiSvc;
	
	public int insert(int axisId, String fromUserName, String mediaId, String picUrl) {
		Image image = new Image();
		image.setAxisId(axisId);
		image.setFromUserName(fromUserName);
		image.setMediaId(mediaId);
		image.setPathWX(picUrl);
		image.setCreateTime(new Date());

		String fullName = DateTimeUtil.getCurrent() + ".jpg";
		
		String pathDisk = AppConsts.IMAGE_SAVE_PATH + fullName;
		String pathQiniu = AppConsts.QINIU_URL + fullName;
		
		try {
			wxApiSvc.saveImageToDisk(mediaId, pathDisk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		qiniuSvc.upload(pathDisk);

		image.setPathQiniu(pathQiniu);
		image.setPathDisk(pathDisk);
		
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
