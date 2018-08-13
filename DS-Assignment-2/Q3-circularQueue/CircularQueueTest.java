package circularQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularQueueTest {
    CircularQueue<Integer> queueInstance;

    //test cases for enqueue()
    @Test
    public void testEnqueueShouldReturnTrueWhenFirstValueAdded() {
        queueInstance=new CircularQueue<Integer>(10);
        boolean isEnqueue=queueInstance.enqueue(5);
        assertEquals(true,isEnqueue);
    }
    
    @Test
    public void testEnqueueShouldReturnTrueWhenQueueNotFullAndRearNotAtEnd() {
        queueInstance=new CircularQueue<Integer>(10);
        queueInstance.enqueue(56);
        queueInstance.enqueue(7);
        boolean isEnqueue=queueInstance.enqueue(5);
        assertEquals(true,isEnqueue);
    }
    
    @Test
    public void testEnqueueShouldReturnTrueWhenQueueNotFullAndRearAtEnd() {
        queueInstance=new CircularQueue<Integer>(4);
        queueInstance.enqueue(56);
        queueInstance.enqueue(7);
        queueInstance.enqueue(7);
        queueInstance.enqueue(7);
        queueInstance.dequeue();
        boolean isEnqueue=queueInstance.enqueue(5);
        assertEquals(true,isEnqueue);
    }
    
    @Test
    public void testEnqueueShouldReturnFalseWhenQueueFullAndRearAtEnd() {
        queueInstance=new CircularQueue<Integer>(2);
        queueInstance.enqueue(5);
        queueInstance.enqueue(20);
        boolean isEnqueue=queueInstance.enqueue(34);
        assertEquals(false,isEnqueue);
    }
    
    @Test
    public void testEnqueueShouldReturnFalseWhenQueueFullAndRearNotAtEnd() {
        queueInstance=new CircularQueue<Integer>(4);
        queueInstance.enqueue(5);
        queueInstance.enqueue(20);
        queueInstance.enqueue(4);
        queueInstance.dequeue();
        queueInstance.enqueue(2);
        queueInstance.enqueue(9);
        boolean isEnqueue=queueInstance.enqueue(34);
        assertEquals(false,isEnqueue);
    }
    
    //test cases for dequeue()
    @Test
    public void testDequeueShouldReturnObjectWhenQueueNotEmptyAndRearNotAtEnd() {
        queueInstance=new CircularQueue<Integer>(10);
        queueInstance.enqueue(5);
        queueInstance.enqueue(47);
        queueInstance.enqueue(20);
        Integer actualOutput=queueInstance.dequeue();
        Integer expectedOutput=5;
        assertEquals(expectedOutput,actualOutput);
    }
    
    @Test
    public void testDequeueShouldReturnObjectWhenQueueNotEmptyAndRearAtEnd() {
        queueInstance=new CircularQueue<Integer>(4);
        queueInstance.enqueue(5);
        queueInstance.enqueue(47);
        queueInstance.dequeue();
        queueInstance.enqueue(20);
        queueInstance.enqueue(20);
        Integer actualOutput=queueInstance.dequeue();
        Integer expectedOutput=47;
        assertEquals(expectedOutput,actualOutput);
    }
    
    @Test(expected=AssertionError.class)
    public void testDequeueShouldThrowExceptionWhenQueueIsEmpty() {
        queueInstance=new CircularQueue<Integer>(10);
        queueInstance.dequeue();
    }
    
    //test cases for isEmpty()
    @Test
    public void testIsEmptyShouldReturnFalseWhenQueueNotEmptyAndRearNotAtEnd() {
        queueInstance=new CircularQueue<Integer>(10);
        queueInstance.enqueue(5);
        queueInstance.enqueue(47);
        queueInstance.enqueue(20);
        boolean actualOutput=queueInstance.isEmpty();
        assertEquals(false,actualOutput);
    }
    
    @Test
    public void testIsEmptyShouldReturnFalseWhenQueueNotEmptyAndRearAtEnd() {
        queueInstance=new CircularQueue<Integer>(4);
        queueInstance.enqueue(5);
        queueInstance.enqueue(47);
        queueInstance.dequeue();
        queueInstance.enqueue(20);
        queueInstance.enqueue(47);
        boolean actualOutput=queueInstance.isEmpty();
        assertEquals(false,actualOutput);
    }
    
    @Test
    public void testIsEmptyShouldReturnTrueWhenQueueIsEmpty() {
        queueInstance=new CircularQueue<Integer>(10);
        boolean actualOutput=queueInstance.isEmpty();
        assertEquals(true,actualOutput);
    }
    
    //test cases for isFull()
    @Test
    public void testIsFullShouldReturnFalseWhenQueueNotFullAndRearNotAtEnd() {
        queueInstance=new CircularQueue<Integer>(10);
        queueInstance.enqueue(5);
        queueInstance.enqueue(47);
        queueInstance.enqueue(20);
        boolean actualOutput=queueInstance.isFull();
        assertEquals(false,actualOutput);
    }
    
    @Test
    public void testIsFullShouldReturnFalseWhenQueueNotFullAndRearAtEnd() {
        queueInstance=new CircularQueue<Integer>(4);
        queueInstance.enqueue(5);
        queueInstance.enqueue(47);
        queueInstance.dequeue();
        queueInstance.enqueue(20);
        queueInstance.enqueue(47);
        boolean actualOutput=queueInstance.isFull();
        assertEquals(false,actualOutput);
    }
    
    @Test
    public void testIsFullShouldReturnTrueWhenQueueIsFullAndRearAtEnd() {
        queueInstance=new CircularQueue<Integer>(2);
        queueInstance.enqueue(5);
        queueInstance.enqueue(47);
        boolean actualOutput=queueInstance.isFull();
        assertEquals(true,actualOutput);
    }
    
    @Test
    public void testIsFullShouldReturnTrueWhenQueueIsFullAndRearNotAtEnd() {
        queueInstance=new CircularQueue<Integer>(4);
        queueInstance.enqueue(5);
        queueInstance.enqueue(47);
        queueInstance.dequeue();
        queueInstance.enqueue(4);
        queueInstance.enqueue(7);
        queueInstance.enqueue(48);
        boolean actualOutput=queueInstance.isFull();
        assertEquals(true,actualOutput);
    }

}
