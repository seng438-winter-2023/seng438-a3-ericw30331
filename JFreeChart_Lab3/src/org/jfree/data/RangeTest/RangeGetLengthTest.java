package org.jfree.data.RangeTest;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeGetLengthTest {

	
    private Range example2;
    private Range example3;
    private Range example4;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

	//setting up Range objects for eqv class
    @Before
    public void setUp() throws Exception { 
    	
    	example2 = new Range(-3,3);
    	example3 = new Range(0,0);
    	example4 = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
    }
    
	//basic test to see if test will return correct value for eqv class
    @Test
    public void testGetLength() {
    	assertEquals("The length of -3 and 3 should be 6",
    	6, example2.getLength(), .000000001d);
    }
	//testing getLength for if both values are zero
    @Test
    public void testGetLengthNull() {
    	assertEquals("The length of 0 and 0 should be 0",
    	0, example3.getLength(), .000000001d);
    }
    
	//testing get length for if boundary values set to double.min and double.max
    @Test
    public void testGetLengthMINMAXInteger() {
    	assertEquals("The length of Integer.min and Integer.max should be ",
    	Double.MAX_VALUE-Double.MIN_VALUE, example4.getLength(), .000000001d);
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
