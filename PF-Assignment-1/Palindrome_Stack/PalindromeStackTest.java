import java.util.*;
public class PalindromeStackTest {
	public static void main(String args[])
	{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String to check whether it is Palindrome or not");
        sc.nextLine();
        String str=sc.nextLine();
        PalindromeStack object=new PalindromeStack();
        boolean flag=object.checkPalindrome(str);
        if(flag)
	        System.out.println("String "+str+" is palindrome");
        else
	        System.out.println("String "+str+" is not palindrome");
    }
}
