package com.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.MemberMapper;
import com.vo.MemberVO;
import com.vo.payAmountcheck_result_VO;

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
		mem.carinsert(v);
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

	@Override
	public ArrayList<MemberVO> getstate(String k) {
		return null;
	}

	@Override
	public ArrayList<MemberVO> getstateBy_p_id() {		
		return null;
	}

	@Override
	public MemberVO idcheck(MemberVO v) {
		return mem.idcheck(v);
	}

	@Override
	public MemberVO pwdcheck(MemberVO v) {
		return mem.pwdcheck(v);
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
	public  ArrayList<MemberVO> dateSearch(String tag, String search) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		map.put("tag",tag);
		map.put("search",search);
		return mem.dateSearch(map);
	}

	@Override
	public ArrayList<MemberVO> carnumList(String k) throws Exception {
		return mem.carnumList(k);
	}

}
