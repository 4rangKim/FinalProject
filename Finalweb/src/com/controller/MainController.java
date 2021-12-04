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
import com.vo.CarVO;
import com.vo.ManagerVO;

@Controller
public class MainController {
	Mqtt_Pub publish;
	public MainController() {
		publish = new Mqtt_Pub();
	}
	
	@Resource(name="ManagerService")
	Service<String, ManagerVO> service;
	
	@Resource(name="CarService")
	Service<String, CarVO> carservice;
	
	@RequestMapping("/login.mc")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	
	@RequestMapping("/main.mc")
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("boot_main");
		return mv;
	}
	
	@RequestMapping("/user.mc")
	public ModelAndView userdetail(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "Appmanage");
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/car.mc")
	@ResponseBody
	public void carin(HttpServletRequest request) throws Exception {
		String data = request.getParameter("car");
		System.out.println("data: "+data);
		if(data.substring(1).equals("In")) {
			CarVO car = new CarVO(data.substring(0,1),"01가1234");
			carservice.register(car);
			System.out.println("DB입력 완료!!");
			publish.send("final", 1+"");
		}else if(data.equals("AOut")){
			CarVO car = new CarVO("01가1234");
			carservice.modify(car);
			System.out.println("Out_time 업뎃 완료");
			publish.send("final", 0+"");
		}
		
	}
}





