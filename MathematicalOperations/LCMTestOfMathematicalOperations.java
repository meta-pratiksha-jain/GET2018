import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LCMTestOfMathematicalOperations {
    private int number1;
    private int number2;
    private int expectedResult;
    private MathematicalOperations lCMInstance;
    
    public LCMTestOfMathematicalOperations(int number1,int number2,int expectedResult) {
        super();
        this.number1=number1;
        this.number2=number2;
        this.expectedResult=expectedResult;
    }
    
    @Before
    public void initialize()
    {
        lCMInstance=new MathematicalOperations();
    }
    
    @Parameterized.Parameters
    public static Collection input()
    {
        return Arrays.asList(new Object[][]{{12,16,48},{3,4,12},{3,15,15}});
    }

    @Test
    public void test() {
       assertEquals(expectedResult,lCMInstance.LCMOfTwoNumbers(number1, number2));
    }

}
