package com.andrew.hnt.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		logger.info("test");
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
	public String joinProcess(
			HttpServletRequest req
			, HttpServletResponse res
			, @RequestParam(name = "userId", required = true) String userId
			, @RequestParam(name = "userNm", required = true) String userNm
			, @RequestParam(name = "userPass", required = true) String userPass
			, @RequestParam(name = "userEmail", required = true) String userEmail
			, @RequestParam(name = "userTelno", required = true) String userTelno
			, @RequestParam(name = "zipNo", required = false) String zipNo
			, @RequestParam(name = "bscAddr", required = false) String bscAddr
			, @RequestParam(name = "dtlAddr", required = false) String dtlAddr
			, Model model
			) {
		String result = ""; 
		
		// 필수 입력값 검증 이후 모든 필수값이 있을 경우 가입 처리 2022-08-17 by Andrew Kim
		if(StringUtil.isEmpty(userId)) {
			model.addAttribute("resultCode", "999");
			model.addAttribute("resultMsg", "사용자 아이디가 없습니다.");
			result = "joinFail";
		} else if(StringUtil.isEmpty(userNm)) {
			model.addAttribute("resultCode", "999");
			model.addAttribute("resultMsg", "사용자 이름이 없습니다.");
			result = "joinFail";
		} else if(StringUtil.isEmpty(userPass)) {
			model.addAttribute("resultCode", "999");
			model.addAttribute("resultMsg", "사용자 비밀번호가 없습니다.");
			result = "joinFail";
		} else if(StringUtil.isEmpty(userEmail)) {
			model.addAttribute("resultCode", "999");
			model.addAttribute("resultMsg", "사용자 메일주소가 없습니다.");
			result = "joinFail";
		} else if(StringUtil.isEmpty(userTelno)) {
			model.addAttribute("resultCode", "999");
			model.addAttribute("resultMsg", "사용자 전화번호가 없습니다.");
			result = "joinFail";
		} else {
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap = loginService.insertUser(userId, userNm, userPass, userEmail, userTelno, zipNo, bscAddr, dtlAddr);
			
			if(null != resultMap && 0 < resultMap.size()) {
				model.addAttribute("resultCode", String.valueOf(resultMap.get("resultCode")));
				model.addAttribute("resultMsg", String.valueOf(resultMap.get("resultMsg")));
				
				if(String.valueOf(resultMap.get("resultCode")).equals("100")) {
					result = "joinSuccess";
				} else {
					result = "joinFail";
				}
			}
		}
		
		return result;
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
