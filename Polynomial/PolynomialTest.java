import static org.junit.Assert.*;

import org.junit.Test;

public class PolynomialTest {
    //Tests cases for evaluatePolynomial()
    @Test
    public void testEvaluatePolynomial()
    {
        int[][] inputArray = {{0,1}, {2,4}};
        Polynomial polynomial = new Polynomial(inputArray);
        float expectedOutput = 17;
        assertEquals(expectedOutput, polynomial.evaluatePolynomial(2), 0);
    }
    
    @Test(expected=AssertionError.class)
    public void testEvaluatePolynomialWithEmptyArray()
    {
        int[][] inputArray = {};
        Polynomial polynomial = new Polynomial(inputArray);
        polynomial.evaluatePolynomial(2);
    }
    
    @Test
    public void testEvaluatePolynomialWithValueEqualsZero()
    {
        int[][] inputArray = {{0,1}, {1,2}, {2,3}};
        Polynomial polynomial = new Polynomial(inputArray);
        float expectedOutput = 1;
        assertEquals(expectedOutput, polynomial.evaluatePolynomial(0), 0);
    }
    
  //Tests cases for getDegree()
    @Test
    public void testGetDegree()
    {
        int[][] inputArray = {{0,1}, {2,4}};
        Polynomial polynomial = new Polynomial(inputArray);
        int expectedOutput = 2;
        assertEquals(expectedOutput, polynomial.getDegree());
    }
    
    @Test(expected = AssertionError.class)
    public void testDegreeWithEmptyArray()
    {
        int[][] inputArray = {};
        Polynomial polynomial = new Polynomial(inputArray);
        polynomial.getDegree();
    }
    
  //Tests cases for addPolynomial()
    @Test
    public void testAddPolynomial()
    {
        int[][] inputArray1 = {{0,1}, {2,4}};
        Polynomial firstPolynomial = new Polynomial(inputArray1);
        
        int[][] inputArray2 = {{0,3}, {1,4}, {4,5}};
        Polynomial secondPolynomial = new Polynomial(inputArray2);
        
        int[][] expectedOutput = {{0, 4}, {1, 4}, {2, 4}, {4, 5}};
        
        Polynomial resultPolynomial;
        resultPolynomial = firstPolynomial.addPolynomial(secondPolynomial);
        int[][] actualOutput = resultPolynomial.getPolynomial();
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = AssertionError.class)
    public void testAddPolynomialWithFirstArrayAsEmpty()
    {
        int[][] inputArray1 = {};
        Polynomial firstPolynomial = new Polynomial(inputArray1);
        
        int[][] inputArray2 = {{0,3}, {1,4}, {4,5}};
        Polynomial secondPolynomial = new Polynomial(inputArray2);
        
        firstPolynomial.addPolynomial(secondPolynomial);
    }
    
    @Test(expected = AssertionError.class)
    public void testAddPolynomialWithSecondArrayAsEmpty()
    {
        int[][] inputArray1 = {{0,1}, {2,4}};
        Polynomial firstPolynomial = new Polynomial(inputArray1);
        
        int[][] inputArray2 = {};
        Polynomial secondPolynomial = new Polynomial(inputArray2);
        
        firstPolynomial.addPolynomial(secondPolynomial);
    }
    
    @Test(expected = AssertionError.class)
    public void testAddPolynomialWithBothArraysAsEmpty()
    {
        int[][] inputArray1 = {};
        Polynomial firstPolynomial = new Polynomial(inputArray1);
        
        int[][] inputArray2 = {};
        Polynomial secondPolynomial = new Polynomial(inputArray2);
        
        firstPolynomial.addPolynomial(secondPolynomial);
    }
    
    //Tests cases for multiplyPolynomial()
    @Test
    public void testMultiplyPolynomial()
    {
        int[][] inputArray1 = {{0,1}, {2,4}};
        Polynomial firstPolynomial = new Polynomial(inputArray1);
         
        int[][] inputArray2 = {{0,3}, {1,4}, {4,5}};
        Polynomial secondPolynomial = new Polynomial(inputArray2);
        
        int[][] expectedOutput = {{0,3}, {1,4}, {2,12}, {3,16}, {4,5}, {6,20}};
        
        Polynomial resultPolynomial;
        resultPolynomial = firstPolynomial.multiplyPolynomial(secondPolynomial);
        int[][] actualOutput = resultPolynomial.getPolynomial();
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    @Test(expected = AssertionError.class)
    public void testMultiplyPolynomialWithFirstArrayAsEmpty()
    {
        int[][] inputArray1 = {};
        Polynomial firstPolynomial = new Polynomial(inputArray1);
        
        int[][] inputArray2 = {{0,3}, {1,4}, {4,5}};
        Polynomial secondPolynomial = new Polynomial(inputArray2);
        
        firstPolynomial.multiplyPolynomial(secondPolynomial);
    }
    
    @Test(expected = AssertionError.class)
    public void testMultiplyPolynomialWithSecondArrayAsEmpty()
    {
        int[][] inputArray1 = {{0,1}, {2,4}};
        Polynomial firstPolynomial = new Polynomial(inputArray1);
        
        int[][] inputArray2 = {};
        Polynomial secondPolynomial = new Polynomial(inputArray2);
        
        firstPolynomial.multiplyPolynomial(secondPolynomial);
    }
    
    @Test(expected = AssertionError.class)
    public void testMultiplyPolynomialWithBothArraysAsEmpty()
    {
         int[][] inputArray1 = {};
         Polynomial firstPolynomial = new Polynomial(inputArray1);
         
         int[][] inputArray2 = {};
         Polynomial secondPolynomial = new Polynomial(inputArray2);
         
         firstPolynomial.multiplyPolynomial(secondPolynomial);
    }
}
