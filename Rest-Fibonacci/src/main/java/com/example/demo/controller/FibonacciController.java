package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.FibonacciResponse;
import com.example.demo.service.FibonacciService;

/**
 * To get Fibonacci list.
 * @author pankaj kumar
 *
 */
@RestController
public class FibonacciController {

	@Autowired
	@Qualifier("loopCalculate")
	FibonacciService calculateFibonacciLoop;

	@Autowired
	@Qualifier("recursiveCalculate")
	FibonacciService calculateFibonacciRecursv;

	@Autowired
	@Qualifier("inboundCalculate")
	FibonacciService calculateFibonacciInbound;

	/**
	 * To get fibonacci list using loop, number of element in list as per the input
	 * limit.
	 * 
	 * @param limit
	 * @return
	 */
	@GetMapping(value = "/api/v1/fibonacci/get/{limit}")
	public FibonacciResponse getFibonacciSeries(@PathVariable("limit") int limit) {
		return calculateFibonacciLoop.calculate(limit);
	}

	/**
	 * To get fibonacci list using recursion, number of element in list as per the
	 * input limit.
	 * 
	 * @param limit
	 * @return
	 */
	@GetMapping(value = "/api/v2/fibonacci/get/{limit}")
	public FibonacciResponse getFibonacciList(@PathVariable("limit") int limit) {
		return calculateFibonacciRecursv.calculate(limit);
	}

	/**
	 * To get fibonacci list using loop, element value in list not greater than the
	 * input limit.
	 * 
	 * @param limit
	 * @return
	 */
	@GetMapping(value = "/api/v3/fibonacci/get/{limit}")
	public FibonacciResponse getFibonacciInboundList(@PathVariable("limit") int limit) {
		return calculateFibonacciInbound.calculate(limit);
	}

}
