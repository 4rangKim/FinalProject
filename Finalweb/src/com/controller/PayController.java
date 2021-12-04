package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frame.Service;
import com.vo.MemberVO;
import com.vo.PayVO;

@Controller
public class PayController {
	@Resource(name="PayService")
	Service<String, PayVO> service;
	
	@RequestMapping("/pointcharge.mc")
	@ResponseBody
	public int pointcharge(HttpServletRequest request) {
		System.out.println("pointcharge 호출");
		String mem_id = request.getParameter("id");
		System.out.println(mem_id);
		String point1 = service.pointselect(mem_id);
		String point = request.getParameter("point");
		System.out.println("충전할 포인트:"+point);
		int mem_money = Integer.parseInt(point1) + Integer.parseInt(point);
		System.out.println("충전total:" +mem_money);
		PayVO v = new PayVO(mem_id, mem_money);
		System.out.println("pay객체 생성");
		service.pointcharge(v);
		System.out.println("충전 완료");
		int result = Integer.parseInt(service.pointselect(mem_id));
		System.out.println("충전 완료 조회:"+result);
		return result;
	}
}
