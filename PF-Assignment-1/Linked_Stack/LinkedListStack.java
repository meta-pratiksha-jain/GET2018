import java.util.*;
public class LinkedListStack {
 private Node top;
 LinkedListStack()
 {
	 top=null;
 }
 //Returns the reference of top of the stack
 public Node top()
 {
	 return top;
 }
 //Checks whether the stack is empty or not
 public boolean isEmpty()
 {
	 if(top==null)
		 return true;
	 else
		 return false;
 }
 //Push the element into stack
 public void push(int x)
 {
	 Node n=new Node(x);
	 n.setNext(top);
	 top=n;
 }
 //Pop the element from stack and return the element
 public int pop()
 {
	 if(isEmpty())
	 {
		 throw new NoSuchElementException("Underflow Exception") ;
	 }
	 else
	 {
		Node node=top;
		top=node.getNext();
		return node.getData();
	 }		 
 }
}
