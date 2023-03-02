package org.jfree.data.DataUtilitiesTest;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class calculateColumnTotalTest2 extends DataUtilities {
	private int emptyValid [] = {};
	private int threeValid [] = new int [3];
	private int oneInvalid [] = new int [3];
	private Mockery mockingFilled = new Mockery(); //mock for table filled with mixed positive and negative values
	private final Values2D FilledRows = mockingFilled.mock(Values2D.class);
	private Mockery mockingNoRows = new Mockery(); //mock for empty table
	private final Values2D NoRows = mockingNoRows.mock(Values2D.class);
	
	@Test //test for calculateColumnTotal(Values2D data, int column, int[] validRows) with null data
	public void nullDataTest() {
		try {
			DataUtilities.calculateColumnTotal(null,0,emptyValid);
		}
		catch(Exception e) {
			assertEquals("null data should throw invalidparameterexception",InvalidParameterException.class,e.getClass());
		}
	}
	@Before //setup for three valid rows in row range with fully filled table
	public void setUpValidFullData() throws Exception{
		threeValid[0] = 0;
		threeValid[1] = 1;
		threeValid[2] = 2;
		
		mockingFilled.checking(new Expectations() { //fill mock with mixed negative and positive values
	        {
	            one(FilledRows).getRowCount(); //one call of getRowCount() returns value of 4, for 4 rows
	            will(returnValue(4));
	            one(FilledRows).getColumnCount();
	            will(returnValue(1));
	            /*
	             * Calls to fill values of 4 rows in the first column of the table
	             */
	            one(FilledRows).getValue(0, 0); 
	            will(returnValue(-9.0));
	            one(FilledRows).getValue(1, 0);
	            will(returnValue(7.5));
	            one(FilledRows).getValue(2, 0);
	            will(returnValue(-5.0));
	            one(FilledRows).getValue(3, 0);
	            will(returnValue(25.0));
	        }
	    });
	}
	@Test 	// test for method  calculateColumnTotal(Values2D data, int column, int[] validRows)  using valid data table
	// and rows < rowCount of table.
	public void calculateValidRows(){
		
	   	double result = DataUtilities.calculateColumnTotal(FilledRows, 0,threeValid);
	   	assertEquals("calculateColumnTotal for column with valid values , outputs incorrect result",-6.5,result, .000000001d);
	   
	}
	
	@Before //setup for one out of range row in validrows with fully filled table
	public void setUpValidOutofRowRangeData() throws Exception{
		oneInvalid[0] = 0;
		oneInvalid[1] = 1;
		oneInvalid[2] = 4;
		
		mockingFilled.checking(new Expectations() { //fill mock with mixed negative and positive values
	        {
	            one(FilledRows).getRowCount(); //one call of getRowCount() returns value of 4, for 4 rows
	            will(returnValue(4));
	            one(FilledRows).getColumnCount();
	            will(returnValue(1));
	            /*
	             * Calls to fill values of 4 rows in the first column of the table
	             */
	            one(FilledRows).getValue(0, 0); 
	            will(returnValue(-9.0));
	            one(FilledRows).getValue(1, 0);
	            will(returnValue(7.5));
	            one(FilledRows).getValue(2, 0);
	            will(returnValue(-5.0));
	            one(FilledRows).getValue(3, 0);
	            will(returnValue(25.0));
	        }
	    });
	}
	@Test 	// test for method  calculateColumnTotal(Values2D data, int column, int[] validRows)  using valid data table
	// and rows >= rowCount of table.
	public void calculateOutofRowRange(){
		
	   	double result = DataUtilities.calculateColumnTotal(FilledRows, 0,oneInvalid);
	   	assertEquals("calculateColumnTotal for column with out of range row , outputs incorrect result",-1.5,result, .000000001d);
	   
	}
	
	@Before //setting up empty data table with no columns or rows
	public void setUpNoRows() throws Exception{
		mockingNoRows.checking(new Expectations() { //create mock for empty table
	        {
	            one(NoRows).getRowCount(); //one call to getRowCount returns 0 (no rows)
	            will(returnValue(0));
	            
	            one(NoRows).getColumnCount(); //one call to getColumnCount returns 0 (no columns)
	            will(returnValue(0));
	        }
	    });
	}
	@Test //test for method calculateColumnTotal(Values2D data, int column, int[] validRows) using empty table as data
	public void calculateNoRows() {
		double result = DataUtilities.calculateColumnTotal(NoRows, 0);
		assertEquals("calculateColumnTotal for no rows (empty table), outputs incorrect result",0,result,.000000001d);
	}

}
