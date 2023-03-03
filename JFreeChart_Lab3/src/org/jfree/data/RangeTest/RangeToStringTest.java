package org.jfree.data.RangeTest;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeToStringTest {

	Range exampleRange;
    private Range example2;
    private Range example3;
    private Range example4;
    private Range example5;
    private Range example6;
    private Range example7;


	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-1, 1);
		example2 = new Range(1,2);
		example3 = new Range(0,0);
    	example4 = new Range(Double.MIN_VALUE, 1);
    	example5 = new Range(0.0, Double.MAX_VALUE);
    	example6 = new Range(0.0, Double.MIN_VALUE);
    	example7 = new Range(-5, 0);
	}

	@Test
	public void testToString() {
    	assertEquals("ToString should return: \"Range[-1.0,1.0]\"", "Range[-1.0,1.0]", exampleRange.toString());
	}
	
	@Test
	public void testToString12() {
    	assertEquals("ToString should return: \"Range[1.0,2.0]\"", "Range[1.0,2.0]", example2.toString());
	}
	
	@Test
	public void testToString00() {
    	assertEquals("ToString should return: \"Range[0.0,0.0]\"", "Range[0.0,0.0]", example3.toString());
	}
	
    //@Test
    //public void testToStringMIN() {
    //	assertEquals("ToString should return: \"Range[,]\"", "Range[4.9E-324,1]", example4.toString());
    //}
    
    @Test
    public void testToStringMAX() {
    	assertEquals("ToString should return: \"Range[,]\"", "Range[0.0,1.7976931348623157E308]", example5.toString());
    }
    
    @Test
    public void testToString0toMIN() {
    	assertEquals("ToString should return: \"Range[1,4.9E-324]\"", "Range[0.0,4.9E-324]", example6.toString());
    }
    
	@Test
	public void testToStringN50() {
    	assertEquals("ToString should return: \"Range[-5.0,0.0]\"", "Range[-5.0,0.0]", example7.toString());
	}
	


}
