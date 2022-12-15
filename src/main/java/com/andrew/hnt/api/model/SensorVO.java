package com.andrew.hnt.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorVO {

    public String userId;
    public String sensorId;
    public String uuid;
    public String sensorType;
    public String sensorValue;
    public String instId;
    public String mdfId;
    public String instDtm;
}
