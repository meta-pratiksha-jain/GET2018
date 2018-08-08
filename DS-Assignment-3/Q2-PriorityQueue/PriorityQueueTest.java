package priorityQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueueTest {
    PriorityQueue priorityQueue;

    //test cases for enqueue()
    @Test
    public void testEnqueueShouldReturnTrueWhenQueueNotFull() {
        priorityQueue=new PriorityQueue(10);
        priorityQueue.enqueue("node1", 2);
        boolean isEnqueue=priorityQueue.enqueue("node2", 4);
        assertEquals(true,isEnqueue);
    }
    
    @Test
    public void testEnqueueShouldReturnFalseWhenQueueFull() {
        priorityQueue=new PriorityQueue(2);
        priorityQueue.enqueue("node1", 2);
        priorityQueue.enqueue("node2", 1);
        boolean isEnqueue=priorityQueue.enqueue("node3", 4);
        assertEquals(false,isEnqueue);
    }
    
    //Test cases for dequeue()
    @Test
    public void testDequeueShouldReturnObjectWhenQueueNotEmpty() {
        priorityQueue=new PriorityQueue(10);
        priorityQueue.enqueue("node1", 2);
        priorityQueue.enqueue("node2", 1);
        priorityQueue.enqueue("node3", 4);
        Node actualOutput=priorityQueue.dequeue();
        assertEquals("node3", actualOutput.getData());
        assertEquals(4,actualOutput.getPriority());
    }
    
    @Test(expected=AssertionError.class)
    public void testDequeueShouldThrowExceptionWhenQueueEmpty() {
        priorityQueue=new PriorityQueue(2);
        priorityQueue.dequeue();
    }
    
    //test cases for peek()
    @Test
    public void testPeekShouldReturnObjectWhenQueueNotEmpty() {
        priorityQueue=new PriorityQueue(10);
        priorityQueue.enqueue("node1", 2);
        priorityQueue.enqueue("node2", 1);
        priorityQueue.enqueue("node3", 4);
        Node actualOutput=priorityQueue.peek();
        assertEquals("node3", actualOutput.getData());
        assertEquals(4,actualOutput.getPriority());
    }
    
    @Test(expected=AssertionError.class)
    public void testPeekShouldThrowExceptionWhenQueueEmpty() {
        priorityQueue=new PriorityQueue(2);
        priorityQueue.peek();
    }
    
    //test cases for isEmpty()
    @Test
    public void testIsEmptyShouldReturnTrueWhenQueueEmpty() {
        priorityQueue=new PriorityQueue(10);
        boolean isEmpty=priorityQueue.isEmpty();
        assertEquals(true,isEmpty);
    }
    
    @Test
    public void testIsEmptyShouldReturnFalseWhenQueueNotEmpty() {
        priorityQueue=new PriorityQueue(10);
        priorityQueue.enqueue("node1", 2);
        boolean isEmpty=priorityQueue.isEmpty();
        assertEquals(false,isEmpty);
    }
    
    //test cases for isFull()
    @Test
    public void testIsFullShouldReturnTrueWhenQueueFull() {
        priorityQueue=new PriorityQueue(2);
        priorityQueue.enqueue("node1", 2);
        priorityQueue.enqueue("node2", 1);
        boolean isFull=priorityQueue.isFull();
        assertEquals(true,isFull);
    }
    
    @Test
    public void testIsFullShouldReturnFalseWhenQueueNotFull() {
        priorityQueue=new PriorityQueue(10);
        priorityQueue.enqueue("node1", 2);
        boolean isFull=priorityQueue.isFull();
        assertEquals(false,isFull);
    }

}
