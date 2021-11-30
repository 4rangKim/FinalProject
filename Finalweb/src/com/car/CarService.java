package com.car;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.frame.Dao;
import com.frame.Service;
import com.vo.CarVO;

@org.springframework.stereotype.Service("CarService")
public class CarService implements Service<String, CarVO>{

	@Resource(name="CarDao")
	Dao<String,CarVO> dao;

	@Override
	public void register(CarVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(CarVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public CarVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<CarVO> get() throws Exception {
		return dao.select();
	}

	@Override
	public CarVO login(CarVO v) {
		return null;
	}

	@Override
	public ArrayList<CarVO> getstate(String P_id) throws Exception {
		return null;
	}
	
}
