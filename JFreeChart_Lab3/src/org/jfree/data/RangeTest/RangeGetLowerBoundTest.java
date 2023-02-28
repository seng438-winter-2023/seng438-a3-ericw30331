package org.jfree.data.RangeTest;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeGetLowerBoundTest {

	
    private Range example1;
    private Range example2;
    private Range example3;
    private Range example4;
    private Range example5;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

	//set up example Range objects with eqv class values and boundary values
    @Before
    public void setUp() throws Exception { 
    	
    	example1 = new Range(-1, 1);
    	example2 = new Range(2, 2);
    	example3 = new Range(0,0);
    	example4 = new Range(Double.MIN_VALUE, 1);
    	example5 = new Range(Double.MAX_VALUE, Double.MAX_VALUE);
    }
    
	//basic getLowerBound test should return lowerbound of Range object
    @Test
    public void testGetLowerBound() {
    	assertEquals("get lower bound should return -1", -1, example1.getLowerBound(), .000000001d);
    }
    
	//should return lower bound where values are equal
    @Test
    public void testGetLowerBoundSameValues() {
    	assertEquals("get lower bound should return 2", 2, example2.getLowerBound(), .000000001d);
    }
    	//test getLowerBound where values are 0
    @Test
    public void testGetLowerBoundZeros() {
    	assertEquals("get lower bound should return 0", 0, example3.getLowerBound(), .000000001d);
    }
    
	//test getLowerBound where Boundary value is used
    @Test
    public void testGetLowerBoundMIN() {
    	assertEquals("get lower bound should return Double MIN", Double.MIN_VALUE, example4.getLowerBound(), .000000001d);
    }
    	//test getLowerBound where boundary value is used
    @Test
    public void testGetLowerBoundMAX() {
    	assertEquals("get lower bound should return Double MAX", Double.MAX_VALUE, example5.getLowerBound(), .000000001d);
    }
     
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}

