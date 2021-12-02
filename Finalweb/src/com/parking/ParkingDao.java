package com.parking;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.ParkingMapper;
import com.vo.ParkingVO;

@Repository("ParkingDao")
public class ParkingDao implements Dao<String, ParkingVO>{
	@Autowired
	ParkingMapper pm;

	@Override
	public void insert(ParkingVO v) throws Exception {
		pm.insert(v);
	}

	@Override
	public void delete(String k) throws Exception {
		pm.delete(k);
	}

	@Override
	public void update(ParkingVO v) throws Exception {
		pm.update(v);
	}

	@Override
	public ParkingVO select(String k) throws Exception {
		return pm.select(k);
	}

	@Override
	public ArrayList<ParkingVO> select() throws Exception {
		return pm.selectall();
	}

	@Override
	public ParkingVO login(ParkingVO v) {
		return null;
	}

	@Override
	public ArrayList<ParkingVO> getstate(String k) {
		return null;
	}

	@Override
	public ArrayList<ParkingVO> getstateBy_p_id() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
