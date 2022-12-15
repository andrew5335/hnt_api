package com.andrew.hnt.api.service.impl;

import com.andrew.hnt.api.service.MqttService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MqttServiceImpl implements MqttService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void receiveData(String str) {

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
                        } else {
                            logger.info("value : " + strArr[1]);
                        }

                        if(null != topicArr && 0 < topicArr.length) {
                            logger.info("topic : " + topicArr[1]);
                            logger.info("topic : " + topicArr[3]);
                        }

                        if(null != valueMap && 0 < valueMap.size()) {
                            logger.info("value : " + String.valueOf(valueMap.get("value")));
                        }
                    } catch(Exception e) {
                        logger.error("Error : " + e.toString());
                    }
                }
            }
        }
    }

    public boolean isValidJson(String str) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readTree(str);
        } catch(Exception e) {
            return false;
        }
        return true;
    }
}
