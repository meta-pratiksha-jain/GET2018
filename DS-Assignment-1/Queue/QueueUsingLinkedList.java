package queue;

/**
 * This class implements IQueue interface using Linked List.
 *
 * @param <T> is generic type.
 */
public class QueueUsingLinkedList<T> implements IQueue<T> {
    private Node<T> front;
    private Node<T> rear;
    
    public QueueUsingLinkedList() {
        front=null;
        rear=null;
    }

    @Override
    public boolean enqueue(T element) {
        Node node=new Node(element);
        if(front==null && rear==null)
        {
            front=node;
            rear=node;
            return true;
        }
        rear.setNext(node);
        rear=node;
        return true;
    }

    @Override
    public T dequeue() {
        boolean isQueueEmpty=isEmpty();
        if(isQueueEmpty)
        {
            throw new AssertionError("queue is empty");
        }
        T element=front.getData();
        front=front.getNext();
        return element;
    }

    @Override
    public boolean isEmpty() {
        if(front==null)
        {
            return true;
        }
        return false;
    }

}
