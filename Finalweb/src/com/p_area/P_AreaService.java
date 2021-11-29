package com.p_area;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.frame.Dao;
import com.frame.Service;
import com.vo.P_AreaVO;

@org.springframework.stereotype.Service("P_AreaService")
public class P_AreaService implements Service<String, P_AreaVO>{

	@Resource(name="P_AreaDao")
	Dao<String,P_AreaVO> dao;

	@Override
	public void register(P_AreaVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(P_AreaVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public P_AreaVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<P_AreaVO> get() throws Exception {
		return dao.select();
	}

	@Override
	public P_AreaVO login(P_AreaVO v) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
