import static org.junit.Assert.*;

import org.junit.Test;

public class MathematicalOperationsTest {

	@Test
	public void HCFTest() {
		MathematicalOperations operationInstance=new MathematicalOperations();
		int result=operationInstance.HCFOfTwoNumbers(16, 4);
		assertEquals(4,result);
	}
	
	@Test
	public void LCMTest() {
		MathematicalOperations operationInstance=new MathematicalOperations();
		int result=operationInstance.LCMOfTwoNumbers(4, 16);
		assertEquals(16,result);
	}


}
