package org.jfree.data.test.Range;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeScaleTest {

	Range r1;
	
	@Before
	public void setUp() throws Exception {
		r1 = new Range(1,2);
	}

	@Test
	public void test() {
		assertEquals("", new Range(2,4), Range.scale(r1, 2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test2() {
		Range.scale(r1,  -2);
		
	}

}
