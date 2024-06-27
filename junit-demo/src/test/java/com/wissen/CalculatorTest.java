package com.wissen;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.mockito.ArgumentCaptor;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Testing calculator operation")
class CalculatorTest {

	Calculator c1;
	boolean condition = false;
	
	public CalculatorTest() {
		System.out.println("calcualtorTest object is created");
	}
	
	@BeforeAll
	public void create() {
		System.out.println("----Started---");
		c1 = new Calculator();
	}
	
	@AfterAll
	public void remove() {
		c1 = null;
		System.out.println("----Ended-----");
	}
	
	@BeforeEach
	public void before() {
		System.out.println("Before each test case");
	}
	
	@AfterEach
	public void after() {
		System.out.println("After each test case");
	}
	
	@Test
	@Disabled
	@Tag("demo")
	void test() {
		System.out.println("Extra test cases");
		assertTrue(true);
	}

	@Test
	@DisplayName("Testing adding")
	@Tag("math")
	public void testAdd() {
		Calculator c1 = new Calculator();
		int result = c1.add(10, 20);
		int expected = 30;
		assertEquals(expected, result);
		System.out.println("testAdd()");
	}

	@Test
	@Tag("math")
	public void testMod() {
		Calculator c1 = new Calculator();
		int result1 = c1.mod(50, 9);
		int result2 = c1.mod(40, 3);
		int result3 = c1.mod(20, 5);
		assertEquals(5, result1);
		assertEquals(1, result2);
		assertEquals(0, result3);
		System.out.println("testMod()");
	}

	@Test
	@Tag("math")
	public void testSub() {
		assumeTrue(condition);
		Calculator c1 = new Calculator();
		int x = 10;
		int y = 20;
		int actual = c1.sub(x, y);
		int expected = -10;
		assertEquals(expected, actual, () -> "Subtract " + y + " from " + x 
				+ " and result is " + actual + " while expected was " + expected);
		System.out.println("testSub()");

	}

	@Test
	@Tag("math")
	public void testDiv() {
		assertThrows(ArithmeticException.class, () -> c1.div(10, 0));
		assertEquals(5, c1.div(10,2));
		System.out.println("testDiv() method");
	}
	
	@Test
	@EnabledOnOs(OS.WINDOWS)
	@Tag("os")
	public void testWindows() {
		System.out.println("testWindows()");
	}
	
	@Test
	@EnabledOnOs(value = { OS.LINUX, OS.MAC})
	@Tag("os")
	public void testLinux() {
		System.out.println("testLinux()");
	}
	
	@Test
	@EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_11)
	@Tag("os")
	public void jreVersionTest() {
		System.out.println("Java version test min=8 & max=11");
	}
	
	@Test
	public void testVoidMethod() {
		List<String> list = new ArrayList<>();
		list.add("first");
	    c1.voidMethod(list.get(0));
	    ArgumentCaptor<String> argCaptor = ArgumentCaptor.forClass(String.class);
	    verify(c1).voidMethod(argCaptor.capture()); // Capture the argument
	    assertEquals("1Arg", argCaptor.getValue()); // Verify the captured value
	}
}
