package shoppingCart;

import java.util.*;


public class Shopping_Cart {
	public static List<Item> listOfItemsInStore=new ArrayList<Item>();
    public static void main(String args[])
    {
	    ShoppingCart cart=new ShoppingCart();
	 
	    listOfItemsInStore.add(new Item("bag", 1450.0,2));
	    listOfItemsInStore.add(new Item("soap", 30.0,10));
	    listOfItemsInStore.add(new Item("tshirt", 400.0,5));
	    listOfItemsInStore.add(new Item("book", 100.0,5));
	    Iterator iteratorInstance=listOfItemsInStore.iterator();
	    System.out.println("List of items in store");
	    System.out.println("Name   Price  Quantity");
	    while(iteratorInstance.hasNext())
	    {
		    Item item=(Item) iteratorInstance.next();
		    System.out.println(item.getName()+"  "+item.getPrice()+"  "+item.getQuantity());
	    }
	    while(true)
	    {
		    System.out.println("Operations Menu:");
		    System.out.println("1.Choose an item name from the displayed list to add it in cart");
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
		        cart.addItem(addname);
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
			    System.out.println("total bill:");
			    System.out.println(cart.generateBill());
			    break;
		    case 5:
			    return ;
		    default:
			    System.out.println("Invalid choice");
		    }
		  
	    }
    }
}