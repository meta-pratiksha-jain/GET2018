import static org.junit.Assert.*;

import org.junit.Test;

public class NQueenTest {

	@Test
	public void test() {
		int[][] board= {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		NQueen nQueenInstance=new NQueen();
		boolean result=nQueenInstance.nQueen(board,0,4);
		assertEquals(true,result);
	}

}
