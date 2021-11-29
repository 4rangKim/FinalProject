package com.mapper;

import java.util.ArrayList;

import com.vo.CarVO;

public interface CarMapper {
	public void insert(CarVO obj);
	public void delete(String obj);
	public void update(CarVO obj);
	public CarVO select(String obj);
	public ArrayList<CarVO> selectall();
}



