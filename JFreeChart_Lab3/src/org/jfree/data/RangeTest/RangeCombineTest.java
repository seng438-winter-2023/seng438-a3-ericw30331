package org.jfree.data.RangeTest;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeCombineTest {

	
    private Range example1;
    private Range example2;
    private Range example3;
    private Range example4;
    private Range example5;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

	//setting up Range objects for eqv class
    @Before
    public void setUp() throws Exception { 
    	example1 = null;
    	example2 = null;
    	example3 = new Range(1,2);
    	example4 = new Range(2,5);
    	example5 = new Range(2,5);
    	
    }
    
	
    @Test
    public void testCombineNull1() {
    	assertEquals("should return Range(1,2)", example3, Range.combine(example1, example3));
    }
    @Test
    public void testCombineNull2() {
    	assertEquals("should return Range(1,2)", example3, Range.combine(example3, example2));
    }
    @Test
    public void testCombineNullBoth() {
    	assertEquals("should return NULL", null, Range.combine(example1, example2));
    }
    @Test
    public void testCombineValid() {
    	assertEquals("should return Range(1,5)", new Range(1,5), Range.combine(example3, example4));
    }
    @Test
    public void testCombineValidSame() {
    	assertEquals("should return Range(2,5)", example4, Range.combine(example5, example4));
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
