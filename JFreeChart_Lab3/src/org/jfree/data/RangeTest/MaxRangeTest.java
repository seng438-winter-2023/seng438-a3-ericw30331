package org.jfree.data.RangeTest;

import static org.junit.Assert.*;
import org.jfree.data.Range;


import org.junit.Before;
import org.junit.Test;

public class MaxRangeTest {

	Range r1;
	Range r2;
	Range r3;
	
	@Before
	public void setUp() throws Exception {
		r1 = new Range(1,2);
		r2 = new Range(3,4);
		
		r3 = new Range(Double.NaN, Double.NaN);
	}

	@Test
	public void test() {
    	assertEquals("Should return [1,4]", new Range(1,4), Range.combineIgnoringNaN(r1, r2));

	}
	
	@Test
	public void test2() {
    	assertEquals("Should return [1,2]", new Range(1, 2), Range.combineIgnoringNaN(r1, r3));

	}
	
	@Test
	public void test3() {
    	assertEquals("", null, Range.combineIgnoringNaN(r3, r3));

	}
}
