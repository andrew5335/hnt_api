package com.andrew.hnt.api.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {
	
	public Map<String, Object> insertUser(String userId, String userNm, String userPass, String userEmail, String userTelno, String zipNo, String bscAddr, String dtlAddr);
}
