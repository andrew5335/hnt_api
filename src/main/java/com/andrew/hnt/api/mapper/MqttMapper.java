package com.andrew.hnt.api.mapper;

import com.andrew.hnt.api.model.SensorVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface MqttMapper {

    public void insertSensorData(SensorVO sensorVO);

    public Map<String, Object> getSensorValue(String userId);
}
