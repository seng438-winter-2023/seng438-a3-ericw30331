package org.jfree.data.DataUtilitiesTest;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class calculateRowTotalTest2 extends DataUtilities {
	private int emptyValid [] = {};
	private int threeValid [] = new int [3];
	private int oneInvalid [] = new int [3];
	private Mockery mockingFilled = new Mockery(); //mock for table filled with mixed positive and negative values
	private final Values2D FilledColumns = mockingFilled.mock(Values2D.class);
	private Mockery mockingNoColumns = new Mockery(); //mock for empty table
	private final Values2D NoColumns = mockingNoColumns.mock(Values2D.class);
	
	@Test //test for calculateRowTotal(Values2D data, int column, int[] validColumns) with null data
	public void nullDataTest() {
		try {
			DataUtilities.calculateRowTotal(null,0,emptyValid);
		}
		catch(Exception e) {
			assertEquals("null data should throw invalidparameterexception",InvalidParameterException.class,e.getClass());
		}
	}
	@Before //setup for three valid columns in column range with fully filled table
	public void setUpValidFullData() throws Exception{
		threeValid[0] = 0;
		threeValid[1] = 1;
		threeValid[2] = 2;
		
		mockingFilled.checking(new Expectations() { //fill mock with mixed negative and positive values
	        {
	            one(FilledColumns).getColumnCount(); //one call of getColumnCount() returns value of 4, for 4 columns
	            will(returnValue(4));
	            one(FilledColumns).getColumnCount();
	            will(returnValue(1));
	            /*
	             * Calls to fill values of 4 rows in the first column of the table
	             */
	            one(FilledColumns).getValue(0, 0); 
	            will(returnValue(-9.0));
	            one(FilledColumns).getValue(0, 1);
	            will(returnValue(7.5));
	            one(FilledColumns).getValue(0, 2);
	            will(returnValue(-5.0));
	            one(FilledColumns).getValue(0, 3);
	            will(returnValue(25.0));
	        }
	    });
	}
	@Test 	// test for method  calculateRowTotal(Values2D data, int column, int[] validColumns)  using valid data table
	// and columns < columnCount of table.
	public void calculateValidRows(){
		
	   	double result = DataUtilities.calculateRowTotal(FilledColumns, 0,threeValid);
	   	assertEquals("calculateRowTotal for row with valid values , outputs incorrect result",-6.5,result, .000000001d);
	   
	}
	
	@Before //setup for one out of range column in validColumns with fully filled table
	public void setUpValidOutofColumnRangeData() throws Exception{
		oneInvalid[0] = 0;
		oneInvalid[1] = 1;
		oneInvalid[2] = 4;
		
		mockingFilled.checking(new Expectations() { //fill mock with mixed negative and positive values
	        {
	            one(FilledColumns).getColumnCount(); //one call of getColumnCount() returns value of 4, for 4 columns
	            will(returnValue(4));
	            one(FilledColumns).getColumnCount();
	            will(returnValue(1));
	            /*
	             * Calls to fill values of 4 rows in the first column of the table
	             */
	            one(FilledColumns).getValue(0, 0); 
	            will(returnValue(-9.0));
	            one(FilledColumns).getValue(0, 1);
	            will(returnValue(7.5));
	            one(FilledColumns).getValue(0, 2);
	            will(returnValue(-5.0));
	            one(FilledColumns).getValue(0, 3);
	            will(returnValue(25.0));
	        }
	    });
	}
	@Test 	// test for method  calculateRowTotal(Values2D data, int column, int[] validColumns)  using valid data table
	// and column >= columnCount of table.
	public void calculateOutofColumnRange(){
		
	   	double result = DataUtilities.calculateRowTotal(FilledColumns, 0,oneInvalid);
	   	assertEquals("calculateRowTotal for row with out of range column , outputs incorrect result",-1.5,result, .000000001d);
	   
	}
	
	@Before //setting up empty data table with no columns or rows
	public void setUpNoColumns() throws Exception{
		mockingNoColumns.checking(new Expectations() { //create mock for empty table
	        {
	            one(NoColumns).getRowCount(); //one call to getRowCount returns 0 (no rows)
	            will(returnValue(0));
	            
	            one(NoColumns).getColumnCount(); //one call to getColumnCount returns 0 (no columns)
	            will(returnValue(0));
	        }
	    });
	}
	@Test //test for method calculateRowTotal(Values2D data, int column, int[] validColumns) using empty table as data
	public void calculateNoColumns() {
		double result = DataUtilities.calculateRowTotal(NoColumns, 0);
		assertEquals("calculateRowTotal for no rows (empty table), outputs incorrect result",0,result,.000000001d);
	}

}
