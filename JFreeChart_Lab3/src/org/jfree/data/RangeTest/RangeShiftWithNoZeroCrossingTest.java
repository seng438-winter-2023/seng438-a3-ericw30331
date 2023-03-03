package org.jfree.data.test.Range;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeShiftWithNoZeroCrossingTest {

	Range r1;
	Range r2;
	Range r3;
	
	@Before
	public void setUp() throws Exception {
		r1 = new Range(1,2);
		r2 = new Range(-5, -2);
		r3 = new Range(0, 1);
	}

	@Test
	public void test() {
		assertEquals(new Range(0,1), Range.shift(r1, -1, false));
	}
	
	@Test
	public void test2() {
		assertEquals(new Range(-4,-1), Range.shift(r2, 1, false));
	}
	
	@Test
	public void test3() {
		assertEquals(new Range(0,1), Range.shift(r3, 0, false));
	}


}
