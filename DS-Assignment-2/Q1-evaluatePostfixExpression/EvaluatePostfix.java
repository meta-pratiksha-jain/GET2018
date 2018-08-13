package evaluatePostfixExpression;

import stack.*;

public class EvaluatePostfix {
    private IStack<Double> stack;
    
    /**
     * evaluate a postfix Expression.
     * @param expression contains postfix expression for evaluation.
     * Assume postfix expression only contains Integer constants and Arithmetic binary operators.
     * And Integers and operators are separated using spaces.
     * @return returns result of Expression.
     */
    public double evaluate(String expression)
    {
        String[] token=expression.split(" ");
        stack=new StackUsingLinkedList<Double>();
        double result=0;
        for(int i=0;i<token.length;i++)
        {
            boolean isInteger=token[i].matches("\\d+");
            if(isInteger)
            {
                double integerToken=Integer.parseInt(token[i]);
                stack.push(integerToken);
            }
            else
            {
                double secondOperand=getOperand();
                double firstOperand=getOperand();
                if("+".equals(token[i]))
                {
                    result=firstOperand+secondOperand;
                    stack.push(result);
                }
                else if("-".equals(token[i]))
                {
                    result=firstOperand-secondOperand;
                    stack.push(result);
                }
                else if("*".equals(token[i]))
                {
                    result=firstOperand*secondOperand;
                    stack.push(result);
                }
                else if("/".equals(token[i]))
                {
                    if(secondOperand==0)
                    {
                        throw new AssertionError("Divide by zero error");
                    }
                    result=firstOperand/secondOperand;
                    stack.push(result);
                }
            }
        }
        result=stack.pop();
        boolean isEmpty=stack.isEmpty();
        if(!isEmpty)
        {
            throw new AssertionError("Invalid Postfix Expression");
        }
        return result;
    }
    
    /**
     * private helper method to get operand for operation.
     * @return operand
     */
    private double getOperand()
    {
        boolean isEmpty=stack.isEmpty();
        if(isEmpty)
        {
            throw new AssertionError("It is not valid postfix Expression");
        }
        double operand=stack.pop();
        return operand;
    }

}
