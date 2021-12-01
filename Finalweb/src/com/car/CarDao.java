package com.car;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.CarMapper;
import com.mapper.ParkingMapper;
import com.vo.CarVO;
import com.vo.ParkingVO;

@Repository("CarDao")
public class CarDao implements Dao<String, CarVO>{
	@Autowired
	CarMapper cm;

	@Override
	public void insert(CarVO v) throws Exception {
		cm.insert(v);
	}

	@Override
	public void delete(String k) throws Exception {
		cm.delete(k);
	}

	@Override
	public void update(CarVO v) throws Exception {
		cm.update(v);
	}

	@Override
	public CarVO select(String k) throws Exception {
		return cm.select(k);
	}

	@Override
	public ArrayList<CarVO> select() throws Exception {
		return cm.selectall();
	}

	@Override
	public CarVO login(CarVO v) {
		return null;
	}

	@Override
	public ArrayList<CarVO> getstate(String k) {
		return null;
	}
	
	
}
