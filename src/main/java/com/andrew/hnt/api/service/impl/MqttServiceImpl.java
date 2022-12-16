package com.andrew.hnt.api.service.impl;

import com.andrew.hnt.api.mapper.MqttMapper;
import com.andrew.hnt.api.model.SensorVO;
import com.andrew.hnt.api.service.MqttService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class MqttServiceImpl implements MqttService {

    @Autowired
    private MqttMapper mqttMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public SensorVO sensorVO1 = new SensorVO();
    public static ArrayList<String> data = new ArrayList<String>();
    public static String title = "";

    public String setSensorValue(ArrayList<String> data, SensorVO sensorVO) throws Exception {
        this.data = data;
        this.title = sensorVO.getUserId();
        //logger.info("sensor data : " + data.toString());
        //logger.info("userId : " + sensorVO.getUserId());
        //logger.info("sensorId : " + sensorVO.getSensorId());

        return data.toString();
    }

    @Override
    public Map<String, Object> getData() throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        //logger.info("getData : " + data.toString());
        resultMap.put("data", data.toString());
        resultMap.put("title", title);

        return resultMap;
    }

    public void receiveData(String str) {
        SensorVO sensorVO = new SensorVO();
        sensorVO.setInstId("hnt");
        sensorVO.setMdfId("hmt");

        if(null != str && !"".equals(str) && 0 < str.length()) {
            if(str.contains("@")) {
                ObjectMapper mapper = new ObjectMapper();

                String[] strArr = str.split("@");

                if(null != strArr && 0 < strArr.length) {

                    try {
                        String[] topicArr = strArr[0].split("/");
                        Map<String, Object> valueMap = new HashMap<String, Object>();

                        if(!str.contains("temperature")) {
                            valueMap = mapper.readValue(strArr[1], Map.class);
                            sensorVO.setSensorType(topicArr[4]);
                        } else {
                            logger.info("value : " + strArr[1]);
                            String[] tempArr = strArr[0].split("/");
                            sensorVO.setSensorValue(strArr[1]);    // 온도인 경우 온도 센서 측정값
                            if(null != tempArr) {
                                sensorVO.setSensorType(tempArr[3]);
                            }
                        }

                        if(null != topicArr && 0 < topicArr.length) {
                            logger.info("topic : " + topicArr[1]);
                            logger.info("topic : " + topicArr[3]);
                            sensorVO.setUserId(topicArr[1]);    // 인입된 값에 들어가 있는 사용자 아이디
                            sensorVO.setSensorId(topicArr[1]);    // 인입된 값에 들어가 있는 사용자 아이디
                            sensorVO.setUuid(topicArr[3]);    // 인입된 값에 들어가 있는 센서 고유 아이디
                        }

                        if(null != valueMap && 0 < valueMap.size()) {
                            logger.info("value : " + String.valueOf(valueMap.get("value")));
                            sensorVO.setSensorValue(String.valueOf(valueMap.get("value")));    // 인입된 값에 들어가 있는 센서 측정값
                        }

                        //this.setSensorValue(sensorVO);
                        data.add(sensorVO.getSensorValue());
                        this.setSensorValue(data, sensorVO);

                    } catch(Exception e) {
                        e.printStackTrace();
                        logger.error("Error : " + e.toString());
                    }
                }
            }
        }
    }

}
