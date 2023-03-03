package org.jfree.data.test.Range;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class isNaNRangeTest {

	Range exampleRange;
	Range range2;
	Range range3;
	Range range4;
	
	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-1, 1);
		range2 = new Range(Double.NaN, Double.NaN);
		range3 = new Range(1, Double.NaN);
		range4 = new Range(Double.NaN, 1);
	}

	@Test
	public void test() {
		assertFalse(exampleRange.isNaNRange());
	}
	
	@Test
	public void test2() {
		assertTrue(range2.isNaNRange());
	}
	
	@Test
	public void test3() {
		assertFalse(range3.isNaNRange());
	}
	
	@Test
	public void test4() {
		assertFalse(range4.isNaNRange());
	}

}
