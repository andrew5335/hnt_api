package com.andrew.hnt.api.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/chart")
public class ChartController extends DefaultController {

    /**
     * 챠트 메인화면
     * @return
     */
    @RequestMapping(value = "/chart", method = RequestMethod.GET)
    public String chartMain(
            HttpServletRequest req
            , HttpServletResponse res
            , Model model
            ) {
        String result = "";

        HttpSession session = req.getSession();

        if(null != session) {
            if(null != String.valueOf(session.getAttribute("userId")) && !"".equals(String.valueOf(session.getAttribute("userId")))) {
                model.addAttribute("userId", session.getAttribute("userId"));
                model.addAttribute("userNm", session.getAttribute("userNm"));
                model.addAttribute("userGrade", session.getAttribute("userGrade"));

                result = "chart/chart";
            } else {
                result = "redirect:/login/login";
            }
        } else {
            result = "redirect:/login/login";
        }

        return result;
    }
}
