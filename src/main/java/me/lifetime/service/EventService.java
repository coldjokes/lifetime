package me.lifetime.service;

import java.util.Date;

import me.lifetime.db.mapper.EventMapper;
import me.lifetime.entity.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
	@Autowired
	private EventMapper eventMapper;
	
	public int insert(int axisId, String fromUserName, String text){
		
		Event event = new Event();
		event.setAxisId(axisId);
		event.setFromUserName(fromUserName);
		event.setText(text);
		event.setCreateTime(new Date());
		
		return eventMapper.insert(event);
		
	}

}
