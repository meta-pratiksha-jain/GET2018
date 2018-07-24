import java.util.Scanner;


public class LinkedListStackTest {
 public static void main(String args[])
 {
	 LinkedListStack stack=new LinkedListStack();
	 while(true)
	  {
		  System.out.println("Operations Menu:");
		  System.out.println("1.Push an Integer into Stack");
		  System.out.println("2.Pop from stack");
		  System.out.println("3.Top of Stack");
		  System.out.println("4.Check whether stack is empty");
		  System.out.println("5.Exit");
		  System.out.println();
		  System.out.println("Enter Your Choice:");
		  Scanner sc=new Scanner(System.in);
		  int choice=sc.nextInt();
		  switch(choice)
		  {
		  case 1:
			  System.out.println("Enter an element to push into stack");
		      int element=sc.nextInt();
		      stack.push(element);
		      break;
		  case 2:
			  System.out.println(stack.pop());
			  break;
		  case 3:
			  System.out.println(stack.top());
			  break;
		  case 4:
			  if(stack.isEmpty())
			  {
				  System.out.println("stack is empty");
			  }
			  else
			  {
				  System.out.println("stack is not empty");
			  }
			  break;
		  case 5:
			  return ;
		  default:
			  System.out.println("Invalid choice");
		  }
		  
	  }
 }
}
