package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Service;
import com.manager.ManagerService;
import com.vo.ManagerVO;

@Controller
public class ManagerController {
	@Resource(name="ManagerService")
	Service<String, ManagerVO> service;

	@RequestMapping(value = "/mainlogin.mc", method = RequestMethod.POST)
	public ModelAndView login(ManagerVO v, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		ManagerVO managerOk = service.login(v);
		System.out.println(managerOk);
		if(managerOk!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("managerOk", managerOk);
			mv.setViewName("mainpage");
		}else {
			mv.setViewName("login");
		}
		return mv;
	}
	
}





