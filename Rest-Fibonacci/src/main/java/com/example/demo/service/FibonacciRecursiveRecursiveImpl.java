package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.constant.Constant;
import com.example.demo.response.FibonacciResponse;

@Service("recursiveCalculate")
public class FibonacciRecursiveRecursiveImpl implements FibonacciService {

	@Override
	public FibonacciResponse calculate(int limit) {
		return getUsingRecursive(limit);
	}

	public FibonacciResponse getUsingRecursive(int limit) {
		FibonacciResponse response = new FibonacciResponse();
		List<Integer> fibonacciList = new ArrayList<Integer>();
		Integer value = 0;
		for (int i = 0; i < limit; i++) {
			value = fibo(i);
			fibonacciList.add(value);
			response.setStatus(Constant.OK_MESSAGE);
		}
		response.setFibonacciList(fibonacciList);
		return response;
	}

	public int fibo(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibo(n - 1) + fibo(n - 2);
		}
	}

}
