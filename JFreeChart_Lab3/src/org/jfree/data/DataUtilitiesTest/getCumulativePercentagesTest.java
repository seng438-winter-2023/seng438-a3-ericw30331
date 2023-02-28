package org.jfree.data.DataUtilitiesTest;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import org.junit.*;

public class getCumulativePercentagesTest extends DataUtilities {
	/* 
	 * Create mocking objects for KeyedValues objects
	 */
	private Mockery mockingValidKeyed = new Mockery(); //mock for keyedvalues object filled with valid values
	private final KeyedValues ValidKeyed = mockingValidKeyed.mock(KeyedValues.class);
	private Mockery mockingValidResult = new Mockery(); //mock for keyedvalues object filled with correct output
	private final KeyedValues ValidResult = mockingValidResult.mock(KeyedValues.class);
	private Mockery mockingEmptyKeyed = new Mockery(); //mock for empty keyedvalues object 
	private final KeyedValues EmptyKeyed = mockingEmptyKeyed.mock(KeyedValues.class);
	private Mockery mockingNullKeyed = new Mockery(); //mock for keyedvalues object filled with null values
	private final KeyedValues NullKeyed = mockingNullKeyed.mock(KeyedValues.class);
	
		
	
	@Before //setup for valid key values Keys: {0,1,2} and Values: {1,13,6}
	//setup keyedvalues object with correct calculated cumulativepercentages
	public void setUpValidKeyedValues() throws Exception{
		mockingValidKeyed.checking(new Expectations() { //fill mock with valid values
	        {
	        	atLeast(1).of(ValidKeyed).getItemCount(); //Item count is set to 3
	            will(returnValue(3));
	            atLeast(1).of(ValidKeyed).getKey(0); //set at index 0 to 0
	            will(returnValue(0));
	            atLeast(1).of(ValidKeyed).getValue(0); //set value of key 0 to 1
	            will(returnValue(1));
	            atLeast(1).of(ValidKeyed).getKey(1);
	            will(returnValue(1));
	            atLeast(1).of(ValidKeyed).getValue(1);
	            will(returnValue(13));
	            atLeast(1).of(ValidKeyed).getKey(2);
	            will(returnValue(2));
	            atLeast(1).of(ValidKeyed).getValue(2);
	            will(returnValue(6));
	      
	        }
	    });
		mockingValidResult.checking(new Expectations() { //create the mock of the correct output
	        {
	        	 
	        	atLeast(1).of(ValidResult).getItemCount();//Item count is set to 3
	            will(returnValue(3));
	            atLeast(1).of(ValidResult).getKey(0); //set at index 0 to 0
	            will(returnValue(0));
	            atLeast(1).of(ValidResult).getValue(0); //set value of key 0 to 1/20.0
	            will(returnValue(1/20.0));
	            atLeast(1).of(ValidResult).getKey(1);
	            will(returnValue(1));
	            atLeast(1).of(ValidResult).getValue(1);
	            will(returnValue(14/20.0));
	            atLeast(1).of(ValidResult).getKey(2);
	            will(returnValue(2));
	            atLeast(1).of(ValidResult).getValue(2);
	            will(returnValue(20/20.0));
	      
	        }
	    });
	}
	@Test //test with keyedvalues object with valid values as argument in function getCumulativePercentages(KeyedValues data)
	public void validKeyedValues() {
		KeyedValues result = getCumulativePercentages(ValidKeyed);
		assertTrue("Cumulative percentage is not calculated correctly for keyedvalues object with valid values",ValidResult.equals(result));
	}
	@Before //setup for empty keyedvalues object as argument in function getCumulativePercentages(KeyedValues data)
	public void setUpEmptyKeyedValues() throws Exception{
		mockingEmptyKeyed.checking(new Expectations() { //create emptykeyed values object
	        {
	        	atLeast(1).of(EmptyKeyed).getItemCount(); //set item count to 0
	            will(returnValue(0));        
	        }
	    });
	}
	@Test //test with empty keyedvalues object as argument in function getCumulativePercentages(KeyedValues data)
	public void emptyKeyedValues() {
		KeyedValues result = getCumulativePercentages(EmptyKeyed);
		assertTrue("Cumulative percentage is not calculated correctly for empty keyedvaluesobject",EmptyKeyed.equals(result));
	}
	@Before //setup for keyedvalues object with null values filled
	public void setUpNullKeyedValues() throws Exception{
		mockingNullKeyed.checking(new Expectations() { //create keyedvalues object with null values
	        {
	        	atLeast(1).of(NullKeyed).getItemCount(); //set item count to 3
	            will(returnValue(3));  
	            atLeast(1).of(NullKeyed).getKey(0); //set at index 0 to 0
	            will(returnValue(0));
	            atLeast(1).of(NullKeyed).getValue(0); //set value of key 0 to null
	            will(returnValue(null));
	            atLeast(1).of(NullKeyed).getKey(1);
	            will(returnValue(1));
	            atLeast(1).of(NullKeyed).getValue(1);
	            will(returnValue(null));
	            atLeast(1).of(NullKeyed).getKey(2);
	            will(returnValue(2));
	            atLeast(1).of(NullKeyed).getValue(2);
	            will(returnValue(null));
	        }
	    });
	}
	@Test //test with keyedvalues object with null values as argument in function getCumulativePercentages(KeyedValues data)
	public void nullFilledKeyedValues() {
		KeyedValues result = getCumulativePercentages(NullKeyed);
		assertTrue("Cumulative percentage is not calculated correctly for empty keyedvaluesobject",NullKeyed.equals(result));
	}
	//test with null object entered as argument in function getCumulativePercentages(KeyedValues data)
	@Test
	public void nullKeyedValues() throws Exception{
		try {
			DataUtilities.getCumulativePercentages(null);
			}
			catch(Exception e) {
				assertEquals("InvalidParameterException not thrown with null keyedvalues data object for getCumulativePercentages function",InvalidParameterException.class,e.getClass());
			}

	}

}
