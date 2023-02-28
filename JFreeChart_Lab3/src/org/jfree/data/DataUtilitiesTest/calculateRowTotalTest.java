package org.jfree.data.DataUtilitiesTest;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class calculateRowTotalTest extends DataUtilities {
	/* 
	 * Create mocking objects for values2D objects
	 */

	private Mockery mockingFilled = new Mockery(); //mock for table filled with values
	private final Values2D FilledColumns = mockingFilled.mock(Values2D.class);
	private Mockery mockingNull = new Mockery(); //mock for table filled with null values
	private final Values2D NullColumns = mockingNull.mock(Values2D.class);
	private Mockery mockingNoColumns = new Mockery(); //mock for empty table
	private final Values2D NoColumns = mockingNoColumns.mock(Values2D.class);
	private Mockery mockingNegativeRow = new Mockery(); //mock for negative row
	private final Values2D NegativeRow = mockingNegativeRow.mock(Values2D.class);

	@Before //set up data with negative row and filled table
	public void setUpNegativeRow() throws Exception{
		  mockingNegativeRow.checking(new Expectations() { //fill mock with values
			  {
		            one(NegativeRow).getColumnCount(); //one call of getColumnCount() returns value of 4
		            will(returnValue(4));
		            one(NegativeRow).getRowCount(); //one call of getRowCount() returns value of -1
		            will(returnValue(-1));
		            /*
		             * Calls to fill values of 4 rows in negative row
		             */
		            one(NegativeRow).getValue(-1,0); 
		            will(returnValue(-9.0));
		            one(NegativeRow).getValue(-1,1);
		            will(returnValue(7.5));
		            one(NegativeRow).getValue(-1,2);
		            will(returnValue(-5.0));
		            one(NegativeRow).getValue(-1,3);
		            will(returnValue(25.0));
		        }
		    });
	}
	
	@Test (expected = InvalidParameterException.class)
	public void negativeRowFilled() { // test for method calculateRowTotal(Values2D data,int row) with negative row and filled values
		 DataUtilities.calculateRowTotal(NegativeRow, -1);
	}

	
	
	@Before //set up data table column with valid values
	public void setUpFilledColumns() throws Exception{ 
	    mockingFilled.checking(new Expectations() { //fill mock with values
	        {
	            one(FilledColumns).getColumnCount(); //one call of getColumnCount() returns value of 4, for 4 columns
	            will(returnValue(4));
	            one(FilledColumns).getRowCount();
	            will(returnValue(1));
	            /*
	             * Calls to fill values of 4 columns in the first row of the table
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

	@Test 	// test for method calculateRowTotal(Values2D data,int row) using valid data table
	// and row with valid values
	public void calculateValidColumns(){
		
	   	double result = DataUtilities.calculateRowTotal(FilledColumns, 0);
	   	assertEquals("calculateRowTotal for row with valid values , outputs incorrect result",18.5,result, .000000001d);
	   
	}
	@Before //setting up empty data table with no columns or Columns
	public void setUpNoColumns() throws Exception{
		mockingNoColumns.checking(new Expectations() { //create mock for empty table
	        {
	            one(NoColumns).getColumnCount(); //one call to getColumnCount returns 0 (no columns)
	            will(returnValue(0));
	            
	            one(NoColumns).getRowCount(); //one call to getRowCount returns 0 (no rows)
	            will(returnValue(0));

	        }
	    });
	}
	@Test //test for method calculateRowTotal(Values2D data, int row) using empty table as data
	public void calculateNoColumns() {
		double result = DataUtilities.calculateRowTotal(NoColumns, 0);
		assertEquals("calculateRowTotal for no Columns (empty table), outputs incorrect result",0,result,.000000001d);
	}
	@Before //set up data table with empty column with null values
	public void setUpInvalidColumns() throws Exception{ 
	    mockingNull.checking(new Expectations() { //fill row with null values
	        {
	            one(NullColumns).getColumnCount(); //one call of getColumnCount() returns value of 4, for 4 columns
	            will(returnValue(4));
	            one(NullColumns).getRowCount();
	            will(returnValue(1));
	        	/*
	        	 * Calls to fill columns of row 0 with null values
	        	 */
	            one(NullColumns).getValue(0, 0);
	            will(returnValue(null));
	            one(NullColumns).getValue(0, 1);
	            will(returnValue(null));
	            one(NullColumns).getValue(0, 2);
	            will(returnValue(null));
	            one(NullColumns).getValue(0, 3);
	            will(returnValue(null));
	        }
	    });
	}
	@Test
	public void calculateInvalidColumn() {
		double result = DataUtilities.calculateRowTotal(NullColumns, 0);
		assertEquals("calculateRowTotal for null Columns, outputs incorrect result",0,result,.000000001d);
	}
	
	// test for null object as data variable in method calculateRowTotal(Values2D data,int row)
	@Test
	public void nullObjectTest() {
		try {
			DataUtilities.calculateRowTotal(null, 0);
		}
		catch(Exception e) {
			assertEquals("InvalidParameterException not thrown with null data object for calculateRowTotal function",InvalidParameterException.class,e.getClass());
		}
	}
	@Before
	public void setUpBoundary() throws Exception{ 
	    mockingFilled.checking(new Expectations() { //set row and column boundaries
	        {
	            one(FilledColumns).getColumnCount(); //one call of getColumnCount() returns value of 4, for 4 rows
	            will(returnValue(4));
	            one(FilledColumns).getRowCount();
	            will(returnValue(1));
	        }
	        });
	    }
	@Test
	public void calculateOutOfBoundsRow() { //test accessing row out of bounds of table
		try {
			DataUtilities.calculateRowTotal(null, 2);
		}catch(Exception e) {
			assertEquals("InvalidParameterException not thrown with out of bounds row accessed for calculateRowTotal function",InvalidParameterException.class,e.getClass());
		}
	}
	// test for negative value for row variable in method calculateRowTotal(Values2D data,int row)
	@Test(expected= InvalidParameterException.class)
	public void negativeRowTest() {
		DataUtilities.calculateRowTotal(NoColumns, 1);
	}
	
	
}
