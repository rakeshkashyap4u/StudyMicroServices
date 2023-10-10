package com.example.limitServicesApplication.bean;

public class Limits {
	
	
	private int min;
	private int max;
	public Limits(int min, int max) {
		this.max=max;
		this.min=min;
				
		// TODO Auto-generated constructor stub
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}

}
