package com.andrew.hnt.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andrew.hnt.api.model.DataVO;
import com.andrew.hnt.api.model.SensorVO;
import com.andrew.hnt.api.model.UserInfo;
import com.andrew.hnt.api.mqtt.common.MQTT;
import com.andrew.hnt.api.service.LoginService;
import com.andrew.hnt.api.service.MqttService;
import com.andrew.hnt.api.service.impl.MqttServiceImpl;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/main")
public class MainController extends DefaultController {

	@Autowired
	private LoginService loginService;

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
				Map<String, Object> userMap = new HashMap<String, Object>();
				List<UserInfo> userList = new ArrayList<UserInfo>();

				try {
					userMap = loginService.getUserList();

					if(null != userMap && 0 < userMap.size()) {
						userList = (List<UserInfo>) userMap.get("userList");

						if(null != userList && 0 < userList.size()) {
							model.addAttribute("userList", userList);
						}
					}
				} catch(Exception e) {
					logger.error("Error : " + e.toString());
				}

				model.addAttribute("userId", session.getAttribute("userId"));
				model.addAttribute("userNm", session.getAttribute("userNm"));
				model.addAttribute("userGrade", session.getAttribute("userGrade"));
				result = "main/main";
			} else {
				result = "redirect:/login/login";
			}
		} else {
			result = "redirect:/login/login";
		}

		return result;
	}

	@RequestMapping(value = "/getData", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getData(
			HttpServletRequest req
			, HttpServletResponse res
			, @RequestBody DataVO dataVO
	        ) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String sensorValue = "";
		String title = "";
		String sensorId = "";

		HttpSession session = req.getSession();

		if(null != session) {
			if(null != String.valueOf(session.getAttribute("userId")) && !"".equals(String.valueOf(session.getAttribute("userId")))) {
				String userId = dataVO.getUserId();

				try {
					mqttService = new MqttServiceImpl();
					dataMap = mqttService.getData();

					if(null != dataMap && 0 < dataMap.size()) {
						//logger.info("data : " + sensorValue);
						title = String.valueOf(dataMap.get("title"));
						sensorId = String.valueOf(dataMap.get("sensorId"));

						logger.info("sensorId : " + sensorId);

						if(null != sensorId && !"".equals(sensorId)) {
							if("hntTestId".equals(sensorId)) {
								sensorValue = String.valueOf(dataMap.get("data"));
								sensorValue = sensorValue.replace("[", "");
								sensorValue = sensorValue.replace("]", "");
								String[] sensorVal = sensorValue.split(",");
								int sensorValLength = sensorVal.length;
								String sensorData = sensorVal[sensorValLength - 1];
								//logger.info("sensor data : " + sensorData);

								resultMap.put("resultCode", "200");
								resultMap.put("dataVal", sensorData);
								resultMap.put("num", sensorValLength);
								resultMap.put("titleStr", title);
							}
						}
					}
				} catch(Exception e) {
					e.printStackTrace();
					logger.error("Error : " + e.toString());
				}
			}
		}



		return resultMap;
	}
}
