import java.util.*;
public class HexCalcTest {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		HexCalc hexCalc=new HexCalc();
		while(true)
		{
			System.out.println("Operations on hexadecimal number:");
			System.out.println("Arithmetic Operations");
			System.out.println("1.Addition");
			System.out.println("2.Subtraction");
			System.out.println("3.Multiplication");
			System.out.println("4.Division");
			System.out.println();
			System.out.println("Comparison Operations");
			System.out.println("5.Equal(=)");
			System.out.println("6.Greater than(>)");
			System.out.println("7.Less than(<)");
			System.out.println();
			System.out.println("Conversion");
			System.out.println("8.Hexadecimal to decimal");
			System.out.println("9.desimal to hexadecimal");
			System.out.println();
			System.out.println("10.Exit");
			System.out.println();
			System.out.println("Enter your choice:");
			int choice=sc.nextInt();
			String hex1,hex2;
			switch(choice)
			{
			case 1:
				System.out.println("Enter first Hexadecimal number:");
				hex1=sc.next();
				System.out.println("Enter second hexadecimal number");
				hex2=sc.next();
				System.out.println(hexCalc.add(hex1, hex2));
				break;
			case 2:
				System.out.println("Enter first Hexadecimal number:");
				hex1=sc.next();
				System.out.println("Enter second hexadecimal number");
				hex2=sc.next();
				System.out.println(hexCalc.subtract(hex1, hex2));
	 		    break;
			case 3:
				System.out.println("Enter first Hexadecimal number:");
				hex1=sc.next();
				System.out.println("Enter second hexadecimal number");
				hex2=sc.next();
				System.out.println(hexCalc.multiply(hex1, hex2));
				break;
			case 4:
				System.out.println("Enter first Hexadecimal number:");
				hex1=sc.next();
				System.out.println("Enter second hexadecimal number");
				hex2=sc.next();
				System.out.println(hexCalc.divide(hex1, hex2));
				break;
			case 5:
				System.out.println("Enter first Hexadecimal number:");
				hex1=sc.next();
				System.out.println("Enter second hexadecimal number");
				hex2=sc.next();
				System.out.println(hex1+"is equal to"+hex2+hexCalc.equalsTo(hex1, hex2));
				break;
			case 6:
				System.out.println("Enter first Hexadecimal number:");
				hex1=sc.next();
				System.out.println("Enter second hexadecimal number");
				hex2=sc.next();
				System.out.println(hex1+"is greater than"+hex2+hexCalc.greaterThan(hex1, hex2));
				break;
			case 7:
				System.out.println("Enter first Hexadecimal number:");
				hex1=sc.next();
				System.out.println("Enter second hexadecimal number");
				hex2=sc.next();
				System.out.println(hex1+"is less than"+hex2+hexCalc.lessThan(hex1, hex2));
				break;
			case 8:
				System.out.println("Enter a hexadecimal number");
				sc.nextLine();
				String hex=sc.nextLine();
				System.out.println(hexCalc.hexToDecimal(hex));
				break;
			case 9:
				System.out.println("Enter a decimal number");
				int decimal=sc.nextInt();
				System.out.println(hexCalc.decimalToHex(decimal));
				break;
			case 10:
				return;
			default:
				System.out.println("Invalid Choice");
			}
		}
	}

}
