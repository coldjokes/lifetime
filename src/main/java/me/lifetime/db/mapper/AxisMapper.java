package me.lifetime.db.mapper;

import me.lifetime.entity.Axis;

public interface AxisMapper {

    int insert(Axis axis);

    Axis getById(int axisId);
}
