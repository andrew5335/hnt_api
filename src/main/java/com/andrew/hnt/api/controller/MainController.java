package com.andrew.hnt.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController extends DefaultController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String main(HttpServletRequest req, HttpServletResponse res) {
		return "home";
	}
}
