import static org.junit.Assert.*;

import org.junit.Test;


public class ArrOperationTest {
	ArrOperation arrOperation=new ArrOperation();
    
	/*
	 * test case for largest mirror section when array is not empty
	 */
	@Test
	public void largestMirrorTestWhenArrayNotEmpty() {
		assertEquals(3,arrOperation.largestMirror(new int[]{1,2,3,8,9,3,2,1}));
		assertEquals(3,arrOperation.largestMirror(new int[]{1,2,1}));
		assertEquals(7,arrOperation.largestMirror(new int[]{1,4,5,3,5,4,1}));
		assertEquals(0,arrOperation.largestMirror(new int[]{1,4,2,7,6}));
	}
	
	 /*
     * test case for largest mirror section when array is empty
     */
    @Test(expected=AssertionError.class)
    public void largestMirrorTestWhenArrayEmpty() {
        arrOperation.largestMirror(new int[]{});
    }

	/*
	 * test case for number of clumps when array is not empty
	 */
	@Test
	public void countClumpsTestWhenArrayNotEmpty() {
		assertEquals(2,arrOperation.countClumps(new int[]{1,2,2,3,4,4}));
		assertEquals(2,arrOperation.countClumps(new int[]{1,1,2,1,1}));
		assertEquals(1,arrOperation.countClumps(new int[]{1,1,1,1,1}));
		assertEquals(0,arrOperation.countClumps(new int[]{1,5,3,7,6}));
	}
	
	/*
     * test case for number of clumps when array is empty
     */
    @Test(expected=AssertionError.class)
    public void countClumpsTestWhenArrayEmpty() {
        arrOperation.countClumps(new int[]{});
    }
	
    /*
     * test case when array can be rearranged
     */
	@Test
	public void fixXYTestWhenArrayRearranged() {
		assertArrayEquals(new int[]{9,4,5,4,5,9},arrOperation.fixXY(new int[]{5,4,9,4,9,5},4,5));
		assertArrayEquals(new int[]{1,4,5,1},arrOperation.fixXY(new int[]{1,4,1,5},4,5));
		assertArrayEquals(new int[]{1,4,5,1,1,4,5},arrOperation.fixXY(new int[]{1,4,1,5,5,4,1},4,5));
	}
	
	/*
    * test case when array can't rearranged
    */
	@Test(expected=AssertionError.class)
	public void fixXYTestWhenArrayNotRearranged() {
	    arrOperation.fixXY(new int[]{},4,5);
        arrOperation.fixXY(new int[]{5,4,9,4,9,6},4,5);
        arrOperation.fixXY(new int[]{1,4,4,5},4,5);
        arrOperation.fixXY(new int[]{1,4,5,1,1,5,4},4,5);
    }
	
	/*
	 * test case when array is not empty
	 */
	@Test
	public void splitArrayTestWhenArrayNotEmpty() {
		assertEquals(3,arrOperation.splitArray(new int[]{1,1,1,2,1}));
		assertEquals(-1,arrOperation.splitArray(new int[]{1,2,1,2,1}));
		assertEquals(1,arrOperation.splitArray(new int[]{10,10}));
	}
	
	/*
     * test case when array is empty
     */
    @Test
    public void splitArrayTestWhenArrayEmpty() {
       arrOperation.splitArray(new int[]{1,1,1,2,1});
    }

}