package com.pay;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.MemberMapper;
import com.mapper.PayMapper;
import com.vo.MemberVO;
import com.vo.PayVO;

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
	public void pay(PayVO v) {
		pm.pay(v);
	}
	

	
}
