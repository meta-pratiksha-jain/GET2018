import java.util.*;
public class Array_Stack
{
 private int topp=0;
 private int[] stack;
 public Array_Stack()
 {
  stack=new int[10];
 }
 //push the element into Stack
 public int push(int x)
 {
  if(top()==10)
   return -1;
  else
  {
   stack[topp]=x;
   topp++;
   return 0;
  }
 }
 //Pop the element from stack and returns the element
 public int pop()
 {
  if(isEmpty()==true)
  {
	  throw new NoSuchElementException("Underflow Exception") ;
  }
  else
  {
   topp--;
   int x=stack[topp];
   return x;
  }
 }
 //returns the top of the element
 public int top()
 {
  return topp;
 }
 //checks whether stack is empty or not
 public boolean isEmpty()
 {
  if(top()==0)
   return true;
  else
   return false;
 }

}