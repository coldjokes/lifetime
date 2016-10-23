package me.lifetime.service;

import me.lifetime.db.mapper.LocationMapper;
import me.lifetime.entity.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

	@Autowired
	private LocationMapper locationMapper;
	
	public int insert(Location location){
		
		return locationMapper.insert(location);
	}
	
	
}
