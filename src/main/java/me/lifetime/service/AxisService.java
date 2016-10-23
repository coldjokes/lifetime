package me.lifetime.service;

import me.lifetime.db.mapper.AxisMapper;
import me.lifetime.entity.Axis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AxisService {

	
	@Autowired
	private AxisMapper axisMapper;
	
	public int insertAndGetId(){
		Axis axis = new Axis();
		axisMapper.insert(axis);
		return axis.getAxisId();
		
	}
	
	public int getLastId(){
		return axisMapper.getLastId();
	}
	
	public int getLastStatus(){
		return axisMapper.getLastStatus();
	}
	
	public int updateLastStatus(){
		return axisMapper.updateLastStatus();
	}
	
}
