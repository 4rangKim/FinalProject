package com.vo;

import java.util.Date;

public class CarVO {
	public String car_num;
	public String mem_id;
	public String p_id;
	public Date in_time;
	public Date out_time;
	
	public CarVO() {
		
	}
	
	public CarVO(String car_num, String mem_id, Date in_time, Date out_time) {
		super();
		this.car_num = car_num;
		this.mem_id = mem_id;
		this.in_time = in_time;
		this.out_time = out_time;
	}
	
	public CarVO(String p_id, String car_num) {
		super();
		this.p_id = p_id;
		this.car_num = car_num;		
	}
	
	public CarVO(String car_num) {
		super();
		this.car_num = car_num;		
	}

	public String getCar_num() {
		return car_num;
	}

	public void setCar_num(String car_num) {
		this.car_num = car_num;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public Date getIn_time() {
		return in_time;
	}

	public void setIn_time(Date in_time) {
		this.in_time = in_time;
	}

	public Date getOut_time() {
		return out_time;
	}

	public void setOut_time(Date out_time) {
		this.out_time = out_time;
	}

	@Override
	public String toString() {
		return "CarVO [car_num=" + car_num + ", mem_id=" + mem_id + ", in_time=" + in_time + ", out_time=" + out_time
				+ "]";
	}
	
}
