package com.vo;

public class P_Area_ResultVo {
	public String p_id;
	//public int state;
	public int Ecount;
	public int Ocount;
	
	public P_Area_ResultVo() {
	}

	public P_Area_ResultVo(String p_id, int ecount, int ocount) {
		super();
		this.p_id = p_id;
		Ecount = ecount;
		Ocount = ocount;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public int getEcount() {
		return Ecount;
	}

	public void setEcount(int ecount) {
		Ecount = ecount;
	}

	public int getOcount() {
		return Ocount;
	}

	public void setOcount(int ocount) {
		Ocount = ocount;
	}

	@Override
	public String toString() {
		return "P_Area_ResultVo [p_id=" + p_id + ", Ecount=" + Ecount + ", Ocount=" + Ocount + "]";
	}

	
	
}
