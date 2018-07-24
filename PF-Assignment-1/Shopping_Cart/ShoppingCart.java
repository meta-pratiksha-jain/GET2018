import java.util.*;


public class ShoppingCart {
  List<Item> itemList;
 ShoppingCart()
 {
	 itemList=new ArrayList<Item>();
	 
 }
 //add an item in the cart
 public void addItem(String name, double price)
 {
	 Iterator<Item> itr = itemList.iterator();
	 boolean flag=false;
     while (itr.hasNext())
     {
    	 Item item=itr.next();
    	 if(item.getName().equals(name))
    	 {
    		 int newQuantity=item.getQuantity();
    		 item.setQuantity(newQuantity+1);
    		 flag=true;
    		 break;
         }
     }
     if(!flag)
     {
	     Item item=new Item(name,price);
	     itemList.add(item);
     }
 }
 //Remove an item from the cart
 public void removeItem(String name)
 {
	 Iterator<Item> itr = itemList.iterator();
     while (itr.hasNext())
     {
    	 Item item=itr.next();
    	 if(item.getName().equals(name))
    	 {
    		 int quantity=item.getQuantity();
    		 if(quantity==1)
    		 {
    			 itemList.remove(item);
    			 break;
    		 }
    		 else
    		 {
    			 item.setQuantity(quantity-1);
    		     break;
    		 }
         }
     }
 }
 //Display items stored in cart 
 public void displayItems()
 {
	 Iterator<Item> itr = itemList.iterator();
	 while(itr.hasNext())
	 {
		 Item item=itr.next();
		 System.out.println("Item name: "+item.getName());
		 System.out.println("price: "+item.getPrice());
		 System.out.println("quantity: "+item.getQuantity());
		 System.out.println();
	 }
 }
 //Generates bill for the items in cart
 public double generateBill()
 {
	 Iterator<Item> itr = itemList.iterator();
	 double sum=0.0;
	 while(itr.hasNext())
	 {
		 Item item=itr.next();
		 int quantity=item.getQuantity();
		 sum=sum+item.getPrice()*quantity;
	 }
	 return sum;
 }
}
