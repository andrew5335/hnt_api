package com.andrew.hnt.api.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.andrew.hnt.api.model.LoginVO;
import com.andrew.hnt.api.model.UserInfo;
import org.apache.catalina.User;
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
	public Map<String, Object> getUserList() throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		List<UserInfo> userList = new ArrayList<UserInfo>();

		try {
			userList = loginMapper.getUserList();;

			if(null != userList && 0 < userList.size()) {
				resultMap.put("result", "success");
				resultMap.put("resultMessage", "사용자 목록 조회 성공했습니다.");
				resultMap.put("userList", userList);
			} else {
				resultMap.put("result", "fail");
				resultMap.put("resultMessage", "사용자 목록 조회 실패했습니다.");
			}
		} catch(Exception e) {
			logger.error("Error : " + e.toString());
			resultMap.put("result", "fail");
			resultMap.put("resultMessage", "사용자 목록 조회 과정에서 오류가 발생되었습니다. - " + e.toString());
		}

		return resultMap;
	}

	@Override
	public Map<String, Object> getUserInfo(LoginVO loginVO) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		if(null != loginVO) {
			UserInfo userInfo = new UserInfo();
			String userPass = "";
			userPass = loginVO.getUserPass();

			if(null != userPass && !"".equals(userPass) && 0 < userPass.length()) {
				try {
					aes256 = new AES256Util();
					userPass = aes256.encrypt(userPass);
				} catch(Exception e) {
					e.printStackTrace();
					logger.error("Error : 암호화 중 에러가 발생되었습니다. - " + e.toString());
					resultMap.put("result", "fail");
					resultMap.put("resultMsg", "암호화 중 에러가 발생되었습니다.");
				}

				loginVO.setUserPass(userPass);
				logger.info("userpass : " + loginVO.getUserPass());
				logger.info("userid : " + loginVO.getUserId());

			}

			try {
				userInfo = loginMapper.getUserInfo(loginVO);

				if(null != userInfo) {
					resultMap.put("result", "success");
					resultMap.put("resultMsg", "회원 로그인에 성공하였습니다.");
					resultMap.put("userInfo", userInfo);
					logger.info("userid : " + userInfo.getUserId());
				} else {
					resultMap.put("result", "fail");
					resultMap.put("resultMsg", "회원 정보가 없습니다.");
				}
			} catch(Exception e) {
				e.printStackTrace();
				logger.error("Error : 로그인 과정에서 에러가 발생되었습니다. - " + e.toString());
			}
		} else {

		}

		return resultMap;
	}

	/**
	 * 회원 가입 처리
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> insertUser(UserInfo userInfo) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		if(null != userInfo) {
			userInfo.setDelYn("N");
			userInfo.setUseYn("Y");
			userInfo.setUserGrade("U");
			userInfo.setInstId("hnt");
			userInfo.setMdfId("hnt");

			String userPass = userInfo.getUserPass();

			// 사용자 비밀번호는 암호화하여 입력
			if(null != userPass && !"".equals(userPass) && 0 < userPass.length()) {
				try {
					aes256 = new AES256Util();
					userPass = aes256.encrypt(userPass);
				} catch(Exception e) {
					e.printStackTrace();
					logger.error("Error : 암호화 중 에러가 발생되었습니다. - " + e.toString());
					resultMap.put("result", "fail");
					resultMap.put("resultMsg", "암호화 중 에러가 발생되었습니다.");
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
