package com.andrew.hnt.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value = "/home")
	public String main(HttpServletRequest req, HttpServletResponse res) {
		return "home";
	}
}
