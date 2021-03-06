package com.car;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.CarMapper;
import com.vo.CarVO;
import com.vo.payAmountcheck_result_VO;

@Repository("CarDao")
public class CarDao implements Dao<String, CarVO>{
	@Autowired
	CarMapper cm;

	@Override
	public void insert(CarVO v) throws Exception {
		cm.insert(v);
	}

	@Override
	public void delete(String k) throws Exception {
		cm.delete(k);
	}

	@Override
	public void update(CarVO v) throws Exception {
		cm.update(v);
	}

	@Override
	public CarVO select(String k) throws Exception {
		return cm.select(k);
	}

	@Override
	public ArrayList<CarVO> select() throws Exception {
		return cm.selectall();
	}

	@Override
	public CarVO login(CarVO v) {
		return null;
	}

	@Override
	public List<CarVO> selectList(String k) throws Exception {
		return cm.selectList(k);
	}
	
	@Override
	public ArrayList<CarVO> getstate(String k) {
		return cm.nowPayment(k);
	}

	@Override
	public ArrayList<CarVO> getstateBy_p_id() {		
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
	public String seePayment(String car_num) {
		return cm.seePayment(car_num);
	}
	
	@Override
	public void updatePayment(CarVO v) {
		cm.updatePayment(v);
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
		return cm.getTodayInfo(p_id);
	}

	@Override
	public ArrayList<CarVO> categorylist(String k) throws Exception {
		return cm.categorylist(k);
	}

	@Override
	public ArrayList<CarVO> dateSearch(String k1, String k2) throws Exception {
		return cm.dateSearch(k1, k2);
	}
	@Override
	public ArrayList<CarVO> carnumList(String k) throws Exception {
		return cm.carnumList(k);
	}
	
}
