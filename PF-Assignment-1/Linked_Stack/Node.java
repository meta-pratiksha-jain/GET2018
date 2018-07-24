
public class Node {
 private int data;
 private Node next;
 //Create a node for the Linked List
 Node(int data)
 {
	 this.data=data;
	 next=null;
 }
 public int getData()
 {
	 return data;
 }
 public Node getNext()
 {
	 return this.next;
 }
 public void setNext(Node node)
 {
	 next=node;
 }
}
