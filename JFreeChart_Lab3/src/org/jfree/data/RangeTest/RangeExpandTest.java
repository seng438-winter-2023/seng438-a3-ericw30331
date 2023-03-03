package org.jfree.data.RangeTest;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeExpandTest {

	private Range base;
	private Range base2;
    private Range example1;
    private Range example2;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

	//setting up Range objects for eqv class
    @Before
    public void setUp() throws Exception { 
    	
    	base = new Range(-6,6);
    	base2 = new Range(2.5,2.5);
    	example1 = new Range(-3,3);
    	example2 = new Range(1,2);
    }
    
	@Test
	public void testValidInputs() {
		assertEquals("The Range should be (-6,6)",
		    	base, Range.expand(example1, 0.5, 0.5));
	}
	
	@Test
	public void testLowerGreaterThanUpper() {
		assertEquals("The Range should be (-6,6)",
		    	base2, Range.expand(example2, -2, 0));
	}
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
