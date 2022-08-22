package com.andrew.hnt.api.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrew.hnt.api.mapper.LoginMapper;
import com.andrew.hnt.api.service.LoginService;
import com.andrew.hnt.api.util.AES256Util;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
	
	private AES256Util aes256;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Map<String, Object> insertUser(String userId, String userNm, String userPass, String userEmail, String userTelno, String zipNo, String bscAddr, String dtlAddr) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> insertMap = new HashMap<String, Object>();
		aes256 = new AES256Util();
		
		insertMap.put("userId", userId);
		insertMap.put("userNm", userNm);
		if(null != userPass && !"".equals(userPass) && 0 < userPass.length()) {
		    try {
			    userPass = aes256.encrypt(userPass);
		    } catch(Exception e) {
		    	e.printStackTrace();
		    	logger.error("Error : 암호화 중 에러가 발생했습니다.");
		    }
			insertMap.put("userPass", userPass);
		}
		insertMap.put("userEmail", userEmail);
		insertMap.put("userTelno", userTelno);
		insertMap.put("zipNo", zipNo);
		insertMap.put("bscAddr", bscAddr);
		insertMap.put("dtlAddr", dtlAddr);
		
		try {
			loginMapper.insertUser(insertMap);
			resultMap.put("resultCode", "100");
			resultMap.put("resultMsg", "회원 가입에 성공하였습니다.");
			resultMap.put("userId", userId);
			resultMap.put("userNm", userNm);
			resultMap.put("userPass", userPass);
			resultMap.put("userEmail", userEmail);
			resultMap.put("userTelno", userTelno);
			resultMap.put("zipNo", zipNo);
			resultMap.put("bscAddr", bscAddr);
			resultMap.put("dtlAddr", dtlAddr);
		} catch(Exception e) {
			
		}
		
		return resultMap;
	}
}
