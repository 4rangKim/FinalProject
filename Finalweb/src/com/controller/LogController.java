package com.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Service;

@Controller
public class LogController {

	
	private Logger work_log = 
			Logger.getLogger("work"); 
	private Logger user_log = 
			Logger.getLogger("user"); 
	private Logger data_log = 
			Logger.getLogger("data"); 
	private Logger ran_traffic_log = 
			Logger.getLogger("ran_traffic");
	
	
	
	@RequestMapping("/trafficTest.mc")
	@ResponseBody
	public void iotdata(HttpServletRequest request) throws IOException {
		String Atraffic_num = request.getParameter("Atraffic_num");
		String Btraffic_num = request.getParameter("Btraffic_num");
		int f_Atraffic_num = Integer.parseInt(Atraffic_num);
		int f_Btraffic_num = Integer.parseInt(Btraffic_num);
		System.out.println("traffic:"+f_Atraffic_num+" : "+f_Btraffic_num);
		
		data_log.debug(f_Atraffic_num+","+f_Btraffic_num);
		
	}

}