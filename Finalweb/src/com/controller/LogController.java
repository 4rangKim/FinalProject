package com.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

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
	
	private Logger ran_traffic_test_log = 
			Logger.getLogger("ran_traffic_test");
	
	private Logger ran_test_log = Logger.getLogger("data");
	
	
	//================VV 랜덤 로그를 만드는 컨트롤러 코드========================================================================
	
	
	
	@RequestMapping("/randomLogTest1.mc")
	@ResponseBody
	public void MakingRandomLog1(HttpServletResponse response)throws IOException{
		response.setContentType("application/text;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		for(char j='A'; j<='H';j++) {
			ran_test_log.debug(j+","+1);
		}
		
		out.print("랜덤로그생성테스트1완료");
		out.close();
	}
	
	
	@RequestMapping("/randomLogTest2.mc")
	@ResponseBody
	public void MakingRandomLog2(HttpServletResponse response)throws IOException{
		response.setContentType("application/text;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		char ranAlpha = (char) ((Math.random()*8)+65);
		//Random r = new Random();
		//int r_state = r.nextInt(2);
		ran_test_log.debug(ranAlpha+","+1);
		
		out.print("랜덤로그생성테스트2완료");
		out.close();
	}
	
	
	
	//**********V 랜덤 로그를 만드는 컨트롤러 (안쓰지만 혹시 모르니 보관)*************
	@RequestMapping("/trafficTest.mc")
	@ResponseBody
	public void iotdata(HttpServletRequest request) throws IOException {
		//String random_state = request.getParameter("state");
		//int f_random_state = Integer.parseInt(random_state);
		
		for(char j='A'; j<='H';j++) {
			ran_test_log.debug(j+","+1);
		}
		
		while(true) {
			Thread t1 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					char ranAlpha = (char) ((Math.random()*8)+65);
					//Random r = new Random();
					//int r_state = r.nextInt(2);
					ran_test_log.debug(ranAlpha+","+1);
					
				}
			});
			t1.start();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	//================^^ 랜덤 로그를 만드는 컨트롤러 코드========================================================================
	
	
	
	
	
	//=================VV maincontent에서 AJAX요청을 받고 로그 데이터를 json 형태로 변환하는 코드==========================================
	@RequestMapping("/parkingChart.mc")
	@ResponseBody
	public void ruu(HttpServletResponse response, HttpServletRequest request) throws IOException, RserveException, REXPMismatchException {
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		RList list = null;
		String xAxis = "";
		String title ="주차장별 이용 차량수 / ";
		
		
		String date = request.getParameter("date");
		
		RConnection rconn = new RConnection("192.168.0.143");
		rconn.setStringEncoding("utf8");

		rconn.eval("source('C:/logs/parking_test.R',encoding='UTF-8')");
		// R의 계산 결과를 리스트로 리턴 받음
		if(date.equals("month")) {
			list = rconn.eval("bymonth()").asList();
			xAxis = "월(month)";
		}else if(date.equals("year")) {
			list = rconn.eval("byyear()").asList();
			xAxis = "년(year)";
		}else if(date.equals("day")) {
			xAxis = "일(day)";
			list = rconn.eval("byday()").asList();
		}else if(date.equals("hour")) {
			xAxis = "시(hour) -어제 날짜 기준";
			list = rconn.eval("byhour()").asList();
		}else if(date.equals("avgC")) {
			xAxis = "시간대(hour)";
			title = "시간대별 평균 주차수 / ";
			list = rconn.eval("AVGbyhour()").asList();
		}
		

		int[] n1 = list.at(0).asIntegers(); //년,월,일,시
		int[] n2 = list.at(1).asIntegers(); //A주차장
		int[] n3 = list.at(2).asIntegers(); //B주차장
		int[] n4 = list.at(3).asIntegers(); //C주차장
		int[] n5 = list.at(4).asIntegers(); //D주차장
		int[] n6 = list.at(5).asIntegers(); //E주차장
		int[] n7 = list.at(6).asIntegers(); //F주차장
		int[] n8 = list.at(7).asIntegers(); //G주차장
		int[] n9 = list.at(8).asIntegers(); //H주차장
		
		
		JSONObject jo = new JSONObject();
		JSONArray Mdata = new JSONArray();
		for(int num:n1) {
			Mdata.add(num);
		}
		jo.put("month",Mdata);
		
		System.out.println(Mdata);
		
		JSONArray Apdata= new JSONArray();
		
		for(int num:n2) {
			Apdata.add(num);
		}
		jo.put("Ap",Apdata);
		
		JSONArray Bpdata= new JSONArray();
		
		for(int num:n3) {
			Bpdata.add(num);
		}
		jo.put("Bp",Bpdata);
		
		JSONArray Cpdata= new JSONArray();
		
		for(int num:n4) {
			Cpdata.add(num);
		}
		jo.put("Cp",Cpdata);
		
		JSONArray Dpdata= new JSONArray();
		
		for(int num:n5) {
			Dpdata.add(num);
		}
		jo.put("Dp",Dpdata);
		
		JSONArray Epdata= new JSONArray();
		
		for(int num:n6) {
			Epdata.add(num);
		}
		jo.put("Ep",Epdata);
		
		JSONArray Fpdata= new JSONArray();
		
		for(int num:n7) {
			Fpdata.add(num);
		}
		jo.put("Fp",Fpdata);
		
		JSONArray Gpdata= new JSONArray();
		
		for(int num:n8) {
			Gpdata.add(num);
		}
		jo.put("Gp",Gpdata);
		
		JSONArray Hpdata= new JSONArray();
		
		for(int num:n9) {
			Hpdata.add(num);
		}
		jo.put("Hp",Hpdata);
		
		jo.put("Xdate", xAxis);
		
		jo.put("Title", title);
		
		out.print(jo.toJSONString());
		out.close();
		rconn.close();
	}
	
	

}