package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frame.Service;
import com.vo.CarVO;
import com.vo.ManagerVO;
import com.vo.ParkingVO;

@Controller
public class ParkingController {
	@Resource(name="ParkingService")
	Service<String, ParkingVO> service;
	
	@RequestMapping("/parkajax.mc")
	@ResponseBody
	public void uu(HttpServletResponse response) throws IOException {
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONArray ja = new JSONArray();
		try {
			List<ParkingVO> parklist = service.get();
			System.out.println(parklist);
			for(int i=0;i<parklist.size();i++) {
				ParkingVO parkname = parklist.get(i);
				
				JSONObject jo = new JSONObject();
				jo.put("parkname"+i, parkname.getP_id());
				jo.put("parkE_num"+i, parkname.getE_num());
				ja.add(jo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(ja.toJSONString());
		out.print(ja.toJSONString());
		out.close();
		
	}
	
}
