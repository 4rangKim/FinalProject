package com.mapper;

import java.util.ArrayList;

import com.vo.ParkingVO;

public interface ParkingMapper {
	public void insert(ParkingVO obj);
	public void delete(String obj);
	public void update(ParkingVO obj);
	public ParkingVO select(String obj);
	public ArrayList<ParkingVO> selectall();
	
}



