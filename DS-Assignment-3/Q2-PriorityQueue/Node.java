package priorityQueue;

/**
 * This class represents object for Priority queue
 *
 */
public class Node {
    private String data;
    private int priority;
    
    public Node(String data, int priority)
    {
        this.data=data;
        this.priority=priority;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}
