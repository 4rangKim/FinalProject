package com.vo;

public class PayVO {
	public String mem_id;
	public int mem_money;
	
	public PayVO() {
		
	}

	public PayVO(String mem_id, int mem_money) {
		super();
		this.mem_id = mem_id;
		this.mem_money = mem_money;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getMem_money() {
		return mem_money;
	}

	public void setMem_money(int mem_money) {
		this.mem_money = mem_money;
	}

	@Override
	public String toString() {
		return "PayVO [mem_id=" + mem_id + ", mem_money=" + mem_money + "]";
	}
	
	
}