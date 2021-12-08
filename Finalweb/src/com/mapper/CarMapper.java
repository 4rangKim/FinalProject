package com.mapper;

import java.util.ArrayList;
import java.util.List;

import com.vo.CarVO;
import com.vo.payAmountcheck_result_VO;

public interface CarMapper {
	public void insert(CarVO obj);
	public void add(CarVO obj);
	public void delete(String obj);
	public void update(CarVO obj);
	public CarVO select(String obj);
	public ArrayList<CarVO> selectall();
	public String seePayment(String id);
	public payAmountcheck_result_VO getTodayInfo(String p_id);
	public List<CarVO> selectList(String obj);
}



