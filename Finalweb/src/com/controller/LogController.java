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
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Service;

@Controller
public class LogController {

	
//	private Logger work_log = 
//			Logger.getLogger("work"); 
//	private Logger user_log = 
//			Logger.getLogger("user"); 
//	private Logger data_log = 
//			Logger.getLogger("data"); 
	
	private Logger ran_traffic_log = 
			Logger.getLogger("ran_traffic");
	
	
	//================VV ���� �α׸� ����� ��Ʈ�ѷ� �ڵ�========================================================================
	@RequestMapping("/trafficTest.mc")
	@ResponseBody
	public void iotdata(HttpServletRequest request) throws IOException {
		String Atraffic_num = request.getParameter("Atraffic_num");
		String Btraffic_num = request.getParameter("Btraffic_num");
		int f_Atraffic_num = Integer.parseInt(Atraffic_num);
		int f_Btraffic_num = Integer.parseInt(Btraffic_num);
		System.out.println("traffic:"+f_Atraffic_num+" : "+f_Btraffic_num);
		
		ran_traffic_log.debug(f_Atraffic_num+","+f_Btraffic_num);
		
	}
	//================^^ ���� �α׸� ����� ��Ʈ�ѷ� �ڵ�========================================================================
	
	
	//=================VV boot_main���� AJAX��û�� �ް� �α� �����͸� json ���·� ��ȯ�ϴ� �ڵ�==========================================
	@RequestMapping("/trafficChart.mc")
	@ResponseBody
	public void ruu(HttpServletResponse response) throws IOException, RserveException, REXPMismatchException {
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		RConnection rconn = new RConnection("192.168.0.143");
		rconn.setStringEncoding("utf8");

		rconn.eval("source('C:/logs/test1.R',encoding='UTF-8')");
		// R�� ��� ����� ����Ʈ�� ���� ����
		RList list = rconn.eval("a3()").asList();

		// ����Ʈ�� ù ��° ���(�÷�) �ι�° ���(�÷�), ����° ���(�÷�) �� double �迭�� ����
		double[] n1 = list.at(0).asDoubles();
		double[] n2 = list.at(1).asDoubles();
		double[] n3 = list.at(2).asDoubles();
		
		
//		{
//			"time":[8,9,10,11],
//			"data":[
//			        {"name":"temp","data":[9,20,10,11,22]},
//			        {"name":"humi","data":[9,20,10,11,22]}
//			        ]
//		}
		
//		^�̷� ������
		
		JSONObject jo = new JSONObject();
		JSONArray tdata = new JSONArray();
		for(double num:n1) {
			tdata.add(num);
		}
		jo.put("time",tdata);
		
		
		JSONObject jo2 = new JSONObject();
		
		JSONArray ja2 = new JSONArray();
		JSONObject jj = new JSONObject();
		jj.put("name", "temp");
		JSONArray tdata2 = new JSONArray();
		for(double num:n2) {
			tdata2.add(num);
		}
		jj.put("data", tdata2);
		ja2.add(jj);
		JSONObject jj2 = new JSONObject();
		jj2.put("name", "humi");
		JSONArray tdata3 = new JSONArray();
		for(double num:n3) {
			tdata3.add(num);
		}
		jj2.put("data", tdata3);
		ja2.add(jj2);
		
		jo.put("data", ja2);
		
		
		out.print(jo.toJSONString());
		out.close();
		rconn.close();
	}
	
	
	
	

}