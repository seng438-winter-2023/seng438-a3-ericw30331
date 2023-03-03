package org.jfree.data.RangeTest;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeCombineIgnoringNaNTest {

	private Range base1;
    private Range example1;
    private Range example2;

    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

	//setting up Range objects for eqv class
    @Before
    public void setUp() throws Exception { 
    	
    	base1 = new Range(-6, 3);
    	example1 = new Range(-3,3);
    	example2 = new Range(-6,-3);
    }
    
    @Test
    public void testValidRanges() {
    	assertEquals("The Range should be (-6,6)",
		    	base1, Range.combineIgnoringNaN(example1, example2));
    }
    @Test
    public void testRange1Null() {
    	assertEquals("The Range should be (-6,-3)",
		    	example2, Range.combineIgnoringNaN(null, example2));
    }
    @Test
    public void testRange2Null() {
    	assertEquals("The Range should be (-3,3)",
		    	example1, Range.combineIgnoringNaN(example1, null));
    }
    @Test
    public void testBothRangeNull() {
    	assertEquals("The Range should be ()",
		    	null, Range.combineIgnoringNaN(null, null));
    }
	
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
