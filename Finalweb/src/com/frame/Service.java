package com.frame;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.vo.CarVO;
import com.vo.payAmountcheck_result_VO;


public interface Service<K,V> {
	@Transactional
	public void register(V v) throws Exception;
	@Transactional
	public void remove(K k) throws Exception;
	@Transactional
	public void modify(V v) throws Exception;
	public V get(K k) throws Exception;
	public V login(V v);
	public ArrayList<V> get() throws Exception;
	public ArrayList<V> getstate(K P_id) throws Exception;
	public ArrayList<V> getstateBy_p_id() throws Exception;
	public V idcheck(V v);
	public V pwdcheck(V v);
	public String seePayment(K k);
	public void pay(V v);
	public void pointcharge(V v);
	public K pointselect(K k);
	public payAmountcheck_result_VO getTodayInfo(K k);
}



