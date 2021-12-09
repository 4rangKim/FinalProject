package com.car;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.frame.Dao;
import com.frame.Service;
import com.vo.CarVO;
import com.vo.payAmountcheck_result_VO;

@org.springframework.stereotype.Service("CarService")
public class CarService implements Service<String, CarVO>{

	@Resource(name="CarDao")
	Dao<String,CarVO> dao;

	@Override
	public void register(CarVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(CarVO v) throws Exception {
		dao.update(v);
	}
	
	@Override
	public List<CarVO> selectList(String k) throws Exception {
		return dao.selectList(k);
	}


	@Override
	public CarVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<CarVO> get() throws Exception {
		return dao.select();
	}

	@Override
	public CarVO login(CarVO v) {
		return null;
	}

	@Override
	public ArrayList<CarVO> getstate(String k) throws Exception {
		return dao.getstate(k);
	}

	@Override
	public ArrayList<CarVO> getstateBy_p_id() throws Exception {		
		return null;
	}

	@Override
	public CarVO idcheck(CarVO v) {		
		return null;
	}

	@Override
	public CarVO pwdcheck(CarVO v) {		
		return null;
	}

	@Override
	public String seePayment(String k) {
		return dao.seePayment(k);
	}
	
	@Override
	public void updatePayment(CarVO v) {
		dao.updatePayment(v);
	}

	@Override
	public void pay(CarVO v) {
		
	}

	public void pointcharge(CarVO v) {
		
	}

	@Override
	public String pointselect(String k) {		
		return null;
	}

	@Override
	public payAmountcheck_result_VO getTodayInfo(String p_id) {
		return dao.getTodayInfo(p_id);
	}

	@Override
	public ArrayList<CarVO> categorylist(String k) throws Exception {
		return dao.categorylist(k);
	}
	
}
