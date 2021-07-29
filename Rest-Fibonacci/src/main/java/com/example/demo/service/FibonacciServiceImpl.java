package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.constant.Constant;
import com.example.demo.response.FibonacciResponse;

@Service("loopCalculate")
public class FibonacciServiceImpl implements FibonacciService {
	@Override
	public FibonacciResponse calculate(int limit) {
		FibonacciResponse response = new FibonacciResponse();
		List<Integer> fibonacciList = new ArrayList<>(limit);

		if (limit == 0) {
			response.setStatus(Constant.INVALID_MESSAGE);
		} else if (limit < 0) {
			response.setStatus(Constant.INVALID_MESSAGE);
		} else if (limit == 1) {
			response.setStatus(Constant.OK_MESSAGE);
			fibonacciList.add(0);
		} else {
			fibonacciList.add(0);
			fibonacciList.add(1);
			generateFibonacciList(limit, fibonacciList);
			response.setStatus(Constant.OK_MESSAGE);
		}
		response.setFibonacciList(fibonacciList);
		return response;
	}

	private void generateFibonacciList(int limit, List<Integer> fibonacciList) {
		int counter = 2;
		int fiboNum;
		int i = 0;
		int j = 1;
		while (counter < limit) {
			fiboNum = i + j;
			i = j;
			j = fiboNum;
			fibonacciList.add(fiboNum);
			counter++;
		}
	}

}
