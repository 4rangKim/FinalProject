package com.mapper;

import java.util.ArrayList;

import com.vo.P_AreaVO;

public interface P_AreaMapper {
	public void insert(P_AreaVO obj);
	public void delete(String obj);
	public void update(P_AreaVO obj);
	public P_AreaVO select(String obj);
	public ArrayList<P_AreaVO> selectall();
}



