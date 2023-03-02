package org.jfree.data.DataUtilitiesTest;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import java.util.Arrays;

import org.jfree.data.DataUtilities;
import org.junit.Before;
import org.junit.Test;

public class cloneTest extends DataUtilities {
	private double emptyArr [][] = {{}};
	private double filledArr [][] = new double [3][2];

	@Test
	//test clone(double[][] source) with null array as argument
	public void nullArray() {
		try {
			DataUtilities.clone(null);
		}
		catch(Exception e) {
			assertEquals(InvalidParameterException.class,e.getClass());
		}
	}
	
	@Test //test clone(double[][] source) with empty array as argument
	public void emptyArray() {
		double [][] result = DataUtilities.clone(emptyArr);
		assertTrue("cloning an empty array should return an equivalent array",Arrays.deepEquals(emptyArr,result));
	}
	@Before //setup for fully filled array
	public void setUpFilledArray() throws Exception{

		
		filledArr[0][0] = 0.0;
		filledArr[0][1] = 4.0;
		
		filledArr[1][0] = 8.3;
		filledArr[1][1] = 21.4;
		
		filledArr[2][0] = -1.0;
		filledArr[2][1] = -5.5;
		
	}
	@Test //test clone(double[][] source) with fully filled array as argument
	public void filledArray() {
		double [][] result = DataUtilities.clone(filledArr);
		assertTrue("cloning a fully filled array should return an equivalent array",Arrays.deepEquals(filledArr,result));
	}
}
