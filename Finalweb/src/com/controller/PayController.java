package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frame.Service;
import com.vo.CarVO;
import com.vo.PayVO;
import com.vo.payAmountcheck_result_VO;

@Controller
public class PayController {
	@Resource(name="CarService")
	Service<String, CarVO> carService;
	
	@Resource(name="PayService")
	Service<String, PayVO> payService;
	
	@RequestMapping("/pointcharge.mc")
	@ResponseBody
	public int pointcharge(HttpServletRequest request) {
		System.out.println("pointcharge 호출");
		String mem_id = request.getParameter("id");
		System.out.println(mem_id);
		String point1 = payService.pointselect(mem_id);
		String point = request.getParameter("point");
		System.out.println("충전할 포인트:"+point);
		int mem_money = Integer.parseInt(point1) + Integer.parseInt(point);
		System.out.println("충전total:" +mem_money);
		PayVO v = new PayVO(mem_id, mem_money);
		System.out.println("pay객체 생성");
		payService.pointcharge(v);
		System.out.println("충전 완료");
		int result = Integer.parseInt(payService.pointselect(mem_id));
		System.out.println("충전 완료 조회:"+result);
		return result;
	}
	
	@RequestMapping("/seePayment.mc")
	@ResponseBody
	public int payment(String mem_id) {
		System.out.println("받은 mem_id: "+mem_id);
		String data = carService.seePayment("HAN");
		if(data != null) {
			int time = Integer.parseInt(data);
			System.out.println("time: "+time);
			return time;
		}else {
			return 0;
		}
		
	}
	
	@RequestMapping("/pay.mc")
	@ResponseBody
	public void pay(HttpServletRequest request) {
		String id = request.getParameter("id");
		int amount = Integer.parseInt(request.getParameter("amount"));
		PayVO pay = new PayVO(id, amount);
		payService.pay(pay);
		System.out.println("지불 완료!!");
	}
	
//	@RequestMapping(value = "/payAmountbyP_id.mc", method = RequestMethod.GET,
//			produces = "application/json;charset=utf-8")
//	public @ResponseBody ArrayList<CarVO> payAmountcheck(){
//		
//		return null;
//	}
	
	@RequestMapping("/payAmountbyP_id.mc")
	@ResponseBody
	public void payAmountcheck(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String p_id = request.getParameter("p_id"); 
		payAmountcheck_result_VO today_In_list = (payAmountcheck_result_VO)carService.getTodayInfo(p_id);
		System.out.println(today_In_list.getCount());
		JSONObject jo = new JSONObject();
		jo.put("todayCount",today_In_list.getCount());
		jo.put("todayIncome",today_In_list.getTotalIncome());
		
		out.print(jo.toJSONString());
		out.close();
	}
}
