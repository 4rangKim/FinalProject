package com.vo;

import java.util.Date;

public class CarVO {
	public int car_seq;
	public String mem_id;
	public String p_id;
	public String car_num;
	public Date in_time;
	public Date out_time;
	public String in_photo;
	public String out_photo;
	public int payment;
	
	
	public CarVO() {
		
	}
	
	
	public CarVO(int car_seq, String mem_id, String p_id, String car_num, Date in_time, Date out_time, String in_photo,
			String out_photo) {
		super();
		this.car_seq = car_seq;
		this.mem_id = mem_id;
		this.p_id = p_id;
		this.car_num = car_num;
		this.in_time = in_time;
		this.out_time = out_time;
		this.in_photo = in_photo;
		this.out_photo = out_photo;
	}
	//차 들어왔을 때 register용
	public CarVO(String p_id, String car_num) {
		super();
		this.p_id = p_id;
		this.car_num = car_num;		
	}
	//차 나갈때 Out_time 업데이트용
	public CarVO(String car_num) {
		super();
		this.car_num = car_num;		
	}
	
	public int getCar_seq() {
		return car_seq;
	}


	public void setCar_seq(int car_seq) {
		this.car_seq = car_seq;
	}


	public String getP_id() {
		return p_id;
	}


	public void setP_id(String p_id) {
		this.p_id = p_id;
	}


	public String getIn_photo() {
		return in_photo;
	}


	public void setIn_photo(String in_photo) {
		this.in_photo = in_photo;
	}


	public String getOut_photo() {
		return out_photo;
	}


	public void setOut_photo(String out_photo) {
		this.out_photo = out_photo;
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
	
	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "CarVO [car_seq=" + car_seq + ", mem_id=" + mem_id + ", p_id=" + p_id + ", car_num=" + car_num
				+ ", in_time=" + in_time + ", out_time=" + out_time + ", in_photo=" + in_photo + ", out_photo="
				+ out_photo + "]";
	}

	
	
}
