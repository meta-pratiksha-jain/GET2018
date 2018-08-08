package priorityQueue;

/**
 * this class implements interface IPriorityQueue using array.
 *
 */
public class PriorityQueue implements IPriorityQueue {
    int rear;
    Node[] priorityQueue;

    public PriorityQueue(int arraySize)
    {
        priorityQueue=new Node[arraySize];
        rear=-1;
    }
    
    @Override
    public boolean enqueue(String data,int priority) {
        Node node=new Node(data,priority);
        boolean isEnqueue=false;
        boolean isFull=isFull();
        if(isFull)
        {
            return isEnqueue;
        }
        if(rear==-1)
        {
            priorityQueue[0]=node;
            rear++;
        }
        else
        {
            for(int i=rear;i>=0;i--)
            {
                int priorityOfCurrentNode=priorityQueue[i].getPriority();
                if(priority>priorityOfCurrentNode)
                {
                    priorityQueue[i+1]=priorityQueue[i];
                    priorityQueue[i]=node;
                }
                else
                {
                    priorityQueue[i+1]=node;
                    break;
                }
            }
            rear++;
        }
        isEnqueue=true;
        return isEnqueue;
    }

    @Override
    public Node dequeue() {
        boolean isEmpty=isEmpty();
        if(isEmpty)
        {
            throw new AssertionError("Priority queue is empty"); 
        }
        Node dequeuedNode=priorityQueue[0];
        for(int i=0;i<rear;i++)
        {
            priorityQueue[i]=priorityQueue[i+1];    
        }
        rear--;
        return dequeuedNode;
    }

    @Override
    public Node peek() {
        boolean isEmpty=isEmpty();
        if(isEmpty)
        {
            throw new AssertionError("Priority queue is empty"); 
        }
        Node node=priorityQueue[0];
        return node;
    }

    @Override
    public boolean isEmpty() {
        if(rear==-1)
        {
            return true;
        }
        return false;
    }
    
    /**
     * checks whether queue is full or not
     * @return returns true if queue is full otherwise false
     */
    public boolean isFull() {
        if(rear==priorityQueue.length-1)
        {
            return true;
        }
        return false;
    }

}
