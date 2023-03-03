package org.jfree.data.RangeTest;

import static org.junit.Assert.assertEquals;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeHashCodeTest {
	private Range base1;
    private Range example1;
    private Range example2;

    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

	//setting up Range objects for eqv class
    @Before
    public void setUp() throws Exception { 
    	
    	base1 = new Range(1, 5);
    	example1 = new Range(3,7);
    	example2 = new Range(-6,-3);
    }
    
    
    @Test
    public void testLowerBoudShift() {
    	long funcTemp = Double.doubleToLongBits(base1.getLowerBound());
    	int a =(int) (funcTemp ^ (funcTemp >>> 32));
    	
    	long temp = Double.doubleToLongBits(1);
    	int b =(int) (temp ^ (temp >>> 32));
    	
        
    	
    	assertEquals("should return the same value",a,b);

    }
    
    
    @Test
    public void testHashCode() {
    	int a = base1.hashCode();
    	
    	int result;
        long temp;
        temp = Double.doubleToLongBits(1);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(5);
        result = 29 * result + (int) (temp ^ (temp >>> 32));
    	
        
    	
    	assertEquals("should return the same value",a,result);

    }
    
}
