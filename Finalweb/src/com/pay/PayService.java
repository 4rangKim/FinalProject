package com.pay;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.frame.Dao;
import com.frame.Service;
import com.vo.PayVO;
import com.vo.payAmountcheck_result_VO;

@org.springframework.stereotype.Service("PayService")
public class PayService implements Service<String, PayVO>{

	@Resource(name="PayDao")
	Dao<String,PayVO> dao;

	@Override
	public void register(PayVO v) throws Exception {
		
	}

	@Override
	public void remove(String k) throws Exception {
		
	}

	@Override
	public void modify(PayVO v) throws Exception {
		
	}

	@Override
	public PayVO get(String k) throws Exception {
		return null;
	}

	@Override
	public ArrayList<PayVO> get() throws Exception {
		return null;
	}

	@Override
	public PayVO login(PayVO v) {
		return null;
	}

	@Override
	public ArrayList<PayVO> getstate(String P_id) throws Exception {
		return null;
	}

	@Override
	public ArrayList<PayVO> getstateBy_p_id() throws Exception {
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
		dao.pointcharge(v);
	}

	@Override
	public String pointselect(String k) {
		return dao.pointselect(k);
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
		dao.pay(v);		
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
