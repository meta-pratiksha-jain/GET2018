import java.util.*;
public class AreaTest {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Area area=new Area();
		
		while(true)
		{
		    System.out.println("Calculate area of :");
		    System.out.println("1.Triangle");
		    System.out.println("2.Rectangle");
		    System.out.println("3.Square");
		    System.out.println("4.Circle");
		    System.out.println("5.Exit");
		    System.out.println();
		    System.out.println("enter your choice in the form of integer:");
		    int choice=sc.nextInt();
		    switch(choice)
		    {
		    case 1:
		    	System.out.println("Enter base and height of triangle:");
		    	double base=sc.nextDouble();
		    	double height=sc.nextDouble();
		    	System.out.println("Area of triangle with base "+base+" height "+height+" is:"+area.areaTriangle(base, height));
		    	break;
		    case 2:
		    	System.out.println("Enter width and length of rectangle:");
		    	double width=sc.nextDouble();
		    	double length=sc.nextDouble();
		    	System.out.println("Area of reactangle with width "+width+" length "+length+" is:"+area.areaRectangle(width, length));
		    	break;
		    case 3:
		    	System.out.println("Enter side of square:");
		    	double side=sc.nextDouble();
		    	System.out.println("Area of square with side "+side+" is:"+area.areaSquare(side));
		    	break;
     	    case 4:
		    	System.out.println("Enter radius of circle:");
		    	double radius=sc.nextDouble();
		    	System.out.println("Area of circle with radius"+radius+" is:"+area.areaCircle(radius));
		    	break;
     	    case 5:
     	    	return;
		    default:
		    	System.out.println("Invalid choice");
		    }
		}
	}


}
