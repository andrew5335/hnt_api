package com.andrew.hnt.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andrew.hnt.api.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.andrew.hnt.api.service.impl.LoginServiceImpl;
import com.andrew.hnt.api.util.StringUtil;

@Controller
@RequestMapping("/login")
public class LoginController extends DefaultController {
	
	@Autowired
	private LoginServiceImpl loginService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 로그인 페이지 호출
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest req, HttpServletResponse res) {
		logger.info("login");
		return "login";
	}
	
	/**
	 * 로그인 처리 요청
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(
			HttpServletRequest req
			, HttpServletResponse res
			, @RequestParam(name = "userId", required = true) String userId
			, @RequestParam(name = "userPass", required = true) String userPass
			, Model model
			) {
		String result = "";
		
		return result;
	}
	
	/**
	 * 회원 가입 페이지 호출
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(HttpServletRequest req, HttpServletResponse res) {

		return "join";
	}
	
	/**
	 * 회원 가입 처리 요청
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/joinProcess", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> joinProcess(
			HttpServletRequest req
			, HttpServletResponse res
			, @RequestBody UserInfo userInfo
			) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> joinMap = new HashMap<String, Object>();
		
		// 필수 입력값 검증 이후 모든 필수값이 있을 경우 가입 처리 2022-08-17 by Andrew Kim
		if(StringUtil.isEmpty(userInfo.getUserId())) {
			resultMap.put("resultCode", "999");
			resultMap.put("resultMessage", "회원 가입 실패 - 사용자 아이디 없음");
		} else if(StringUtil.isEmpty(userInfo.getUserNm())) {
			resultMap.put("resultCode", "999");
			resultMap.put("resultMessage", "회원 가입 실패 - 사용자 이름 없음");
		} else if(StringUtil.isEmpty(userInfo.getUserPass())) {
			resultMap.put("resultCode", "999");
			resultMap.put("resultMessage", "회원 가입 실패 - 사용자 비밀번호 없음");
		} else {

			try {
				joinMap = loginService.insertUser(userInfo);
			} catch(Exception e) {
				logger.error("Error : " + e.toString());
				resultMap.put("resultCode", "998");
				resultMap.put("resultMessage", "회원 가입 실패");
			}
			
			if(null != joinMap && 0 < joinMap.size()) {
				
				if(String.valueOf(joinMap.get("result")).equals("success")) {
					resultMap.put("resultCode", "200");
					resultMap.put("resultMessage", "회원 가입 성공");
					resultMap.put("userInfo", (UserInfo) joinMap.get("userInfo"));
				} else {
					resultMap.put("resultCode", "999");
					resultMap.put("resultMessage", "회원 가입 실패");
				}
			}
		}
		
		return resultMap;
	}
	
	/**
	 * 회원 아이디 찾기 페이지 호출
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/findUserId", method = RequestMethod.GET)
	public String findUserId(HttpServletRequest req, HttpServletResponse res) {
		return "findUserId";
	}
	
	/**
	 * 회원 아이디 찾기 처리
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/findUserIdProcess", method = RequestMethod.POST)
	public String findUserIdProcess(HttpServletRequest req, HttpServletResponse res) {
		String result = "";
		
		return result;
	}
}
