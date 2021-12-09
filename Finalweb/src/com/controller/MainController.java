package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Service;
import com.vo.CarVO;
import com.vo.ManagerVO;
import com.vo.MemberVO;
import com.vo.P_AreaVO;
import com.vo.PayVO;

@Controller
public class MainController {
//	Mqtt_Pub publish;
//	public MainController() {
//		publish = new Mqtt_Pub();
//	}
	
	@Resource(name="PayService")
	Service<String, PayVO> payService;
	
	@Resource(name="ManagerService")
	Service<String, ManagerVO> service;
	
	@Resource(name="CarService")
	Service<String, CarVO> carService;
	
	@Resource(name="MemberService")
	Service<String, MemberVO> memberService;
	
	@RequestMapping("/login.mc")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping("/logout.mc")
	public ModelAndView loggout(HttpSession ses) throws Exception {
		ModelAndView mv = new ModelAndView();
		if(ses!=null) {
			//세션객체가 있으면 세션객체를 없애기
			ses.invalidate();
		}
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping("/main.mc")
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mainpage");
		return mv;
	}
	
	@RequestMapping("/pkuser.mc")
	public ModelAndView pkuserdetail(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
	    ArrayList<CarVO> pkuserList = null;
	  	try {
	  		pkuserList = carService.get();
	  		System.out.println(pkuserList);
	  	} catch (Exception e) {
	  		e.printStackTrace();
	  	}
	    mv.addObject("pkuserList", pkuserList);
		mv.addObject("center", "pkuser");
		mv.setViewName("mainpage");
		return mv;
	}
	
	@RequestMapping(value = "/pkuser/ajax_list.mc",method = RequestMethod.GET,
			produces =  "application/json;charset=utf-8")
	public @ResponseBody ArrayList<CarVO> categoryList(String category){
		ArrayList<CarVO> carlist = null;
		try {
			carlist = (ArrayList<CarVO>)carService.categorylist(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ajax통신:"+carlist.size());
		return carlist;
	}
	
	
	
	@RequestMapping("/appuser.mc")
	public ModelAndView appuserdetail(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		 ArrayList<MemberVO> appuserList = null;
		  	try {
		  		appuserList = memberService.get();
		  		System.out.println(appuserList);
		  	} catch (Exception e) {
		  		e.printStackTrace();
		  	}
		mv.addObject("appuserList", appuserList);
		mv.addObject("center", "appuser");
		mv.setViewName("mainpage");
		return mv;
	}
	
//	@RequestMapping("/car.mc")
//	@ResponseBody
//	public void carin(HttpServletRequest request) throws Exception {
//		String data = request.getParameter("car");
//		System.out.println("data: "+data);
//		if(data.substring(1).equals("In")) {
//			CarVO car = new CarVO(data.substring(0,1),"01가1234");
//			carService.register(car);
//			System.out.println("DB입력 완료!!");
//			publish.send("final", 1+"");
//		}else if(data.equals("AOut")){
//			CarVO car = new CarVO("01가1234");
//			carService.modify(car);
//			System.out.println("Out_time 업뎃 완료");
//			publish.send("final", 0+"");
//		}		
//	}
	
	@RequestMapping("/CarInImg.mc")
	public ModelAndView carInImg(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String inImg = request.getParameter("inImg");
		System.out.println(inImg);
		mv.addObject("Img", inImg);
		mv.setViewName("ImgPopup");
		return mv;
	}
	
	@RequestMapping("/CarOutImg.mc")
	public ModelAndView carOutImg(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String outImg = request.getParameter("outImg");
		System.out.println(outImg);
		mv.addObject("Img", outImg);
		mv.setViewName("ImgPopup");
		return mv;
	}
}





