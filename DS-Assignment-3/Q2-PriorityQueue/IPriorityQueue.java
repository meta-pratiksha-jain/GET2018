package priorityQueue;

/**
 * Interface for priority Queue.
 *
 */
public interface IPriorityQueue {
    
    /**
     * add the object into queue according to their priority
     * @param data 
     * @param priority
     * @return returns true if object is added otherwise false
     */
    public boolean enqueue(String data,int priority);
    
    /**
     * remove the object from queue having highest priority
     * @return the object which is removed
     */
    public Node dequeue();
    
    /**
     * gives object of highest priority in queue
     * @return object
     */
    public Node peek();
    
    /**
     * checks whether queue is empty or not
     * @return returns true if queue is empty otherwise false
     */
    public boolean isEmpty();

}
