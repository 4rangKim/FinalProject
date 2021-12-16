package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
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
import com.vo.PayVO;

@Controller
public class MainController {
	Mqtt_Pub publish;
	int inCount = 0;
	int outCount = 0;
	
	public MainController() {
		publish = new Mqtt_Pub();
	}
	
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
	
	
	@RequestMapping("/monitor.mc")
	public ModelAndView monitor(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "monitor");
		mv.setViewName("mainpage");
		return mv;
	}
	
	
	@RequestMapping(value = "/pkuser/ajax_list.mc",method = RequestMethod.GET,
			produces =  "application/json;charset=utf-8")
	public @ResponseBody ArrayList<CarVO> categoryList(String category){
		ArrayList<CarVO> carlist = null;
		try {
			if(category.equals("all")) {
				carlist = (ArrayList<CarVO>)carService.get();
			}else {
				carlist = (ArrayList<CarVO>)carService.categorylist(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ajax통신:"+carlist.size());
		return carlist;
	}
	
	@RequestMapping(value = "/pkuser/ajax_date.mc",method = RequestMethod.GET,
			produces =  "application/json;charset=utf-8")
	public @ResponseBody ArrayList<CarVO> dateList(String startdate, String enddate){
		System.out.println("dateAjax호출");
		ArrayList<CarVO> carlist = null;
		String start = startdate;
		String end = enddate;
		System.out.println(start);
		System.out.println(end);
		try {
			carlist = (ArrayList<CarVO>)carService.dateSearch(start, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ajaxDate통신:"+carlist.size());
		return carlist;
	}
	
	@RequestMapping("/appuser.mc")
	public ModelAndView appuserdetail(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		 ArrayList<MemberVO> memberlist = null;
		  	try {
		  		memberlist = memberService.get();
		  		System.out.println(memberlist);
		  	} catch (Exception e) {
		  		e.printStackTrace();
		  	}
		mv.addObject("memberlist", memberlist);
		mv.addObject("center", "appuser");
		mv.setViewName("mainpage");
		return mv;
	}
	
	@RequestMapping("/car.mc")
	@ResponseBody
	public void carin(HttpServletRequest request) throws Exception {
		String data = request.getParameter("car");
		System.out.println("data: "+data);
		String carInImage = "http://192.168.0.16/CarInImage.jpg";
		String carOutImage = "http://192.168.0.16/CarOutImage.jpg";
		String state = data.substring(1);
		System.out.println("state:"+state);
		if(data.substring(1).equals("In")) {			
			GetImageUrl.getImage(carInImage, state, inCount);
			inCount++;
			CarVO car = new CarVO(data.substring(0,1),"01가1234");
			carService.register(car);
			System.out.println("DB입력 완료!!");
			publish.send("final", 1+"");
		}else if(data.substring(1).equals("Out")){
			GetImageUrl.getImage(carOutImage, state, outCount);
			outCount++;
			CarVO car = new CarVO("01가1234");
			carService.modify(car);
			System.out.println("Out_time 업뎃 완료");
			publish.send("final", 0+"");
		}		
	}
	
	
	
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

	@RequestMapping(value = "/CarSearch.mc",method = RequestMethod.GET,
			produces =  "application/json;charset=utf-8")
	public @ResponseBody ArrayList<CarVO> carsearch(String carnum){
		ArrayList<CarVO> carlist = null;
		try {
			carlist = (ArrayList<CarVO>)carService.carnumList(carnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("carnum_ajax통신:"+carlist.size());
		return carlist;
	}
	
	/*
	 * @RequestMapping(value = "/app/CarSearch.mc",method = RequestMethod.GET,
	 * produces = "application/json;charset=utf-8") public @ResponseBody
	 * ArrayList<MemberVO> app_carsearch(String carnum){ ArrayList<MemberVO>
	 * memberlist = null; try { memberlist =
	 * (ArrayList<MemberVO>)memberService.carnumList(carnum); } catch (Exception e)
	 * { e.printStackTrace(); }
	 * System.out.println("app_carnumsearch_ajax통신:"+memberlist.size()); return
	 * memberlist; }
	 */
	
	
	@RequestMapping(value ="/app/search.mc", method = RequestMethod.GET,
			produces =  "application/json;charset=utf-8")
	public @ResponseBody ArrayList<MemberVO> search(String tag,String search) {
		System.out.println("app/search 메소드 호출");
		ArrayList<MemberVO> memberlist=null;
		try {
			memberlist = (ArrayList<MemberVO>)memberService.dateSearch(tag, search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("app/search:"+memberlist.size());
		return memberlist;
	}
}





