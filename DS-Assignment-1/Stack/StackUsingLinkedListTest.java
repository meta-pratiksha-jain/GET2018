package stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackUsingLinkedListTest {
    StackUsingLinkedList<Integer> stackInstance;

    //test cases for push()
    @Test
    public void testPushShouldReturnTrue() {
       stackInstance=new StackUsingLinkedList<Integer>();
       boolean actualOutput=stackInstance.push(4);
       assertEquals(true,actualOutput);
    }
    
    //test cases for pop()
    @Test
    public void testPopShouldReturnObjectWhenStackNotEmpty() {
       stackInstance=new StackUsingLinkedList<Integer>();
       stackInstance.push(49);
       stackInstance.push(57);
       stackInstance.push(2);
       Integer actualOutput=stackInstance.pop();
       Integer expectedOutput=2;
       assertEquals(expectedOutput,actualOutput);
    }
    
    @Test(expected=AssertionError.class)
    public void testPopShouldThrowExceptionWhenStackEmpty() {
       stackInstance=new StackUsingLinkedList<Integer>();
       stackInstance.pop();
    }
    
    //test cases for isEmpty()
    @Test
    public void testIsEmptyShouldReturnFalseWhenStackNotEmpty() {
       stackInstance=new StackUsingLinkedList<Integer>();
       stackInstance.push(90);
       stackInstance.push(5);
       boolean actualOutput=stackInstance.isEmpty();
       assertEquals(false,actualOutput);
    }
    
    @Test
    public void testIsEmptyShouldReturnTrueWhenStackIsEmpty() {
       stackInstance=new StackUsingLinkedList<Integer>();
       boolean actualOutput=stackInstance.isEmpty();
       assertEquals(true,actualOutput);
    }

}
