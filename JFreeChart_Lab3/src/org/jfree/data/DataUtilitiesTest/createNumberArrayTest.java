package org.jfree.data.DataUtilitiesTest;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.Test;

import org.junit.*;

public class createNumberArrayTest extends DataUtilities {
	
	private double mixedArr [] = new double[4];
	private Number mixednumArr[] = new Number[4];
	
	private double posArr [] = new double[4];
	private Number posnumArr[] = new Number[4];
	
	private double negArr [] = new double[4];
	private Number negnumArr[] = new Number[4];
	private double emptyArr[] = {};
	private Number emptyNumArr[] = {};

	@Test //test with empty double array entered as argument for function createNumberArray(double[] data)
	public void createEmptyNumberArray() {
		Number [] result = DataUtilities.createNumberArray(emptyArr);
		assertArrayEquals("Empty Number array created is not the same as empty double array",emptyNumArr,result);
	}
	@Before //setup for array full of only negative double values to use as argument
	// Number array of the same values to compare to final result
	public void setUpNegativeArray() throws Exception{
		negArr[0] = -1.0;
		negArr[1] = -4.0;
		negArr[2] = -8.0;
		negArr[3] = -21.0;
		
		negnumArr[0] = -1.0;
		negnumArr[1] = -4.0;
		negnumArr[2] = -8.0;
		negnumArr[3] = -21.0;
	}
	@Test //test with fully filled array of only negative double values as an argument for function createNumberArray(double[] data)
	public void createNegativeNumberArray() { 
		Number [] result = DataUtilities.createNumberArray(negArr);
		assertArrayEquals("Number array created is not the same as double array with negative values",negnumArr,result);
	}
	@Before //setup for array full of only positive double values to use as argument
	// Number array of the same values to compare to final result
	public void setUpPositiveArray() throws Exception{
		posArr[0] = 0.0;
		posArr[1] = 4.0;
		posArr[2] = 8.0;
		posArr[3] = 21.0;
		
		posnumArr[0] = 0.0;
		posnumArr[1] = 4.0;
		posnumArr[2] = 8.0;
		posnumArr[3] = 21.0;
	}
	@Test //test with fully filled array of only positive double values as an argument for function createNumberArray(double[] data)
	public void createPositiveNumberArray() { 
		Number [] result = DataUtilities.createNumberArray(posArr);
		assertArrayEquals("Number array created is not the same as double array with positive values",posnumArr,result);
	}
	@Before //setup for array full of mixed positive and negative double values to use as argument
	// Number array of the same values to compare to final result
	public void setUpMixedArray() throws Exception{
		mixedArr[0] = 0.0;
		mixedArr[1] = -4.0;
		mixedArr[2] = -8.0;
		mixedArr[3] = 21.0;
		
		mixednumArr[0] = 0.0;
		mixednumArr[1] = -4.0;
		mixednumArr[2] = -8.0;
		mixednumArr[3] = 21.0;
	}
	@Test //test with fully filled array of mixed positive and negative double values as an argument for function createNumberArray(double[] data)
	public void createMixedNumberArray() { 
		Number [] result = DataUtilities.createNumberArray(mixedArr);
		assertArrayEquals("Number array created is not the same as double array with mixed positive and negative",mixednumArr,result);
	}
	//test with null value entered as double array for function createNumberArray(double[] data)
	@Test
	public void nullArrayTest() {
		try {
		DataUtilities.createNumberArray(null);
		}
		catch(Exception e) {
			assertEquals("InvalidParameterException not thrown with null data array for createNumberArray function",InvalidParameterException.class,e.getClass());
		}
	}
}
