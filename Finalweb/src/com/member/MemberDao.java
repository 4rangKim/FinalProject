package com.member;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.MemberMapper;
import com.vo.MemberVO;

@Repository("MemberDao")
public class MemberDao implements Dao<String, MemberVO>{
	@Autowired
	MemberMapper mem;

	@Override
	public void insert(MemberVO v) throws Exception {
		mem.insert(v);
	}

	@Override
	public void delete(String k) throws Exception {
		mem.delete(k);
	}

	@Override
	public void update(MemberVO v) throws Exception {
		mem.update(v);
	}

	@Override
	public MemberVO select(String k) throws Exception {
		return mem.select(k);
	}

	@Override
	public ArrayList<MemberVO> select() throws Exception {
		return mem.selectall();
	}

	@Override
	public MemberVO login(MemberVO v) {
		return mem.login(v);
	}
	
	
}