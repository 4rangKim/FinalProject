package com.p_area;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.P_AreaMapper;
import com.vo.P_AreaVO;
import com.vo.payAmountcheck_result_VO;

@Repository("P_AreaDao")
public class P_AreaDao implements Dao<String, P_AreaVO>{
	@Autowired
	P_AreaMapper pam;

	@Override
	public void insert(P_AreaVO v) throws Exception {
		pam.insert(v);
	}

	@Override
	public void delete(String k) throws Exception {
		pam.delete(k);
	}

	@Override
	public void update(P_AreaVO v) throws Exception {
		pam.update(v);
	}

	@Override
	public P_AreaVO select(String k) throws Exception {
		return pam.select(k);
	}

	@Override
	public ArrayList<P_AreaVO> select() throws Exception {
		return pam.selectall();
	}

	@Override
	public P_AreaVO login(P_AreaVO v) {
		return null;
	}

	@Override
	public ArrayList<P_AreaVO> getstate(String p_id) {
		return pam.selectByP_id(p_id);
	}

	// 아래거 추가함==============================================
	@Override
	public ArrayList<P_AreaVO> getstateBy_p_id() {		
		return pam.getstateBy_p_id();
	}

	@Override
	public P_AreaVO idcheck(P_AreaVO v) {		
		return null;
	}

	@Override
	public P_AreaVO pwdcheck(P_AreaVO v) {		
		return null;
	}

	@Override
	public String seePayment(String k) {		
		return null;
	}
	
	@Override
	public void updatePayment(P_AreaVO v) {
		
	}

	@Override
	public void pay(P_AreaVO v) {		
		
	}

	public void pointcharge(P_AreaVO v) {
		
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
	public List<P_AreaVO> selectList(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<P_AreaVO> categorylist(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<P_AreaVO> dateSearch(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
