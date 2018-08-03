package queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueUsingArrayTest {
    QueueUsingArray<Integer> queueInstance;

    //test case for enqueue()
    @Test
    public void testEnqueueShouldReturnTrueWhenQueueNotFull() {
        queueInstance=new QueueUsingArray<Integer>(10);
        boolean isEnqueue=queueInstance.enqueue(5);
        assertEquals(true,isEnqueue);
    }
    
    @Test
    public void testEnqueueShouldReturnFalseWhenQueueIsFull() {
        queueInstance=new QueueUsingArray<Integer>(2);
        queueInstance.enqueue(5);
        queueInstance.enqueue(20);
        boolean isEnqueue=queueInstance.enqueue(34);
        assertEquals(false,isEnqueue);
    }
    
    //test cases for dequeue()
    @Test
    public void testDequeueShouldReturnObjectWhenQueueNotEmpty() {
        queueInstance=new QueueUsingArray<Integer>(10);
        queueInstance.enqueue(5);
        queueInstance.enqueue(47);
        queueInstance.enqueue(20);
        Integer actualOutput=queueInstance.dequeue();
        Integer expectedOutput=5;
        assertEquals(expectedOutput,actualOutput);
    }
    
    @Test(expected=AssertionError.class)
    public void testDequeueShouldThrowExceptionWhenQueueIsEmpty() {
        queueInstance=new QueueUsingArray<Integer>(10);
        queueInstance.dequeue();
    }
    
    //test cases for isEmpty()
    @Test
    public void testIEmptyShouldReturnFalseWhenQueueNotEmpty() {
        queueInstance=new QueueUsingArray<Integer>(10);
        queueInstance.enqueue(5);
        queueInstance.enqueue(47);
        queueInstance.enqueue(20);
        boolean actualOutput=queueInstance.isEmpty();
        assertEquals(false,actualOutput);
    }
    
    @Test
    public void testIsEmptyShouldReturnTrueWhenQueueIsEmpty() {
        queueInstance=new QueueUsingArray<Integer>(10);
        boolean actualOutput=queueInstance.isEmpty();
        assertEquals(true,actualOutput);
    }
    
    //test cases for isFull()
    @Test
    public void testIsFullShouldReturnFalseWhenQueueNotFull() {
        queueInstance=new QueueUsingArray<Integer>(10);
        queueInstance.enqueue(5);
        queueInstance.enqueue(47);
        queueInstance.enqueue(20);
        boolean actualOutput=queueInstance.isFull();
        assertEquals(false,actualOutput);
    }
    
    @Test
    public void testIsFullShouldReturnTrueWhenQueueIsFull() {
        queueInstance=new QueueUsingArray<Integer>(2);
        queueInstance.enqueue(5);
        queueInstance.enqueue(47);
        boolean actualOutput=queueInstance.isFull();
        assertEquals(true,actualOutput);
    }

}
