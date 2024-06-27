package com.wissen;

import java.util.List;

public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}

	public int sub(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int subtract(int a, int b) {
		return a / b;
	}

	public int mod(int a, int b) {
		return a % b;
	}
	
	public int div(int a, int b) throws ArithmeticException {
		if(b!=0) {
			return a/b;
		}
		else {
			throw new ArithmeticException();
		}
	}
	
	public void voidMethod(String string) {
		System.out.println("void method is invoked with args: " + string);
	}
}
