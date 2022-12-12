package com.andrew.hnt.api.mqtt;

import java.util.UUID;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.andrew.hnt.api.mqtt.common.MQTT;

@Component
public class MqttApplicationRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("test ===");
		String MqttServer1 = "tcp://hntnas.diskstation.me:1883";
		String MqttServer2 = "";
		String client_id = "";
		String userName = "hnt1";
		String password = "abcde";
		String topic = "#";
		String msg = "";
		String readMsg = "";
		
		client_id = UUID.randomUUID().toString();
		
		MQTT read = new MQTT(MqttServer1, client_id, userName, password);
		read.init(topic);
		//readMsg = read.getTopic();
		//System.out.println("===== readMsg : " + readMsg);
		sleep(5000);
	}
	
	void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch(InterruptedException ite) {
			ite.printStackTrace();
		}
	}

}