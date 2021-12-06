package com.member;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.frame.Dao;
import com.frame.Service;
import com.vo.MemberVO;
import com.vo.PayVO;

@org.springframework.stereotype.Service("MemberService")
public class MemberService implements Service<String, MemberVO>{

	@Resource(name="MemberDao")
	Dao<String,MemberVO> dao;
	@Resource(name="PayDao")
	Dao<String,PayVO> dao1;

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
		// TODO Auto-generated method stub
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
	public int seePayment(String k) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void pointcharge(MemberVO v) {
	}

	@Override
	public String pointselect(String k) {
		// TODO Auto-generated method stub
		return null;
	}	
}
