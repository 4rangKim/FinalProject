package com.mapper;

import java.util.ArrayList;

import com.vo.ManagerVO;


public interface ManagerMapper {
	public void insert(ManagerVO v);
	public void delete(String k);
	public void update(ManagerVO v);
	public ManagerVO select(String k);
	public ManagerVO login(ManagerVO v);
	public ArrayList<ManagerVO> selectall();
}



