package com.parking;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.frame.Dao;
import com.frame.Service;
import com.vo.ParkingVO;

@org.springframework.stereotype.Service("ParkingService")
public class ParkingService implements Service<String, ParkingVO>{

	@Resource(name="ParkingDao")
	Dao<String,ParkingVO> dao;

	@Override
	public void register(ParkingVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(ParkingVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public ParkingVO get(String k) throws Exception {
		return dao.select(k);
	}

	
	@Override
	public ArrayList<ParkingVO> get() throws Exception {
		return dao.select();
	}
	
	// �Ʒ��� �߰���==============================================
	@Override
	public ArrayList<ParkingVO> getstate(String P_id) throws Exception {
		return null;
	}
	//=======================================================
	
	@Override
	public ParkingVO login(ParkingVO v) {
		return null;
	}

	// �Ʒ��� �߰���==============================================
	@Override
	public ArrayList<ParkingVO> getstateBy_p_id() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParkingVO idcheck(ParkingVO v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParkingVO pwdcheck(ParkingVO v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int seePayment(String k) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void pointcharge(ParkingVO v) {
	}

	@Override
	public String pointselect(String k) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
