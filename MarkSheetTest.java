import java.util.*;


public class MarkSheetTest {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Marksheet marksheet=new Marksheet();
		System.out.println("Enter number of students:");
		int num=sc.nextInt();
		int[] grades=new int[num];
		System.out.println("Enter grades of students. Grades must be between 0 and 100(inclusive)");
		for(int i=0;i<num;i++)
		{
			grades[i]=sc.nextInt();
		}
		while(true)
		{
		    System.out.println("Operations:");
		    System.out.println("1.Average of grades of all students");
		    System.out.println("2.Maximum from all grades");
		    System.out.println("3.Minimum from all grades");
		    System.out.println("4.Percentage of the students who are passed");
		    System.out.println("5.Exit");
		    System.out.println();
		    System.out.println("enter your choice in the form of integer:");
		    int choice=sc.nextInt();
		    switch(choice)
		    {
		    case 1:
		    	System.out.println("Average of grades: "+marksheet.average(num, grades));
		    	break;
		    case 2:
		    	System.out.println("Maximum grade: "+marksheet.maximum(num, grades));
		    	break;
		    case 3:
		    	System.out.println("Minimum grade: "+marksheet.minimum(num, grades));
		    	break;
		    case 4:
		    	System.out.println("Percentage of students who are passed: "+marksheet.percentPassed(num, grades)+"%");
		    	break;
		    case 5:
		    	return;
		    default:
		    	System.out.println("Invalid choice");
		    }
		}
	}

}
