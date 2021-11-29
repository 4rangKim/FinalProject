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
public class MainController {
	@Resource(name="ManagerService")
	Service<String, ManagerVO> service;
//	MyMqtt_Pub_client client;
//	private Logger data_log = 
//			Logger.getLogger("data");
//	
//	public MainController() {
//		client = new MyMqtt_Pub_client();
//		
//	}
	
	@RequestMapping("/login.mc")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	
	@RequestMapping("/main.mc")
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "center");
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/user.mc")
	public ModelAndView userdetail(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "Appmanage");
		mv.setViewName("main");
		return mv;
	}
}





