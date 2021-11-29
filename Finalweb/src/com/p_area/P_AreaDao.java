package com.p_area;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.P_AreaMapper;
import com.vo.P_AreaVO;

@Repository("P_AreaDao")
public class P_AreaDao implements Dao<String, P_AreaVO>{
	@Autowired
	P_AreaMapper pam;

	@Override
	public void insert(P_AreaVO v) throws Exception {
		pam.insert(v);
	}

	@Override
	public void delete(String k) throws Exception {
		pam.delete(k);
	}

	@Override
	public void update(P_AreaVO v) throws Exception {
		pam.update(v);
	}

	@Override
	public P_AreaVO select(String k) throws Exception {
		return pam.select(k);
	}

	@Override
	public ArrayList<P_AreaVO> select() throws Exception {
		return pam.selectall();
	}

	@Override
	public P_AreaVO login(P_AreaVO v) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
