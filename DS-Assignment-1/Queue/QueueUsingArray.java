package queue;

/**
 * This class implements IQueue interface using array.
 *
 * @param <T> is generic type.
 */
public class QueueUsingArray<T> implements IQueue<T> {
    private int front;
    private int rear;
    private T[] queue;
    
    public QueueUsingArray(int queueSize) {
        front=0;
        rear=0;
        queue=(T[])new Object[queueSize];
    }
    
    @Override
    public boolean enqueue(T element) {
        boolean isEnqueue=false;
        if(rear==queue.length)
        {
            return isEnqueue;
        }
        queue[rear]=element;
        rear++;
        isEnqueue=true;
        return isEnqueue;
    }
    
    @Override
    public T dequeue() {
        boolean isEmpty=isEmpty();
        if(isEmpty)
        {
            throw new AssertionError("Queue is empty");
        }
        T element=queue[front];
        front++;
        return element;
    }
    
    @Override
    public boolean isEmpty() {
        if(front==rear)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Checks whether queue is full or not. 
     * @return returns true if queue is full otherwise false.
     */
    public boolean isFull() {
        if(rear==queue.length)
        {
            return true;
        }
        return false;
    }

}
