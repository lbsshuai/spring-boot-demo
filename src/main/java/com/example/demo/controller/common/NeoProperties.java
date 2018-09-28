package com.example.demo.controller.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NeoProperties {

	/*@Value("${com.lbs.three}")
	private String three;*/
	
	@Value("${com.lbs.one}")
	private String one;
	
	@Value("${com.lbs.two}")
	private String two;

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

	/*public String getThree() {
		return three;
	}

	public void setThree(String three) {
		this.three = three;
	}*/
	
}
