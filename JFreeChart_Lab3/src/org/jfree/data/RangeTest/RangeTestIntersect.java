package org.jfree.data.RangeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeTestIntersect {
	private Range base1;
    private Range example1;
    private Range example2;

    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

	//setting up Range objects for eqv class
    @Before
    public void setUp() throws Exception { 
    	
    	base1 = new Range(3, 5);
    	example1 = new Range(3,7);
    	example2 = new Range(-6,-3);
    }
    
    @Test
    public void testRangeLowers() {
    	assertFalse("should return Range(1,5)", base1.intersects(new Range(0,1)));

    }
    @Test
    public void testRangeIntersectsLower() {
    	assertTrue("should return Range(1,5)", base1.intersects(new Range(0,4)));

    	
    }
    @Test
    public void testRangeIntersectsUpper() {
    	assertTrue("should return Range(1,5)", base1.intersects(new Range(4,6)));

    	
    }
    @Test
    public void testRangeUpper() {
    	assertFalse("should return Range(1,5)", base1.intersects(new Range(6,8)));

    	
    }
    
    
    
}
