import java.util.*;
public class StringsTest {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Strings string = new Strings();
		while(true)
		{
		    System.out.println("String Operations:");
		    System.out.println("1.Compare the equality of strings");
		    System.out.println("2.reverse the String");
		    System.out.println("3.Change Case of the String");
		    System.out.println("4.Find the largest word in String");
		    System.out.println("5.Exit");
		    System.out.println();
		    System.out.println("enter your choice:");
		    int choice=sc.nextInt();
		    switch(choice)
		    {
		    case 1:
		    	System.out.println("Enter two strings for comparison : ");
		    	sc.nextLine();
		    	String str1=sc.nextLine();
		    	String str2=sc.nextLine();
		    	int isEqual=string.compare(str1, str2);
		    	if(isEqual==1)
		    	{
		    		System.out.println(str1+" and "+str2+" are equal");
		    	}
		    	else
		    	{
		    		System.out.println(str1+" and "+str2+" are not equal");
		    	}
		    	break;
		    case 2:
		    	System.out.println("Enter a string that should be reversed : ");
		    	sc.nextLine();
		    	String strRev=sc.nextLine();
		    	System.out.println(string.reverse(strRev));
		    	break;
		    case 3:
		    	System.out.println("Enter a string to change the uppercase and lowercase characters : ");
		    	sc.nextLine();
		    	String strCase=sc.nextLine();
		    	System.out.println(string.changeCase(strCase));
		    	break;
		    case 4:
		    	System.out.println("Enter a string to find largest word in it : ");
		    	sc.nextLine();
		    	String strLarge=sc.nextLine();
		    	System.out.println(string.largestWord(strLarge));
		    	break;
		    case 5:
		    	return;
		    default:
		    	System.out.println("Invalid choice");
		    }
		}
	}

}
