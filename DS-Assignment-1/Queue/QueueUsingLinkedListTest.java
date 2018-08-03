package queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueUsingLinkedListTest {
    QueueUsingLinkedList<Integer> queueInstance;

    //test case for enqueue()
    @Test
    public void testEnqueueShouldReturnTrue() {
        queueInstance=new QueueUsingLinkedList<Integer>();
        boolean isEnqueue=queueInstance.enqueue(5);
        assertEquals(true,isEnqueue);
    }
    
    //test cases for dequeue()
    @Test
    public void testDequeueShouldReturnObjectWhenQueueNotEmpty() {
        queueInstance=new QueueUsingLinkedList<Integer>();
        queueInstance.enqueue(5);
        queueInstance.enqueue(47);
        queueInstance.enqueue(20);
        Integer actualOutput=queueInstance.dequeue();
        Integer expectedOutput=5;
        assertEquals(expectedOutput,actualOutput);
    }
    
    @Test(expected=AssertionError.class)
    public void testDequeueShouldThrowExceptionWhenQueueIsEmpty() {
        queueInstance=new QueueUsingLinkedList<Integer>();
        queueInstance.dequeue();
    }
    
    //test cases for isEmpty()
    @Test
    public void testIEmptyShouldReturnFalseWhenQueueNotEmpty() {
        queueInstance=new QueueUsingLinkedList<Integer>();
        queueInstance.enqueue(5);
        queueInstance.enqueue(47);
        queueInstance.enqueue(20);
        boolean actualOutput=queueInstance.isEmpty();
        assertEquals(false,actualOutput);
    }
    
    @Test
    public void testIsEmptyShouldReturnTrueWhenQueueIsEmpty() {
        queueInstance=new QueueUsingLinkedList<Integer>();
        boolean actualOutput=queueInstance.isEmpty();
        assertEquals(true,actualOutput);
    }


}
