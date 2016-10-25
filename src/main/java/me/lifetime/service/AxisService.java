package me.lifetime.service;

import java.util.Date;

import me.lifetime.db.mapper.AxisMapper;
import me.lifetime.entity.Axis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AxisService {

	
	@Autowired
	private AxisMapper axisMapper;
	
	public int insertAndGetId(String fromUserName){
		Axis axis = new Axis();
		axis.setTime(new Date());
		axis.setFromUserName(fromUserName);
		axis.setStatus(1);
		axisMapper.insert(axis);
		return axis.getAxisId();
		
	}
	
	public Axis getById(int axisId){
		return axisMapper.getById(axisId);
	}
	public int getLastId(){
		return axisMapper.getLastId();
	}
	public Axis getLastAxis(String fromUserName){
		return axisMapper.getLastAxis(fromUserName);
	}

	public int updateAxis(Axis axis){
		return axisMapper.updateAxis(axis);
	}
	
	public int updateLastStatus(String fromUserName){
		return axisMapper.updateLastStatus(fromUserName);
	}
	
}
