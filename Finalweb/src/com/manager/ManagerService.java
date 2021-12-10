package com.manager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.frame.Dao;
import com.frame.Service;
import com.vo.ManagerVO;
import com.vo.payAmountcheck_result_VO;

@org.springframework.stereotype.Service("ManagerService")
public class ManagerService implements Service<String, ManagerVO>{

	@Resource(name="ManagerDao")
	Dao<String,ManagerVO> dao;

	@Override
	public void register(ManagerVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(ManagerVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public ManagerVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<ManagerVO> get() throws Exception {
		return dao.select();
	}

	@Override
	public ManagerVO login(ManagerVO v) {
		ManagerVO loginOkUser = dao.login(v);
		return loginOkUser;
	}

	@Override
	public ArrayList<ManagerVO> getstate(String P_id) throws Exception {
		return null;
	}

	@Override
	public ArrayList<ManagerVO> getstateBy_p_id() throws Exception {		
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
	public ArrayList<ManagerVO> dateSearch(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
