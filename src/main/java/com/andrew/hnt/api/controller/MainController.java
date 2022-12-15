package com.andrew.hnt.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class MainController extends DefaultController {

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
				model.addAttribute("userId", session.getAttribute("userId"));
				model.addAttribute("userNm", session.getAttribute("userNm"));
				result = "main";
			} else {
				result = "redirect:/login/login";
			}
		} else {
			result = "redirect:/login/login";
		}

		return result;
	}
}
