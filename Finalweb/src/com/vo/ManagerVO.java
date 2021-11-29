package com.vo;

public class ManagerVO {
	public String mgr_id;
	public String mgr_pwd;
	public String mgr_name;
	public String mgr_tel;
	
	public ManagerVO() {
		
	}

	public ManagerVO(String mgr_id, String mgr_pwd, String mgr_name, String mgr_tel) {
		super();
		this.mgr_id = mgr_id;
		this.mgr_pwd = mgr_pwd;
		this.mgr_name = mgr_name;
		this.mgr_tel = mgr_tel;
	}

	public String getMgr_id() {
		return mgr_id;
	}

	public void setMgr_id(String mgr_id) {
		this.mgr_id = mgr_id;
	}

	public String getMgr_pwd() {
		return mgr_pwd;
	}

	public void setMgr_pwd(String mgr_pwd) {
		this.mgr_pwd = mgr_pwd;
	}

	public String getMgr_name() {
		return mgr_name;
	}

	public void setMgr_name(String mgr_name) {
		this.mgr_name = mgr_name;
	}

	public String getMgr_tel() {
		return mgr_tel;
	}

	public void setMgr_tel(String mgr_tel) {
		this.mgr_tel = mgr_tel;
	}

	@Override
	public String toString() {
		return "ManagerVO [mgr_id=" + mgr_id + ", mgr_pwd=" + mgr_pwd + ", mgr_name=" + mgr_name + ", mgr_tel="
				+ mgr_tel + "]";
	}
	
}
