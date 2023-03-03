package org.jfree.data.RangeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeTestCentralValue {
	private Range base1;
    private Range example1;
    private Range example2;

    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

	//setting up Range objects for eqv class
    @Before
    public void setUp() throws Exception { 
    	
    	example1 = new Range(4.0, 7.0);
    	example2 = new Range(4.5, 7.5);

    }
    
    @Test
    public void integerArgument() {
    	
    	double a = 4/2 + 7/2;
    	assertTrue("should return 5.5 ",5.5 == example1.getCentralValue());

    }
    @Test
public void doubleArgument() {
    	
    	double a = 4.5/2 + 7.5/2;
    	assertTrue("should return 6 ", 6.0 == example2.getCentralValue());

    }
    
    
    
}
