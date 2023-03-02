package org.jfree.data.RangeTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeEqualsTest {

	
    private Range example1;
    private Range example2;
    private Range example3;
    private Range example4;
    private ArrayList example5;
    private Range example6;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

	//setting up Range objects for eqv class
    @Before
    public void setUp() throws Exception { 
    	
    	example1 = new Range(1,2);
    	example2 = new Range(1,2);
    	example3 = new Range(0,2);
    	example4 = new Range(1,5);
    	example5 = null;
    	example6 = null;
    	//test
    }
    
	
    @Test
    public void TestRangeSame() {
    	assertEquals("should return true", true, example1.equals(example2));
    }
    @Test
    public void TestRangeDiffLower() {
    	assertEquals("should return false", false, example1.equals(example3));
    }
    @Test
    public void TestRangeDiffUpper() {
    	assertEquals("should return false", false, example1.equals(example4));
    }
    @Test
    public void TestRangeDiffObject() {
    	assertEquals("should return false", false, example1.equals(example5));
    }
    @Test
    public void TestRangeNullParam() {
    	assertEquals("should return false", false, example1.equals(example6));
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
