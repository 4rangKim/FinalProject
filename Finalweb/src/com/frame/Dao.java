package com.frame;

import java.util.ArrayList;


public interface Dao<K,V> {
	public void insert(V v) throws Exception;
	public void delete(K k) throws Exception;
	public void update(V v) throws Exception;
	public V select(K k) throws Exception;
	public V login(V v);
	public ArrayList<V> select() throws Exception;
	public ArrayList<V> getstate(K k);
	public ArrayList<V> getstateBy_p_id();
	public V idcheck(V v);
	public V pwdcheck(V v);
	public K seePayment(K k);
	public void pay(V v);
	public void pointcharge(V v);
	public K pointselect(K k);
}
