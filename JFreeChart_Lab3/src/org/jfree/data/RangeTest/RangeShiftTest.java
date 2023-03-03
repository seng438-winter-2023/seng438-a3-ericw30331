package org.jfree.data.RangeTest;

import static org.junit.Assert.assertEquals;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeShiftTest {
	private Range base1;
    private Range example1;
    private Range example2;

    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

	//setting up Range objects for eqv class
    @Before
    public void setUp() throws Exception { 
    	
    	base1 = new Range(1, 5);
    	example1 = new Range(3,7);
    	example2 = new Range(-6,-3);
    }
    
    @Test
    public void testRange2arguments() {
    	assertEquals("shifting range 1 - 5 by 2 should return a Range of 3 -7", new Range(3,7), Range.shift(base1, 2));

    }
    @Test
    public void testRange3arguments() {
    	assertEquals("shifting range 1 - 5 by 2 should return a Range of 3 -7", new Range(3,7), Range.shift(base1, 2,true));

    	
    }
    
    
    
}
