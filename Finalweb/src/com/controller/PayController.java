package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frame.Service;
import com.vo.CarVO;
import com.vo.PayVO;

@Controller
public class PayController {
	@Resource(name="CarService")
	Service<String, CarVO> carService;
	
	@Resource(name="PayService")
	Service<String, PayVO> payService;
	
	@RequestMapping("/pointcharge.mc")
	@ResponseBody
	public int pointcharge(HttpServletRequest request) {
		System.out.println("pointcharge ȣ��");
		String mem_id = request.getParameter("id");
		System.out.println(mem_id);
		String point1 = payService.pointselect(mem_id);
		String point = request.getParameter("point");
		System.out.println("������ ����Ʈ:"+point);
		int mem_money = Integer.parseInt(point1) + Integer.parseInt(point);
		System.out.println("����total:" +mem_money);
		PayVO v = new PayVO(mem_id, mem_money);
		System.out.println("pay��ü ����");
		payService.pointcharge(v);
		System.out.println("���� �Ϸ�");
		int result = Integer.parseInt(payService.pointselect(mem_id));
		System.out.println("���� �Ϸ� ��ȸ:"+result);
		return result;
	}
	
	@RequestMapping("/seePayment.mc")
	@ResponseBody
	public int payment(String mem_id) {
		System.out.println("���� mem_id: "+mem_id);
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
		System.out.println("���� �Ϸ�!!");
	}
}