package com.frame;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;


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
	public int seePayment(K k);
	public void pointcharge(V v);
	public K pointselect(K k);
}



