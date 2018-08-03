package stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackUsingArrayTest {
    StackUsingArray<Integer> stackInstance;

    //test cases for push()
    @Test
    public void testPushShouldReturnTrueWhenStackNotFull() {
       stackInstance=new StackUsingArray<Integer>(10);
       boolean actualOutput=stackInstance.push(4);
       assertEquals(true,actualOutput);
    }
    
    @Test
    public void testPushShouldReturnFalseWhenStackIsFull() {
       stackInstance=new StackUsingArray<Integer>(2);
       stackInstance.push(90);
       stackInstance.push(5);
       boolean actualOutput=stackInstance.push(4);
       assertEquals(false,actualOutput);
    }
    
    //test cases for pop()
    @Test
    public void testPopShouldReturnObjectWhenStackNotEmpty() {
       stackInstance=new StackUsingArray<Integer>(10);
       stackInstance.push(49);
       stackInstance.push(57);
       stackInstance.push(2);
       Integer actualOutput=stackInstance.pop();
       Integer expectedOutput=2;
       assertEquals(expectedOutput,actualOutput);
    }
    
    @Test(expected=AssertionError.class)
    public void testPopShouldThrowExceptionWhenStackEmpty() {
       stackInstance=new StackUsingArray<Integer>(10);
       stackInstance.pop();
    }
    
    //test cases for isEmpty()
    @Test
    public void testIsEmptyShouldReturnFalseWhenStackNotEmpty() {
       stackInstance=new StackUsingArray<Integer>(2);
       stackInstance.push(90);
       stackInstance.push(5);
       boolean actualOutput=stackInstance.isEmpty();
       assertEquals(false,actualOutput);
    }
    
    @Test
    public void testIsEmptyShouldReturnTrueWhenStackIsEmpty() {
       stackInstance=new StackUsingArray<Integer>(2);
       boolean actualOutput=stackInstance.isEmpty();
       assertEquals(true,actualOutput);
    }
    
  //test cases for isFull()
    @Test
    public void testIsFullShouldReturnFalseWhenStackNotFull() {
       stackInstance=new StackUsingArray<Integer>(10);
       stackInstance.push(90);
       stackInstance.push(5);
       boolean actualOutput=stackInstance.isFull();
       assertEquals(false,actualOutput);
    }
    
    @Test
    public void testIsFullShouldReturnTrueWhenStackIsFull() {
       stackInstance=new StackUsingArray<Integer>(2);
       stackInstance.push(90);
       stackInstance.push(5);
       boolean actualOutput=stackInstance.isFull();
       assertEquals(true,actualOutput);
    }

}
