package com.andrew.hnt.api.service;

import java.util.Map;

import com.andrew.hnt.api.model.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
	
	public Map<String, Object> insertUser(UserInfo userInfo) throws Exception;
}
