package com.andrew.hnt.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController extends DefaultController {

	/**
	 * 로그인 페이지 호출
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest req, HttpServletResponse res) {
		return "login";
	}
	
	/**
	 * 로그인 처리 요청
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(HttpServletRequest req, HttpServletResponse res) {
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
			, @RequestParam(value = "userId", required = true) String userId
			, @RequestParam(value = "userNm", required = true) String userNm
			, @RequestParam(value = "userPass", required = true) String userPass
			, @RequestParam(value = "userEmail", required = true) String userEmail
			, Model model
			) {
		String result = ""; 
		
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
