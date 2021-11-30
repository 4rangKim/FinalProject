package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frame.Service;
import com.vo.ManagerVO;
import com.vo.P_AreaVO;
import com.vo.ParkingVO;

@Controller
public class ParkingController {
	@Resource(name="ParkingService")
	Service<String, ParkingVO> service;
	
	@Resource(name="P_AreaService")
	Service<String, P_AreaVO> service2;
	
	
	@RequestMapping(value = "/p_areaAjax.mc", method = RequestMethod.GET,
			produces = "application/json;charset=utf-8" )
	public @ResponseBody ArrayList<P_AreaVO> idCheck(String p_id) {
		//System.out.println(p_id+"뷰에서 받아온값");
		ArrayList<P_AreaVO> STATEListByP_id = null;
		try {
			STATEListByP_id = (ArrayList<P_AreaVO>)service2.getstate(p_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(STATEListByP_id);
	
	return STATEListByP_id;
	
	}
	
	@RequestMapping(value = "/parkingajax.mc", method = RequestMethod.GET,
			produces = "application/json;charset=utf-8" )
	public @ResponseBody ArrayList<ParkingVO> SituationCheck() {
		ArrayList<ParkingVO> ParkingState = null;
		try {
			ParkingState = (ArrayList<ParkingVO>)service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ParkingState);
	
	return ParkingState;
	
	}
	
}
