package me.lifetime.service;

import me.lifetime.db.mapper.EventMapper;
import me.lifetime.entity.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
	@Autowired
	private EventMapper eventMapper;
	
	public int insert(int axisId, String text){
		Event event = new Event(axisId, text);
		return eventMapper.insert(event);
		
	}

}
