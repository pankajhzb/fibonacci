package com.example.demo.response;

import java.util.List;

public class FibonacciResponse {
	String status;
	List<Integer> fibonacciList;

	public List<Integer> getFibonacciList() {
		return fibonacciList;
	}

	public void setFibonacciList(List<Integer> fibonacciList) {
		this.fibonacciList = fibonacciList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
