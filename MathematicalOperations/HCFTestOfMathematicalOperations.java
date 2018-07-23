import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class HCFTestOfMathematicalOperations {
    private int number1;
    private int number2;
    private int expectedResult;
    private MathematicalOperations HCFInstance;
    
    public HCFTestOfMathematicalOperations(int number1,int number2,int expectedResult) {
        super();
        this.number1=number1;
        this.number2=number2;
        this.expectedResult=expectedResult;
    }
    
    @Before
    public void initialize()
    {
        HCFInstance=new MathematicalOperations();
    }
    
    @Parameterized.Parameters
    public static Collection input()
    {
        return Arrays.asList(new Object[][]{{12,16,4},{3,4,1},{3,15,3}});
    }

    @Test
    public void test() {
       assertEquals(expectedResult,HCFInstance.HCFOfTwoNumbers(number1, number2));
    }

}
