package org.jfree.data.RangeTest;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;


public class RangeContainsTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }
    
  @Before
  public void setUpContainsValud() throws Exception { exampleRange = new Range(-10, 10);
  }


  @Test
  public void ContainValid() {
      assertTrue("0 should be contained in range -10 to 10",
      exampleRange.contains(0));
  }
  
  @Before
  public void setUpContainsValidUpper() throws Exception { exampleRange = new Range(-10, 10);
  }


  @Test
  public void ContainValidUpper() {
      assertTrue("10 should be contained in range -10 to 10",
      exampleRange.contains(10));
  }
  @Before
  public void setUpContainsValidLower() throws Exception { exampleRange = new Range(-10, 10);
  }


  @Test
  public void ContainValidLower() {
      assertTrue("-10 should be contained in range -10 to 10",
      exampleRange.contains(-10));
  }
  
  @Before
  public void setUpContainsInValidLower() throws Exception { exampleRange = new Range(-10, 10);
  }


  @Test
  public void ContainInValidLower() {
      assertFalse("-15 should not be contained in range -10 to 10",
      exampleRange.contains(-15));
  }
  
  
  @Before
  public void setUpContainsInValidUpper() throws Exception { exampleRange = new Range(-10, 10);
  }


  @Test
  public void ContainInValidUpper() {
      assertFalse("15 should not be contained in range -10 to 10",
      exampleRange.contains(15));
  }
  
  @Before
  public void setUpContainsInValidUpperDoubleLimit() throws Exception { exampleRange = new Range(-10, 10);
  }


  @Test
  public void ContainInValidUpperDoubleLimit() {
      assertFalse("Double.MAX_VALUE should not be contained in range -10 to 10",
      exampleRange.contains(Double.MAX_VALUE));
  }
  @Before
  public void setUpContainsInValidLowerDoubleLimit() throws Exception { exampleRange = new Range(-10, 10);
  }


  @Test
  public void ContainInValidLowerDoubleLimit() {
      assertFalse("Double.MIN_VALUE should not be contained in range -10 to 10",
      exampleRange.contains(Double.MIN_VALUE));
  }


    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    
    

    
    
    
    
}
