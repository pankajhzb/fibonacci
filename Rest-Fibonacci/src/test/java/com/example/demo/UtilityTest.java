package com.example.demo;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.constant.Constant;
import com.example.demo.response.FibonacciResponse;
import com.example.demo.service.FibonacciService;

@SpringBootTest
public class UtilityTest {

	@Autowired
	@Qualifier("loopCalculate")
	FibonacciService calculateFibonacciLoop;

	@Test
	public void inputOneTest() {
		FibonacciResponse userRes = calculateFibonacciLoop.calculate(1);
		List<Integer> actualList = userRes.getFibonacciList();
		Integer[] intArray = { 0 };
		List<Object> expectedList = Arrays.asList(intArray);
		Assertions.assertEquals(expectedList, actualList);
	}

	@Test
	public void inputValidTest() {
		FibonacciResponse userRes = calculateFibonacciLoop.calculate(2);
		List<Integer> actualList = userRes.getFibonacciList();
		Integer[] intArray = { 0, 1 };
		List<Object> expectedList = Arrays.asList(intArray);
		Assertions.assertEquals(expectedList, actualList);
	}

	@Test
	public void inputValidLimitTest() {
		FibonacciResponse userRes = calculateFibonacciLoop.calculate(10);
		List<Integer> actualList = userRes.getFibonacciList();
		Assertions.assertEquals(10, actualList.size());
	}

	@Test
	public void inputInvalidZeroTest() {
		FibonacciResponse userRes = calculateFibonacciLoop.calculate(0);
		Assertions.assertEquals(Constant.INVALID_MESSAGE, userRes.getStatus());
	}

	/*
	 * Handling by framework, can update to custom message
	 */
	// @Test
	public void inputInvalidNegativeTest() {
		FibonacciResponse userRes = calculateFibonacciLoop.calculate(-1);
		Assertions.assertEquals(Constant.INVALID_MESSAGE, userRes.getStatus());
	}

	/*
	 * Handling by framework, can update to custom message
	 */
	// @Test
	public void inputMaxValueTest() {
		FibonacciResponse userRes = calculateFibonacciLoop.calculate(Integer.MAX_VALUE + 1);// 2147483647
		Assertions.assertEquals(Constant.MAX_LIMIT_MESSAGE, userRes.getStatus());
	}

	/*
	 * Handling by framework, can update to custom message
	 */
	// @Test
	public void inputNonIntegerValueTest() {
		FibonacciResponse userRes = calculateFibonacciLoop.calculate(Integer.valueOf("string"));
		Assertions.assertEquals(Constant.NON_INTEGER_MESSAGE, userRes.getStatus());
	}

}
