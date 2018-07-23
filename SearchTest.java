import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTest {
	Search searchInstance=new Search();

	@Test
	public void linearSearchTest() {
		int[] array= {1,2,3,4,5,6,7};
		int indexOfElement=searchInstance.linearSearch(array,0, 9);
		assertEquals(-1,indexOfElement);
	}

	@Test
	public void binarySearchTest() {
		int[] array= {1,2,3,4,5,6,7};
		int indexOfElement=searchInstance.binarySearch(array,0,6,9);
		assertEquals(-1,indexOfElement);
	}
}
