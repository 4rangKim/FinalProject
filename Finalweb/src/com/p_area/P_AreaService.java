package com.p_area;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.frame.Dao;
import com.frame.Service;
import com.vo.P_AreaVO;
import com.vo.payAmountcheck_result_VO;

@org.springframework.stereotype.Service("P_AreaService")
public class P_AreaService implements Service<String, P_AreaVO>{

	@Resource(name="P_AreaDao")
	Dao<String,P_AreaVO> dao;

	@Override
	public void register(P_AreaVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(P_AreaVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public P_AreaVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<P_AreaVO> get() throws Exception {
		return dao.select();
	}

	@Override
	public P_AreaVO login(P_AreaVO v) {
		return null;
	}

	// 아래거 추가함==============================================
	@Override
	public ArrayList<P_AreaVO> getstate(String p_id) throws Exception {
		return dao.getstate(p_id);
	}

	@Override
	public ArrayList<P_AreaVO> getstateBy_p_id() throws Exception {		
		return dao.getstateBy_p_id();
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
		return null;
	}

	@Override
	public ArrayList<P_AreaVO> categorylist(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<P_AreaVO> dateSearch(String k1, String k2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<P_AreaVO> carnumList(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
}
