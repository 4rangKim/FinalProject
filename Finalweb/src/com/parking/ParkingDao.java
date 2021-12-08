package com.parking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.ParkingMapper;
import com.vo.ParkingVO;
import com.vo.payAmountcheck_result_VO;

@Repository("ParkingDao")
public class ParkingDao implements Dao<String, ParkingVO>{
	@Autowired
	ParkingMapper pm;

	@Override
	public void insert(ParkingVO v) throws Exception {
		pm.insert(v);
	}

	@Override
	public void delete(String k) throws Exception {
		pm.delete(k);
	}

	@Override
	public void update(ParkingVO v) throws Exception {
		pm.update(v);
	}

	@Override
	public ParkingVO select(String k) throws Exception {
		return pm.select(k);
	}

	@Override
	public ArrayList<ParkingVO> select() throws Exception {
		return pm.selectall();
	}

	@Override
	public ParkingVO login(ParkingVO v) {
		return null;
	}

	@Override
	public ArrayList<ParkingVO> getstate(String k) {
		return null;
	}

	@Override
	public ArrayList<ParkingVO> getstateBy_p_id() {		
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
	
	@Override
	public List<ParkingVO> selectList(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
