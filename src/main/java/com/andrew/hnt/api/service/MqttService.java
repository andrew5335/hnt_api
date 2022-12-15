package com.andrew.hnt.api.service;

import com.andrew.hnt.api.model.SensorVO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface MqttService {

    public String getData() throws Exception;

}
