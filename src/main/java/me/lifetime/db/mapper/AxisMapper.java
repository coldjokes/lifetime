package me.lifetime.db.mapper;

import me.lifetime.entity.Axis;

public interface AxisMapper {

    int insert(Axis axis);

    Axis getById(int axisId);
    
    int getLastId();
    
    Axis getLastAxis();
    
    int updateAxis(Axis axis);
    
    int getLastStatus();
    
    int updateLastStatus();
}
