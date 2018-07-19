import java.util.Scanner;

 
public class Shopping_Cart {
 public static void main(String args[])
 {
	 ShoppingCart cart=new ShoppingCart();
	 while(true)
	  {
		  System.out.println("Operations Menu:");
		  System.out.println("1.Add an item in the cart");
		  System.out.println("2.Remove an item from cart");
		  System.out.println("3.Display all items of the cart");
		  System.out.println("4.Generate the bill");
		  System.out.println("5.Exit");
		  System.out.println();
		  System.out.println("Enter Your Choice:");
		  Scanner sc=new Scanner(System.in);
		  int choice=sc.nextInt();
		  switch(choice)
		  {
		  case 1:
			  System.out.println("Enter item name:");
			  sc.nextLine();
			  String addname=sc.nextLine();
			  System.out.println("Enter item price:");
		      double price=sc.nextDouble();
		      cart.addItem(addname, price);;
		      break;
		  case 2:
			  System.out.println("Enter the item name to remove from the cart");
			  sc.nextLine();
			  String removename=sc.nextLine();
			  cart.removeItem(removename);
			  break;
		  case 3:
			  System.out.println("Items:");
			  cart.displayItems();
			  break;
		  case 4:
		      System.out.println("Enter Promocode for promotion:");
			  String promoCode=sc.next();
			  System.out.println("total bill:");
			  System.out.println(cart.generateBill(promoCode));
			  break;
		  case 5:
			  return ;
		  default:
			  System.out.println("Invalid choice");
		  }
		  
	  }
 }
}