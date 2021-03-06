package com.mapper;

import java.util.ArrayList;

import com.vo.P_AreaVO;
import com.vo.ParkingVO;

public interface P_AreaMapper {
	public void insert(P_AreaVO obj);
	public void delete(String obj);
	public void update(P_AreaVO obj);
	public P_AreaVO select(String obj);
	public ArrayList<P_AreaVO> selectall();
	public ArrayList<P_AreaVO> selectByP_id(String p_id);
	public ArrayList<P_AreaVO> getstateBy_p_id();
	
}



