package com.pay;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.PayMapper;
import com.vo.PayVO;
import com.vo.payAmountcheck_result_VO;

@Repository("PayDao")
public class PayDao implements Dao<String, PayVO>{
	@Autowired
	PayMapper pm;

	@Override
	public void insert(PayVO v) throws Exception {
		
	}

	@Override
	public void delete(String k) throws Exception {
		
	}

	@Override
	public void update(PayVO v) throws Exception {
		
	}

	@Override
	public PayVO select(String k) throws Exception {
		return null;
	}

	@Override
	public ArrayList<PayVO> select() throws Exception {
		return null;
	}

	@Override
	public PayVO login(PayVO v) {
		return null;
	}

	@Override
	public ArrayList<PayVO> getstate(String k) {
		return null;
	}

	@Override
	public ArrayList<PayVO> getstateBy_p_id() {		
		return null;
	}

	@Override
	public PayVO idcheck(PayVO v) {
		return null;
	}

	@Override
	public PayVO pwdcheck(PayVO v) {
		return null;
	}

	@Override
	public void pointcharge(PayVO v) {
		pm.pointcharge(v);
	}

	@Override
	public String pointselect(String k) {
		return pm.pointselect(k);
	}

	@Override
	public String seePayment(String k) {		
		return null;
	}
	
	@Override
	public void updatePayment(PayVO v) {
		
	}

	@Override
	public void pay(PayVO v) {
		pm.pay(v);
	}

	@Override
	public payAmountcheck_result_VO getTodayInfo(String k) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<PayVO> selectList(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PayVO> categorylist(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PayVO> dateSearch(String k1, String k2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PayVO> carnumList(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
