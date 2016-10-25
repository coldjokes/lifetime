package me.lifetime.db.mapper;

import me.lifetime.entity.Axis;

public interface AxisMapper {

    int insert(Axis axis);

    Axis getById(int axisId);
    
    int getLastId();
    
    Axis getLastAxis(String fromUserName);
    
    int updateAxis(Axis axis);
    
    int updateLastStatus(String fromUserName);
}
