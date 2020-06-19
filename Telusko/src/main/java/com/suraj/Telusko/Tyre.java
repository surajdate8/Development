package com.suraj.Telusko;

import org.springframework.stereotype.Component;

@Component
public class Tyre {
	private String brands;
	
//	public Tyre(String brands) {
//		super();
//		this.brands = brands;
//	}

	public String getBrands() {
		return brands;
	}

	public void setBrands(String brands) {
		this.brands = brands;
	}
	@Override
	public String toString() {
		return " working ";
	}

	

}
