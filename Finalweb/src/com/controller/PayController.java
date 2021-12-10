package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		String data = carService.seePayment("aaa");
		if(data != null) {
			int time = Integer.parseInt(data);
			System.out.println("time: "+time);
			int hour = time/60;
			int minute = time - hour*60;
			int amount = 3000;
			if(hour >=1 || minute > 30){
				amount += Math.ceil((float)(((hour*60)+(minute-30))/5))*500;
			}
			CarVO fee = new CarVO("HAN", amount);
			carService.updatePayment(fee);
			return time;
		}else {
			return 0;
		}
		
	}
	
	@RequestMapping(value = "/nowPayment.mc", produces = "application/json; charset=utf8")
	@ResponseBody
	public String nowpayment(HttpServletRequest request) {
		String mem_id = request.getParameter("id");
		String data = carService.seePayment(mem_id);
		if(data != null) {
			int time = Integer.parseInt(data);
			System.out.println("time: "+time);
			int hour = time/60;
			int minute = time - hour*60;
			int amount = 3000;
			if(hour >=1 || minute > 30){
				amount += Math.ceil((float)(((hour*60)+(minute-30))/5))*500;
			}
			CarVO fee = new CarVO(mem_id, amount);
			carService.updatePayment(fee);
		}
		JSONArray ja = new JSONArray();
		List<CarVO> carList = null;
		try {
			carList = carService.getstate(mem_id);
			System.out.println(carList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject jo = new JSONObject();
		CarVO mycar = carList.get(0);
		Date in_time = mycar.getIn_time();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jo.put("carNum", mycar.getCar_num());
		jo.put("mem_id", mycar.getMem_id());
		jo.put("in_time",format.format(in_time));
		jo.put("out_time", mycar.getOut_time());
		jo.put("payment", mycar.getPayment());
		ja.add(jo);
		String result = ja.toJSONString();
		System.out.println(ja.toJSONString());
		return result;
	}
	
	
	@RequestMapping("/pay.mc")
	@ResponseBody
	public void pay(HttpServletRequest request) {
		System.out.println("pay메소드 호출");
		String id = request.getParameter("id");
		int amount = Integer.parseInt(request.getParameter("amount"));
		PayVO pay = new PayVO(id, amount);
		payService.pay(pay);
		System.out.println("지불 완료!!");
		String msg = amount+"원이 결제되었습니다.";
		try {
			FcmUtil.sendServer(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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

	
	
	@RequestMapping(value="/paylist.mc",produces = "application/json; charset=utf8")
	@ResponseBody
	public String paylist(HttpServletRequest request) {
		System.out.println("pay메소드 호출");
		String mem_id = request.getParameter("id");
		JSONArray ja = new JSONArray();
		List<CarVO> carList = null;
		try {
			carList = carService.selectList(mem_id);
			System.out.println(carList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i=0;i<carList.size();i++) {
			JSONObject jo = new JSONObject();
			CarVO mycar = carList.get(i);
			Date in_time = mycar.getIn_time();
			Date out_time = mycar.getOut_time();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String outResult ="";
			jo.put("carNum", mycar.getCar_num());
			jo.put("mem_id", mycar.getMem_id());
			jo.put("in_time", format.format(in_time));
			jo.put("out_time", format.format(out_time));
			jo.put("payment", mycar.getPayment());
			ja.add(jo);
		}
		String result = ja.toJSONString();
		System.out.println(ja.toJSONString());
		return result;
		
	}
}
