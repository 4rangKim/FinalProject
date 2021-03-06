package com.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.ManagerMapper;
import com.vo.ManagerVO;
import com.vo.payAmountcheck_result_VO;

@Repository("ManagerDao")
public class ManagerDao implements Dao<String, ManagerVO>{
	@Autowired
	ManagerMapper mm;

	@Override
	public void insert(ManagerVO v) throws Exception {
		mm.insert(v);
	}

	@Override
	public void delete(String k) throws Exception {
		mm.delete(k);
	}

	@Override
	public void update(ManagerVO v) throws Exception {
		mm.update(v);
	}

	@Override
	public ManagerVO select(String k) throws Exception {
		return mm.select(k);
	}

	@Override
	public ArrayList<ManagerVO> select() throws Exception {
		return mm.selectall();
	}

	@Override
	public ManagerVO login(ManagerVO v) {
		return mm.login(v);
	}

	@Override
	public ArrayList<ManagerVO> getstate(String k) {
		return null;
	}

	@Override
	public ArrayList<ManagerVO> getstateBy_p_id() {		
		return null;
	}

	@Override
	public ManagerVO idcheck(ManagerVO v) {		
		return null;
	}

	@Override
	public ManagerVO pwdcheck(ManagerVO v) {		
		return null;
	}

	@Override
	public String seePayment(String k) {		
		return null;
	}
	
	@Override
	public void pay(ManagerVO v) {		
		
	}

	public void pointcharge(ManagerVO v) {
		
	}

	@Override
	public String pointselect(String k) {		
		return null;
	}

	@Override
	public void updatePayment(ManagerVO v) {
		
	}
	public payAmountcheck_result_VO getTodayInfo(String k) {
		return null;
	}
	
	@Override
	public List<ManagerVO> selectList(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ManagerVO> categorylist(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ManagerVO> dateSearch(String k1, String k2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ManagerVO> carnumList(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
