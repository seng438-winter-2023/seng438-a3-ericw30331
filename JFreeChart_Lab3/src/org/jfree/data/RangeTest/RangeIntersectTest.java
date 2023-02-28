package org.jfree.data.RangeTest;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeIntersectTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-10, 10);
    }


    @Test //test intersect with invalid paramaters (parameters inversed)
    public void intersectInvalidParamaters() {
        assertFalse("The intersection should be false since the the parameters of the function is inversed",
        exampleRange.intersects(5, -5));
    }

    @Before
    public void setUpNonOverlapping() throws Exception { exampleRange = new Range(-10, 10);
    }


    @Test //test intersect with positive ranges (10.01/15) that never intersect
    public void intersectUpperBoundNotOverLapping() {
        assertFalse("The intersection should be false since the ranges dont intersect they are only close togethor",
        exampleRange.intersects(10.01, 15));
    }
    @Before 
    public void setUpNonOverlappingLower() throws Exception { exampleRange = new Range(-10, 10);
    }


    @Test //test intersect with negative ranges (-15, -10.01) that never intersect
    public void intersectLowerBoundNotOverLapping() {
        assertFalse("The intersection should be false since the ranges dont intersect they are only close togethor",
        exampleRange.intersects(-15, -10.01));
    }
    
    
    @Before
    public void UpperBoundIntersecting() throws Exception { exampleRange = new Range(-10, 10);
    }
    


    @Test //test intersect with upper bound overlapping
    public void intersectUpperBoundOverLapping() {
        assertTrue("The intersection should be true since it intersects with the upper bounds",
        exampleRange.intersects(5, 15));
    }
    @Before
    public void LowerBoundIntersecting() throws Exception { exampleRange = new Range(-10, 10);
    }


    @Test //test intersect with lower bounds overlapping
    public void intersectLowerBoundOverLapping() {
        assertTrue("The intersection should be true since it intersects with the lower bounds",
        exampleRange.intersects(-15, -5));
    }
    @Before
    public void BothBoundOverlapping() throws Exception { exampleRange = new Range(-10, 10);
    }


    @Test //test intersect with both upper and lower bounds overlapping
    public void intersectBothBoundsOverLapping() {
        assertTrue("The intersection should be true since the range overlaps the intersect range",
        exampleRange.intersects(-5, 5));
    }
    @Before
    public void NoRangeOverlapping() throws Exception { exampleRange = new Range(-10, 10);
    }


    @Test //test intersect with no overlapping range
    public void intersectNoRangeOverLapping() {
        assertTrue("The intersection should be true since it overlaps",
        exampleRange.intersects(0, 0));
    }
    @Before
    public void UpperBoundNoOverlapping() throws Exception { exampleRange = new Range(-10, 10);
    }


    @Test //test intersect with no overlapping upper range
    public void intersectUpperBoundNoOverlapping() {
        assertFalse("The intersection should be false since the upperbound completly does not overlap",
        exampleRange.intersects(20, 30));
    }
    @Before
    public void lowerBoundNoOverlapping() throws Exception { exampleRange = new Range(-10, 10);
    }


    @Test //test intersect with no overlapping lower range
    public void intersectLowerBoundNoOverlapping() {
        assertFalse("The intersection should be false since the the parameters of the function is inversed",
        exampleRange.intersects(-30, -20));
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    
    
//    @Before
//    public void setUpContainsValud() throws Exception { exampleRange = new Range(-10, 10);
//    }
//
//
//    @Test
//    public void ContainValid() {
//        assertTrue("0 should be contained in range -10 to 10",
//        exampleRange.contains(0));
//    }
//    
//    @Before
//    public void setUpContainsValidUpper() throws Exception { exampleRange = new Range(-10, 10);
//    }
//
//
//    @Test
//    public void ContainValidUpper() {
//        assertTrue("10 should be contained in range -10 to 10",
//        exampleRange.contains(10));
//    }
//    @Before
//    public void setUpContainsValidLower() throws Exception { exampleRange = new Range(-10, 10);
//    }
//
//
//    @Test
//    public void ContainValidLower() {
//        assertTrue("-10 should be contained in range -10 to 10",
//        exampleRange.contains(-10));
//    }
//    
//    @Before
//    public void setUpContainsInValidLower() throws Exception { exampleRange = new Range(-10, 10);
//    }
//
//
//    @Test
//    public void ContainInValidLower() {
//        assertFalse("-15 should not be contained in range -10 to 10",
//        exampleRange.contains(-15));
//    }
//    
//    
//    @Before
//    public void setUpContainsInValidUpper() throws Exception { exampleRange = new Range(-10, 10);
//    }
//
//
//    @Test
//    public void ContainInValidUpper() {
//        assertFalse("15 should not be contained in range -10 to 10",
//        exampleRange.contains(15));
//    }
//    
//    @Before
//    public void setUpContainsInValidUpperDoubleLimit() throws Exception { exampleRange = new Range(-10, 10);
//    }
//
//
//    @Test
//    public void ContainInValidUpperDoubleLimit() {
//        assertFalse("Double.MAX_VALUE should not be contained in range -10 to 10",
//        exampleRange.contains(Double.MAX_VALUE));
//    }
//    @Before
//    public void setUpContainsInValidLowerDoubleLimit() throws Exception { exampleRange = new Range(-10, 10);
//    }
//
//
//    @Test
//    public void ContainInValidLowerDoubleLimit() {
//        assertFalse("Double.MIN_VALUE should not be contained in range -10 to 10",
//        exampleRange.contains(Double.MIN_VALUE));
//    }
    
    
    
    
}
