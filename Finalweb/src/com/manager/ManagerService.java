package com.manager;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.frame.Dao;
import com.frame.Service;
import com.vo.ManagerVO;
import com.vo.MemberVO;

@org.springframework.stereotype.Service("ManagerService")
public class ManagerService implements Service<String, ManagerVO>{

	@Resource(name="ManagerDao")
	Dao<String,ManagerVO> dao;

	@Override
	public void register(ManagerVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(ManagerVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public ManagerVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<ManagerVO> get() throws Exception {
		return dao.select();
	}

	@Override
	public ManagerVO login(ManagerVO v) {
		ManagerVO loginOkUser = dao.login(v);
		return loginOkUser;
	}

	@Override
	public ArrayList<ManagerVO> getstate(String P_id) throws Exception {
		return null;
	}
	
	
}
