package me.lifetime.service;

import java.util.List;

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
	
	public Axis getById(int axisId){
		return axisMapper.getById(axisId);
	}
	public int getLastId(){
		return axisMapper.getLastId();
	}
	public Axis getLastAxis(){
		return axisMapper.getLastAxis();
	}

	public int updateAxis(Axis axis){
		return axisMapper.updateAxis(axis);
	}
	
	public int getLastStatus(){
		return axisMapper.getLastStatus();
	}
	
	public int updateLastStatus(){
		return axisMapper.updateLastStatus();
	}
	
}
