package com.andrew.hnt.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andrew.hnt.api.model.SensorVO;
import com.andrew.hnt.api.mqtt.common.MQTT;
import com.andrew.hnt.api.service.MqttService;
import com.andrew.hnt.api.service.impl.MqttServiceImpl;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/main")
public class MainController extends DefaultController {

	private MqttServiceImpl mqttService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(
			HttpServletRequest req
			, HttpServletResponse res
	        , Model model) {

		String result = "";
		HttpSession session = req.getSession();
		logger.info("session : " + session.getAttribute("userId"));

		if(null != session) {
			if(null != session.getAttribute("userId") && !"".equals(session.getAttribute("userId"))) {
				model.addAttribute("userId", session.getAttribute("userId"));
				model.addAttribute("userNm", session.getAttribute("userNm"));
				result = "main";
			} else {
				result = "redirect:/login/login";
			}
		} else {
			result = "redirect:/login/login";
		}

		return result;
	}

	@RequestMapping(value = "/getData", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getData() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String sensorValue = "";

		try {
			mqttService = new MqttServiceImpl();
			sensorValue = mqttService.getData();

			if(null != sensorValue && !"".equals(sensorValue) && 0 < sensorValue.length()) {
				logger.info("data : " + sensorValue);
			}
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("Error : " + e.toString());
		}

		return resultMap;
	}
}
