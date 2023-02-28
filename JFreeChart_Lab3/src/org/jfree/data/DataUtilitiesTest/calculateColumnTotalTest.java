package org.jfree.data.DataUtilitiesTest;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.*;
import org.junit.*;

public class calculateColumnTotalTest extends DataUtilities {

	/* 
	 * Create mocking objects for values2D objects
	 */
	private Mockery mockingFilled = new Mockery(); //mock for table filled with values
	private final Values2D FilledRows = mockingFilled.mock(Values2D.class);
	private Mockery mockingNull= new Mockery(); //mock for table filled with null values
	private final Values2D NullRows = mockingNull.mock(Values2D.class);
	private Mockery mockingNoRows = new Mockery(); //mock for empty table
	private final Values2D NoRows = mockingNoRows.mock(Values2D.class);
	private Mockery mockingNegativeColumn = new Mockery(); //mock for negative column
	private final Values2D NegativeColumn = mockingNegativeColumn.mock(Values2D.class);

	@Before //set up data with negative column and filled table
	public void setUpNegativeColumn() throws Exception{
		  mockingNegativeColumn.checking(new Expectations() { //fill mock with values
			  {
		            one(NegativeColumn).getRowCount(); //one call of getRowCount() returns value of 4
		            will(returnValue(4));
		            one(NegativeColumn).getColumnCount(); //one call of getColumnCount() returns value of -1
		            will(returnValue(-1));
		            /*
		             * Calls to fill values of 4 rows in negative column
		             */
		            one(NegativeColumn).getValue(0, -1); 
		            will(returnValue(-9.0));
		            one(NegativeColumn).getValue(1, -1);
		            will(returnValue(7.5));
		            one(NegativeColumn).getValue(2, -1);
		            will(returnValue(-5.0));
		            one(NegativeColumn).getValue(3, -1);
		            will(returnValue(25.0));
		        }
		    });
	}
	
	@Test (expected = InvalidParameterException.class)
	public void negativeColumnFilled() { // test for method calculateColumnTotal(Values2D data,int column) with negative columns and filled values
		 DataUtilities.calculateColumnTotal(NegativeColumn, -1);
		
		
	}
	@Before //set up data table column with valid values
	public void setUpFilledRows() throws Exception{ 
	    mockingFilled.checking(new Expectations() { //fill mock with values
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

	@Test 	// test for method calculateColumnTotal(Values2D data,int column) using valid data table
	// and column with valid values
	public void calculateValidRows(){
		
	   	double result = DataUtilities.calculateColumnTotal(FilledRows, 0);
	   	assertEquals("calculateColumnTotal for column with valid values , outputs incorrect result",18.5,result, .000000001d);
	   
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
	@Test //test for method calculateColumnTotal(Values2D data, int column) using empty table as data
	public void calculateNoRows() {
		double result = DataUtilities.calculateColumnTotal(NoRows, 0);
		assertEquals("calculateColumnTotal for no rows (empty table), outputs incorrect result",0,result,.000000001d);
	}
	@Before //set up data table with empty column with null values
	public void setUpInvalidRows() throws Exception{ 
	    mockingNull.checking(new Expectations() { //fill column with null values
	        {
	        	one(NullRows).getRowCount();
	        	will(returnValue(4));
	        	one(NullRows).getColumnCount();
	        	will(returnValue(1));
	        	/*
	        	 * Calls to fill rows of column 0 with null values
	        	 */
	        
	            one(NullRows).getValue(0, 0);
	            will(returnValue(null));
	            one(NullRows).getValue(1, 0);
	            will(returnValue(null));
	            one(NullRows).getValue(2, 0);
	            will(returnValue(null));
	            one(NullRows).getValue(3, 0);
	            will(returnValue(null));
	        }
	    });
	}
	
	@Test
	public void calculateInvalidRow() {
		double result = DataUtilities.calculateColumnTotal(NullRows, 0);
		assertEquals("calculateColumnTotal for null rows, outputs incorrect result",0,result,.000000001d);
	}
	@Before
	public void setUpBoundary() throws Exception{ 
	    mockingFilled.checking(new Expectations() { //set row and column boundaries
	        {
	            one(FilledRows).getRowCount(); //one call of getRowCount() returns value of 4, for 4 rows
	            will(returnValue(4));
	            one(FilledRows).getColumnCount();
	            will(returnValue(1));
	        }
	        });
	    }
	@Test
	public void calculateOutOfBoundsColumn() { //test accessing column out of bounds of table
		try {
			DataUtilities.calculateColumnTotal(null, 2);
		}catch(Exception e) {
			assertEquals("InvalidParameterException not thrown with out of bounds column accessed for calculateColumnTotal function",InvalidParameterException.class,e.getClass());
		}
	}
	// test for null object as data variable in method calculateColumnTotal(Values2D data,int column)
	@Test
	public void nullObjectTest() {
		try {
			DataUtilities.calculateColumnTotal(null, 0);
		}catch(Exception e) {
			assertEquals("InvalidParameterException not thrown with null data object for calculateColumnTotal function",InvalidParameterException.class,e.getClass());
		}
	}
	
	// test for negative value for column variable and empty table in method calculateColumnTotal(Values2D data,int column)
	@Test(expected= InvalidParameterException.class)
	public void negativeColumnEmpty() {
			DataUtilities.calculateColumnTotal(NoRows, -1);
	}
}
