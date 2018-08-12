package evaluatePostfixExpression;

import static org.junit.Assert.*;

import org.junit.Test;

public class evaluatePostfixTest {
    EvaluatePostfix evaluatePostfixInstance;

    //test cases for evaluate()
    @Test
    public void testEvaluateShouldReturnResultForValidExpression() {
        String postfixExpression="2 4 + 6 2 - *";
        evaluatePostfixInstance=new EvaluatePostfix();
        double actualOutput=evaluatePostfixInstance.evaluate(postfixExpression);
        double expectedOutput=24;
        assertEquals(expectedOutput,actualOutput,0.01);
    }
    
    @Test(expected=AssertionError.class)
    public void testEvaluateShouldThrowExceptionWhenOpeartorsMoreThanNeeded() {
        String postfixExpression="2 4 + 6 2 + * /";
        evaluatePostfixInstance=new EvaluatePostfix();
        evaluatePostfixInstance.evaluate(postfixExpression);
    }
    
    @Test(expected=AssertionError.class)
    public void testEvaluateShouldThrowExceptionWhenOpeartorsLessThanNeeded() {
        String postfixExpression="2 4 6 2 + /";
        evaluatePostfixInstance=new EvaluatePostfix();
        evaluatePostfixInstance.evaluate(postfixExpression);
    }
    
    @Test(expected=AssertionError.class)
    public void testEvaluateShouldThrowExceptionForDivisionByZero() {
        String postfixExpression="2 4 + 2 2 - /";
        evaluatePostfixInstance=new EvaluatePostfix();
        evaluatePostfixInstance.evaluate(postfixExpression);
    }

}
