package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frame.Service;
import com.vo.CarVO;
import com.vo.ManagerVO;
import com.vo.P_AreaVO;
import com.vo.ParkingVO;

@Controller
public class ParkingController {
	String previous = "A10";
	private Logger parking_log = Logger.getLogger("data");
	
	@Resource(name="ParkingService")
	Service<String, ParkingVO> service;
	
	@Resource(name="P_AreaService")
	Service<String, P_AreaVO> service2;
	
	
	@RequestMapping(value = "/p_areaAjax.mc", method = RequestMethod.GET,
			produces = "application/json;charset=utf-8" )
	public @ResponseBody ArrayList<P_AreaVO> idCheck(String p_id) {
//		System.out.println(p_id);
		ArrayList<P_AreaVO> STATEListByP_id = null;
		try {
			STATEListByP_id = (ArrayList<P_AreaVO>)service2.getstate(p_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println(STATEListByP_id);
	return STATEListByP_id;
	
	}
	
	@RequestMapping(value = "/parkingajax2.mc", method = RequestMethod.GET,
			produces = "application/json;charset=utf-8" )
	public @ResponseBody ArrayList<P_AreaVO> SituationCheck() {
		
		/* ===============vv랜덤수로 테스트 하는 코드vv================*/
		for(char i = 'A'; i<='H'; i++) {
			
			String str_i = String.valueOf(i);
			
			Random random = new Random();
			int state = random.nextInt(2);
			int ran_parea = random.nextInt(2);
			int ran_parea2 = random.nextInt(9)+1;
			
			//char ranalpha = (char) ((Math.random() * 8) + 65);
			//String ranAlpha = String.valueOf(ranalpha);
			
			P_AreaVO randomvalueforP_erea = new P_AreaVO(str_i+ran_parea+""+ran_parea2+"", str_i, state);
			
			try {
				service2.modify(randomvalueforP_erea);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/* ===============^^랜덤수로 테스트 하는 코드^^================*/
		
		
		ArrayList<P_AreaVO> ParkingState = null;
		try {
			ParkingState = (ArrayList<P_AreaVO>)service2.getstateBy_p_id();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(ParkingState+"이거 맞쥬?");
	
	return ParkingState;	
	}
	
	@RequestMapping("/parkingArea.mc")
	@ResponseBody
	public void parkingArea(HttpServletRequest request) throws Exception {
		String data = request.getParameter("parking");
		System.out.println("parking컨트롤러의 data: "+data);
		if(!data.equals(previous)) {
			System.out.println("데이터 변경됨!!");
			String parking_id = data.substring(0,1); // A
			String area_id = data.substring(0,2); // A1
			int state = Integer.parseInt(data.substring(2)); // 0
			P_AreaVO changed = new P_AreaVO(area_id, state);
			service2.modify(changed);
			System.out.println("DB업데이트 완료");
			parking_log.debug(parking_id+","+area_id+","+state);
		}
		
		previous = data;
	}
		
//	@RequestMapping(value = "/parkingajax.mc", method = RequestMethod.GET,
//			produces = "application/json;charset=utf-8" )
//	public @ResponseBody ArrayList<ParkingVO> SituationCheck() {
//		
//		/* ===============vv랜덤수로 테스트 하는 코드vv================*/
//		Random random = new Random();
//		
//		int state = random.nextInt(2);
//		int ran_parea2 = random.nextInt(9)+1;
//		char ranalpha2 = (char) ((Math.random() * 2) + 65);
//		String ranAlpha3 = String.valueOf(ranalpha2);
//		
//		P_AreaVO randomvalueforP_erea = new P_AreaVO(ranAlpha3+"0"+ran_parea2+"", ranAlpha3, state);
//		
//		//System.out.println(ranAlpha3+"0"+ran_parea2+"");
//		//System.out.println(ranAlpha3);
//		//System.out.println(state);
//		
//		
//		int ran_e_num = random.nextInt(46);
//		char ranalpha = (char) ((Math.random() * 8) + 65);
//		String ranAlpha2 = String.valueOf(ranalpha);
//
//		//System.out.println(ran_e_num);
//		//System.out.println(ranAlpha2);
//		
//		ParkingVO randomvalue = new ParkingVO(ranAlpha2,0,ran_e_num,0);
//		/* ===============^^랜덤수로 테스트 하는 코드^^================*/
//		
//		
//		ArrayList<ParkingVO> ParkingState = null;
//		try {
//			
//			/* =======vv랜덤수로 테스트 하는 코드vv=======*/
//			service2.modify(randomvalueforP_erea);
//			service.modify(randomvalue);
//			/* =======^^랜덤수로 테스트 하는 코드^^========*/
//			
//			ParkingState = (ArrayList<ParkingVO>)service.get();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//System.out.println(ParkingState);
//	
//	return ParkingState;
//	
//	}
	
	
}
