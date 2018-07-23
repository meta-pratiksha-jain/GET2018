import static org.junit.Assert.*;

import org.junit.Test;


public class ArrOperationTest {
	ArrOperation arrOperation=new ArrOperation();
	
	@Test
	public void largestMirrorTest() {
		int[] array={1,2,3,8,9,3,2,1};
		int largestMirror= arrOperation.largestMirror(array);
		assertEquals(3,largestMirror);
	}
	
	@Test
	public void countClumpsTest() {
		int[] array={1,1,1,2,1,1};
		int numberOfClumps= arrOperation.countClumps(array);
		assertEquals(2,numberOfClumps);
	}
	
	@Test
	public void fixXYTest() {
		int[] array={5,4,9,4,9,5};
		int[] arrayAfterFixXY= arrOperation.fixXY(array,4,5);
		int[] expectedArrayAfterFixXY={9,4,5,4,5,9};
		assertEquals(expectedArrayAfterFixXY,arrayAfterFixXY);
	}

	@Test
	public void splitArrayTest() {
		int[] array={1,1,1,2,1};
		int index= arrOperation.splitArray(array);
		assertEquals(3,index);
	}

}