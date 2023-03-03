package org.jfree.data.RangeTest;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeConstrainTest {

	
    private Range example1;
    private Range example2;
    private Range example3;
    private Range example4;

    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

	//setting up Range objects for eqv class
    @Before
    public void setUp() throws Exception { 
    	
    	example1 = new Range(1,2);
    	example2 = new Range(2,5);
    	example3 = new Range(-1,3);
    	example4 = null;
    }
    
	
    @Test
    public void testConstrainBelowLower() {
    	assertEquals("should return 1", 1, example1.constrain(-1), .000000001d);
    }
    
    @Test
    public void testConstrainWithinBounds() {
    	assertEquals("should return 4", 4, example2.constrain(4), .000000001d);
    }
    
    @Test
    public void testConstrainAboveUpper() {
    	assertEquals("should return 3", 3, example3.constrain(17), .000000001d);
    }
    
    @Test(expected=NullPointerException.class)
    public void testConstrainNullRange() {
    	assertEquals("should return ?", -1, example4.constrain(2), .000000001d);
    }
    
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
