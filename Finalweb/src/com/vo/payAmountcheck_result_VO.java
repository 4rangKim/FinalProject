package com.vo;

public class payAmountcheck_result_VO {
	public int count;
	public int totalIncome;
	
	public payAmountcheck_result_VO() {
	}
	
	public payAmountcheck_result_VO(int count, int totalIncome) {
		this.count = count;
		this.totalIncome = totalIncome;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(int totalIncome) {
		this.totalIncome = totalIncome;
	}

	@Override
	public String toString() {
		return "payAmountcheck_result_VO [count=" + count + ", totalIncome=" + totalIncome + "]";
	}
	
	

}
