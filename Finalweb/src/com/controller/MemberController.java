package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Service;
import com.vo.ManagerVO;
import com.vo.MemberVO;

@Controller
public class MemberController {
	@Resource(name="MemberService")
	Service<String, MemberVO> service;
	
	@RequestMapping("/register.mc")
	@ResponseBody
	public void register(HttpServletRequest request) {
		System.out.println("register 호출");
		System.out.println(request.toString());
		
		String mem_id = request.getParameter("id"); 
		String mem_pwd = request.getParameter("pwd"); 
		String mem_name = request.getParameter("name");
		int mem_tel = Integer.parseInt(request.getParameter("tel")); 
		int mem_money=0;
		String mem_car = request.getParameter("carNum");
		String mem_car2 = "";
		MemberVO v = new MemberVO(mem_id, mem_pwd, mem_name, mem_tel, mem_money, mem_car, mem_car2);
		System.out.println(v);
		try {
			service.register(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/userlogin.mc" ,produces = "application/json; charset=utf8")
	@ResponseBody
	public String login(HttpServletRequest request) {
		String mem_id = request.getParameter("id"); 
		String mem_pwd = request.getParameter("pwd");
		MemberVO v = new MemberVO(mem_id, mem_pwd);
		System.out.println(v);
		MemberVO userOk = service.login(v);
		System.out.println(userOk);
		MemberVO user = null;
		String result ="";
		if(userOk!=null) {
			try {
				user = service.get(mem_id);
				result = "[{'mem_id':'"+user.getMem_id()+"','mem_pwd':'"+user.getMem_pwd()+"','mem_name':'"+user.getMem_name()+"','mem_tel':'"+user.getMem_tel()+"','mem_money':'"+user.getMem_money()+"','mem_car1':'"+user.getMem_car1()+"','mem_car2':'"+user.getMem_car2()+"'}]";
				System.out.println(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			result = null;
		}
		return result;
	}
	
	@RequestMapping("/idcheck.mc")
	@ResponseBody
	public String idcheck(HttpServletRequest request) {
		System.out.println("id찾기 호출");
		String mem_name = request.getParameter("name"); 
		int mem_tel = Integer.parseInt(request.getParameter("tel")); 
		System.out.println(mem_name);
		System.out.println(mem_tel);
		MemberVO v = new MemberVO(mem_name, mem_tel);
		System.out.println(v);
		MemberVO idOk = service.idcheck(v);
		String result;
		if(idOk!=null) {
			result = idOk.getMem_id();
		}else {
			result = "fail";
		}
		return result;
	}
	
	@RequestMapping("/doublecheck.mc")
	@ResponseBody
	public int doublecheck(HttpServletRequest request) {
		System.out.println("doublecheck 호출");
		String mem_id = request.getParameter("id"); 
		System.out.println(mem_id);
		MemberVO doubleid = null;
		try {
			doubleid = service.get(mem_id);
			System.out.println(doubleid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int result;
		if(doubleid!=null) {
			result = 0;
		}else {
			result = 1;
		}
		return result;
	}
	
	
	@RequestMapping("/pwdcheck.mc")
	@ResponseBody
	public String pwdcheck(HttpServletRequest request) {
		String mem_id = request.getParameter("id"); 
		String mem_name = request.getParameter("name");
		int mem_tel = Integer.parseInt(request.getParameter("tel")); 
		MemberVO v = new MemberVO(mem_id, mem_name,mem_tel);
		MemberVO pwdOk = service.pwdcheck(v);
		System.out.println(pwdOk);
		String result;
		if(pwdOk!=null) {
			result = pwdOk.getMem_pwd();
		}else {
			result = "fail";
		}
		return result;
	}
	
	@RequestMapping("/carinsert.mc")
	@ResponseBody
	public MemberVO carinsert(HttpServletRequest request) {
		System.out.println("carinsert호출");
		String mem_id = request.getParameter("id"); 
		String mem_pwd = request.getParameter("pwd");
		String mem_car2 = request.getParameter("carNum");
		MemberVO v = new MemberVO(mem_id, mem_pwd , mem_car2);
		System.out.println(v);
		MemberVO result = null;
		try {
			service.modify(v);
			result = service.get(mem_id);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return result;
	}
}
