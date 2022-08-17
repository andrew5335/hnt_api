package com.andrew.hnt.api.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrew.hnt.api.mapper.LoginMapper;
import com.andrew.hnt.api.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper;

	@Override
	public Map<String, Object> insertUser(String userId, String userNm, String userPass, String userEmail, String userTelno, String zipNo, String bscAddr, String dtlAddr) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> insertMap = new HashMap<String, Object>();
		
		insertMap.put("userId", userId);
		insertMap.put("userNm", userNm);
		insertMap.put("userPass", userPass);
		insertMap.put("userEmail", userEmail);
		insertMap.put("userTelno", userTelno);
		insertMap.put("zipNo", zipNo);
		insertMap.put("bscAddr", bscAddr);
		insertMap.put("dtlAddr", dtlAddr);
		
		try {
			loginMapper.insertUser(insertMap);
			resultMap.put("resultCode", "100");
			resultMap.put("resultMsg", "회원 가입에 성공하였습니다.");
		} catch(Exception e) {
			
		}
		
		return resultMap;
	}
}
