package com.parking;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.frame.Dao;
import com.frame.Service;
import com.vo.ParkingVO;
import com.vo.payAmountcheck_result_VO;

@org.springframework.stereotype.Service("ParkingService")
public class ParkingService implements Service<String, ParkingVO>{

	@Resource(name="ParkingDao")
	Dao<String,ParkingVO> dao;

	@Override
	public void register(ParkingVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(ParkingVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public ParkingVO get(String k) throws Exception {
		return dao.select(k);
	}

	
	@Override
	public ArrayList<ParkingVO> get() throws Exception {
		return dao.select();
	}
	
	// 아래거 추가함==============================================
	@Override
	public ArrayList<ParkingVO> getstate(String P_id) throws Exception {
		return null;
	}
	//=======================================================
	
	@Override
	public ParkingVO login(ParkingVO v) {
		return null;
	}

	// 아래거 추가함==============================================
	@Override
	public ArrayList<ParkingVO> getstateBy_p_id() throws Exception {		
		return null;
	}

	@Override
	public ParkingVO idcheck(ParkingVO v) {		
		return null;
	}

	@Override
	public ParkingVO pwdcheck(ParkingVO v) {		
		return null;
	}

	@Override
	public String seePayment(String k) {		
		return null;
	}
	
	@Override
	public void updatePayment(ParkingVO v) {
		
	}

	@Override
	public void pay(ParkingVO v) {		
		
	}

	public void pointcharge(ParkingVO v) {
		
	}

	@Override
	public String pointselect(String k) {		
		return null;
	}

	@Override
	public payAmountcheck_result_VO getTodayInfo(String k) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
