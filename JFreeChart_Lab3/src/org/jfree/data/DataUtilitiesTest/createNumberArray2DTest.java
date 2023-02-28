package org.jfree.data.DataUtilitiesTest;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.Before;
import org.junit.Test;

public class createNumberArray2DTest extends DataUtilities {
	private double mixedArr [][] = new double[3][2];
	private Number mixednumArr[][] = new Number[3][2];
	private double posArr[][] = new double[3][2];
	private Number posnumArr[][] = new Number[3][2];
	private double negArr[][] = new double[3][2];
	private Number negnumArr[][] = new Number[3][2];
	private double emptyArr [][] = {{}};
	private Number emptyNumArr[][] = {{}};
	
	@Before //setup for 2d array full of negative double values to use as argument
	// 2d Number array of the same values to compare to final result
	public void setUpNegativeArray2D() throws Exception{
		negArr[0][0] = -1.0;
		negArr[0][1] = -4.0;
		
		negArr[1][0] = -8.3;
		negArr[1][1] = -21.4;
		
		negArr[2][0] = -1.0;
		negArr[2][1] = -5.5;
		
		negnumArr[0][0] = -1.0;
		negnumArr[0][1] = -4.0;
		
		negnumArr[1][0] = -8.3;
		negnumArr[1][1] = -21.4;
		
		negnumArr[2][0] = -1.0;
		negnumArr[2][1] = -5.5;
		
		
		
	}
	@Test //test with fully filled 2d array of positive double values as an argument for function createNumberArray2D(double[][] data)
	public void createNegativeNumberArray2D() { 
		Number [] []result = DataUtilities.createNumberArray2D(negArr);
		assertArrayEquals("Number array 2d created is not the same as double array 2d for negative only values",negnumArr,result);
	}
	@Before //setup for 2d array full of positive double values to use as argument
	// 2d Number array of the same values to compare to final result
	public void setUpPositiveArray2D() throws Exception{
		posArr[0][0] = 0.0;
		posArr[0][1] = 4.0;
		
		posArr[1][0] = 8.3;
		posArr[1][1] = 21.4;
		
		posArr[2][0] = 1.0;
		posArr[2][1] = 5.5;
		
		posnumArr[0][0] = 0.0;
		posnumArr[0][1] = 4.0;
		
		posnumArr[1][0] = 8.3;
		posnumArr[1][1] = 21.4;
		
		posnumArr[2][0] = 1.0;
		posnumArr[2][1] = 5.5;
		
		
		
	}
	@Test //test with fully filled 2d array of positive double values as an argument for function createNumberArray2D(double[][] data)
	public void createPositiveNumberArray2D() { 
		Number [] []result = DataUtilities.createNumberArray2D(posArr);
		assertArrayEquals("Number array 2d created is not the same as double array 2d for positive only values",posnumArr,result);
	}
	@Test //test with empty 2d double array entered as argument for function createNumberArray2D(double[][] data)
	public void createEmptyNumberArray2D() {
		Number [] []result = DataUtilities.createNumberArray2D(emptyArr);
		assertArrayEquals("Number array 2d created is not the same as double array 2d",emptyNumArr,result);
	}
	@Before //setup for 2d array full of mixed positive and negative double values to use as argument
	// 2d Number array of the same values to compare to final result
	public void setUpMixedArray2D() throws Exception{
		mixedArr[0][0] = 0.0;
		mixedArr[0][1] = 4.0;
		
		mixedArr[1][0] = 8.3;
		mixedArr[1][1] = 21.4;
		
		mixedArr[2][0] = -1.0;
		mixedArr[2][1] = -5.5;
		
		mixednumArr[0][0] = 0.0;
		mixednumArr[0][1] = 4.0;
		
		mixednumArr[1][0] = 8.3;
		mixednumArr[1][1] = 21.4;
		
		mixednumArr[2][0] = -1.0;
		mixednumArr[2][1] = -5.5;
		
		
		
	}
	@Test //test with fully filled 2d array of mixed positive and negative double values as an argument for function createNumberArray2D(double[][] data)
	public void createMixedNumberArray2D() { 
		Number [] []result = DataUtilities.createNumberArray2D(mixedArr);
		assertArrayEquals("Number array 2d created is not the same as double array 2d with mixed positive and negative numbers",mixednumArr,result);
	}
	//test with null value entered as 2d double array for function createNumberArray2D(double[][] data)
	@Test
	public void nullArray2DTest() {
		try {
			DataUtilities.createNumberArray2D(null);
			}
			catch(Exception e) {
				assertEquals("InvalidParameterException not thrown with null 2d data array for createNumberArray2D function",InvalidParameterException.class,e.getClass());
			}

	}
}
