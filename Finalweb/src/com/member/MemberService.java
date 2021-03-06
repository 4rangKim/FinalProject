package com.member;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.frame.Dao;
import com.frame.Service;
import com.vo.MemberVO;
import com.vo.payAmountcheck_result_VO;

@org.springframework.stereotype.Service("MemberService")
public class MemberService implements Service<String, MemberVO>{

	@Resource(name="MemberDao")
	Dao<String,MemberVO> dao;

	@Override
	public void register(MemberVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(MemberVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public MemberVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<MemberVO> get() throws Exception {
		return dao.select();
	}

	@Override
	public MemberVO login(MemberVO v) {
		MemberVO loginOkUser = dao.login(v);
		return loginOkUser;
	}

	@Override
	public ArrayList<MemberVO> getstate(String P_id) throws Exception {
		return null;
	}

	@Override
	public ArrayList<MemberVO> getstateBy_p_id() throws Exception {		
		return null;
	}

	@Override
	public MemberVO idcheck(MemberVO v) {
		MemberVO idOk = dao.idcheck(v);
		return idOk;
	}

	@Override
	public MemberVO pwdcheck(MemberVO v) {
		MemberVO pwdOk = dao.pwdcheck(v);
		return pwdOk;
	}

	@Override
	public String seePayment(String k) {		
		return null;
	}

	@Override
	public void updatePayment(MemberVO v) {
		
	}

	@Override
	public void pay(MemberVO v) {
			
	}

	public void pointcharge(MemberVO v) {
		
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
	public List<MemberVO> selectList(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MemberVO> categorylist(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MemberVO> dateSearch(String k1, String k2) throws Exception {
		return dao.dateSearch(k1, k2);
	}

	@Override
	public ArrayList<MemberVO> carnumList(String k) throws Exception {
		return dao.carnumList(k);
	}

	
}
