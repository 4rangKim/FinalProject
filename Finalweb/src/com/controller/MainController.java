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
import com.vo.PayVO;

@Controller
public class MainController {
	Mqtt_Pub publish;
	
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
	
	@RequestMapping("/carIn.mc")
	@ResponseBody
	public void carIn(HttpServletRequest request) throws Exception {
		String data = request.getParameter("parkingLot");
		System.out.println("data: "+data);
		String carInImage = "http://192.168.0.16/CarInImage.jpg";
		String in_photo = GetImageUrl.getImage(carInImage, data, "In");
		System.out.println("in_photo:"+in_photo);
		CarVO car = new CarVO(data.substring(0,1),"01가1234", in_photo);
		carService.register(car);
		System.out.println("DB입력 완료!!");
		publish.send("gate", 1+"");
	}
	
	@RequestMapping("/carOut.mc")
	@ResponseBody
	public int carOut(HttpServletRequest request) throws Exception {
		String data = request.getParameter("parkingLot");
		System.out.println("data: "+data);
		String carOutImage = "http://192.168.0.19/CarOutImage.jpg";		
		String out_photo = GetImageUrl.getImage(carOutImage, data, "Out");
		//저장된 사진 분석해서 차량 번호  얻기
		String car_num = "01가1234";
		//차량 번호로 회원 아이디 찾아서 시간 조회 (서브 쿼리)
		String result = carService.seePayment(car_num);
		System.out.println("result: "+result);
		int time = Integer.parseInt(result);
		System.out.println("time: "+time);
		//요금 계산 해서 DB업데이트
		int hour = time/60;
		int minute = time - hour*60;
		int amount = 3000;
		if(hour >=1 || minute > 30){
			amount += Math.ceil((float)(((hour*60)+(minute-30))/5))*500;
		}
		//요금 업데이트
		CarVO fee = new CarVO("01가1234", amount);
		carService.updatePayment(fee);
		//요금 결제
		PayVO pay = new PayVO("01가1234", amount);
		payService.pay(pay);
		System.out.println("지불 완료!!");
		//DB에 나간 시간 업데이트
		CarVO car = new CarVO(car_num, out_photo);
		carService.modify(car);
		System.out.println("Out_time 업뎃 완료");
		publish.send("gate", 0+"");	
		return amount;
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
}





