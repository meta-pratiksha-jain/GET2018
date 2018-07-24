import java.util.*;
public class PalindromeStack {
 //Checks whether a string is palindrome or not
 public boolean checkPalindrome(String str)
 {
	 boolean flag=true;
	 Stack<Character> stack=new Stack<Character>();
	 int middle=str.length()/2;
	 for(int i=0;i<middle;i++)
	 {
		 stack.push(str.charAt(i));
	 }
	 if((str.length()%2)==0)
	 {
		 for(int i=middle;i<str.length();i++)
		 {
			 if(stack.pop()!=str.charAt(i))
				 flag=false;
		 }
	 }
	 else
	 {
		 for(int i=middle+1;i<str.length();i++)
		 {
			 if(stack.pop()!=str.charAt(i))
				 flag=false;
		 }
	 }
	 return flag;
 }
}
