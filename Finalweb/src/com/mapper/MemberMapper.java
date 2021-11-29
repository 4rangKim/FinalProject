package com.mapper;

import java.util.ArrayList;

import com.vo.MemberVO;

public interface MemberMapper {
	public void insert(MemberVO v);
	public void delete(String k);
	public void update(MemberVO v);
	public MemberVO select(String k);
	public MemberVO login(MemberVO v);
	public ArrayList<MemberVO> selectall();
}



