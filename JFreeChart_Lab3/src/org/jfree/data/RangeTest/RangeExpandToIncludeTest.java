package org.jfree.data.RangeTest;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeExpandToIncludeTest {

	private Range base1;
	private Range base2;
	private Range base3;
    private Range example1;
 void setUpBeforeClass() throws Exception {
    }

	//setting up Range objects for eqv class
    @Before
    public void setUp() throws Exception { 
    	
    	base1 = new Range(-5, 3);
    	base2 = new Range(-3, 5);
    	base3 = new Range(2, 2);
    	example1 = new Range(-3,3);

    }
    @Test
	public void testValidRangeValidInputWithinBounds() {
    	assertEquals("The Range should be (-3,3)",
		    	example1, Range.expandToInclude(example1, 0));
	}
    @Test
	public void testValidRangeInputBelowBounds() {
    	assertEquals("The Range should be (-5,3)",
		    	base1, Range.expandToInclude(example1, -5));
	}
    @Test
	public void testValidRangeInputAboveBounds() {
    	assertEquals("The Range should be (-3,5)",
		    	base2, Range.expandToInclude(example1, 5));
	}
    @Test
   	public void TestNullRange() {
       	assertEquals("The Range should be (2,2)",
   		    	base3, Range.expandToInclude(null, 2));
   	}
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
