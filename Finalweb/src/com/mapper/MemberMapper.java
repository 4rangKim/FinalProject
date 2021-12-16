package com.mapper;

import java.util.ArrayList;
import java.util.Map;

import com.vo.MemberVO;

public interface MemberMapper {
	public void insert(MemberVO v);
	public void delete(String k);
	public void update(MemberVO v);
	public MemberVO select(String k);
	public MemberVO login(MemberVO v);
	public ArrayList<MemberVO> selectall();
	public MemberVO idcheck(MemberVO v);
	public MemberVO pwdcheck(MemberVO v);
	public void carinsert(MemberVO v);
	public ArrayList<MemberVO> carnumList(String obj);
	public ArrayList<MemberVO> dateSearch(Map<String,String> map) throws Exception;
}



