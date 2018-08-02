package stack;

/**
 * This class implements IStack interface using array.
 *
 * @param <T> is generic type.
 */
public class StackUsingArray<T> implements IStack<T> {
    private int top;
    private T[] stack;
    
    public  StackUsingArray(int stackSize) {
        top=0;
        stack=(T[])new Object[stackSize];
    }

    @Override
    public boolean push(T element) {
        boolean isPushed=false;
        if(top!=stack.length)
        {
            stack[top]=element;
            top++;
            isPushed=true;
            return isPushed;
        }
        return isPushed;
    }

    @Override
    public T pop() {
        boolean isStackEmpty=isEmpty();
        if(isStackEmpty)
        {
            throw new AssertionError("Stack is empty");
        }
        top--;
        T element=stack[top];
        return element;
    }

    @Override
    public boolean isEmpty() {
        if(top==0)
        {
            return true;
        }
        return false;
    }

    /**
     * Checks whether Stack is full or not
     * @return returns true if stack is full otherwise false
     */
    public boolean isFull() {
        if(top==stack.length)
        {
            return true;
        }
        return false;
    }

}
