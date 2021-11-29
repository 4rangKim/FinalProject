package com.member;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.frame.Dao;
import com.frame.Service;
import com.vo.MemberVO;

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
	
	
}
