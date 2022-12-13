package com.andrew.hnt.api.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.andrew.hnt.api.model.UserInfo;
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

	/**
	 * 회원 가입 처리
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> insertUser(UserInfo userInfo) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		aes256 = new AES256Util();

		if(null != userInfo) {
			String userPass = userInfo.getUserPass();

			// 사용자 비밀번호는 암호화하여 입력
			if(null != userPass && !"".equals(userPass) && 0 < userPass.length()) {
				try {
					userPass = aes256.encrypt(userPass);
				} catch(Exception e) {
					e.printStackTrace();
					logger.error("Error : 암호화 중 에러가 발생했습니다.");
				}

				userInfo.setUserPass(userPass);
			}

			try {
				loginMapper.insertUser(userInfo);
				resultMap.put("result", "success");
				resultMap.put("resultMsg", "회원 가입에 성공하였습니다.");
				resultMap.put("userInfo", userInfo);
			} catch(Exception e) {
				logger.error("Error : 회원 가입 중 오류가 발생되었습니다. - " + e.toString());
				resultMap.put("result", "fail");
				resultMap.put("resultMsg", "회원 가입 중 오류가 발생되었습니다.");
			}
		} else {
			logger.error("Error : 회원 가입에 필요한 정보가 없습니다.");
			resultMap.put("result", "fail");
			resultMap.put("resultMsg", "회원 가입에 필요한 정보가 없습니다.");
		}
		
		return resultMap;
	}
}
