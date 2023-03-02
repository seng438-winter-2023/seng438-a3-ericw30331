package org.jfree.data.DataUtilitiesTest;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.Before;
import org.junit.Test;

public class equalTest extends DataUtilities {
	private double twobytwoArr[][] = new double [2][2];
	private double twobytwoArr2[][] = new double [2][2];
	private double twobythreeArr[][] = new double[2][3];
	private double threebytwoArr[][] = new double[3][2];
	
	private double emptyArr [][] = {{}};
	private double emptyArr2 [][] = {{}};
	
	@Test //test for equal(double[][] a, double[][] b) using two empty arrays
	public void TwoEmptyArrays() { 
		boolean result = DataUtilities.equal(emptyArr, emptyArr2);
		assertTrue("Using two equal empty arrays should return true",result);
	}
	@Test //test for equal(double[][] a, double[][] b) with null array as first argument
	public void FirstNullArray() {
		boolean result = DataUtilities.equal(null, emptyArr2);
		assertFalse("Using null array as first argument should be false",result);
	}
	@Test //test for equal(double[][] a, double[][] b) with null array as second argument
	public void SecondNullArray() {
		boolean result = DataUtilities.equal(emptyArr,null);
		assertFalse("Using null array as second argument should be false",result);
	}
	@Test //test for equal(double[][] a, double[][] b) with both arrays null
	public void BothNullArrays() {
		boolean result = DataUtilities.equal(null,null);
		assertTrue("Using null array as both arguments should be true",result);
	}
	@Before //setup for two arrays with different column length
	public void setUpDifferentColumnLength() throws Exception{
		twobytwoArr[0][0] = 0.0;
		twobytwoArr[0][1] = -4.0;
		
		twobytwoArr[1][0] = -8.3;
		twobytwoArr[1][1] = 21.4;

		
		twobythreeArr[0][0] = 0.0;
		twobythreeArr[0][1] = -4.0;
		twobythreeArr[0][2] = -1.0;
		
		twobythreeArr[1][0] = -8.3;
		twobythreeArr[1][1] = 21.4;
		twobythreeArr[1][2] = 5.5;
	}
	@Test //test for equal(double[][] a, double[][] b) with arrays of different row length
	public void differentColumnLength() {
		boolean result = DataUtilities.equal(twobytwoArr,twobythreeArr);
		assertFalse("Using different column length arrays should be false",result);
	}
	@Before //setup for two arrays with different row length
	public void setUpDifferentRowLength() throws Exception{
		twobytwoArr[0][0] = 0.0;
		twobytwoArr[0][1] = -4.0;
		
		twobytwoArr[1][0] = -8.3;
		twobytwoArr[1][1] = 21.4;

		
		threebytwoArr[0][0] = 0.0;
		threebytwoArr[0][1] = -4.0;
		
		threebytwoArr[1][0] = -8.3;
		threebytwoArr[1][1] = 21.4;
		
		threebytwoArr[2][0] = -1.0;
		threebytwoArr[2][1] = 5.5;
	}
	@Test //test for equal(double[][] a, double[][] b) with arrays of different row length
	public void differentRowLength() {
		boolean result = DataUtilities.equal(twobytwoArr,threebytwoArr);
		assertFalse("Using different row length arrays should be false",result);
	}
	@Before //setup for two non equal arrays of same size
	public void setUpTwoNonEqual() throws Exception{
		twobytwoArr[0][0] = 0.0;
		twobytwoArr[0][1] = -4.0;
		
		twobytwoArr[1][0] = -8.3;
		twobytwoArr[1][1] = 21.4;

		twobytwoArr2[0][0] = 0.0;
		twobytwoArr2[0][1] = 4.0;
		
		twobytwoArr2[1][0] = 8.3;
		twobytwoArr2[1][1] = 21.4;
		
	}
	@Test //test for equal(double[][] a, double[][] b) with two non equal arrays of the same size
	public void twoNonEqual() {
		boolean result = DataUtilities.equal(twobytwoArr,twobytwoArr2);
		assertFalse("Using two non equal arrays of the same size should return false",result);
	}
	@Before //setup for two  equal arrays of same size
	public void setUpTwoEqual() throws Exception{
		twobytwoArr[0][0] = 0.0;
		twobytwoArr[0][1] = -4.0;
		
		twobytwoArr[1][0] = -8.3;
		twobytwoArr[1][1] = 21.4;

		twobytwoArr2[0][0] = 0.0;
		twobytwoArr2[0][1] = -4.0;
		
		twobytwoArr2[1][0] = -8.3;
		twobytwoArr2[1][1] = 21.4;
		
	}
	@Test //test for equal(double[][] a, double[][] b) with two equal arrays of the same size
	public void twoEqual() {
		boolean result = DataUtilities.equal(twobytwoArr,twobytwoArr2);
		assertTrue("Using two equal arrays of the same size should return true",result);
	}
	
}
