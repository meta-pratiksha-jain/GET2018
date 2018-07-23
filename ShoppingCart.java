package shoppingCart;

import java.util.*;


public class ShoppingCart {
    List<Item> itemList;
    ShoppingCart()
    {
	 itemList=new ArrayList<Item>();	 
    }
    /*
    * add an item to the cart
    * @param name contains the name of the item
    */
    public void addItem(String name)
    {
	 Iterator<Item> iteratorInstanceofCart = itemList.iterator();
	 Iterator<Item> iteratorInstanceOfStore=Shopping_Cart.listOfItemsInStore.iterator();
	 boolean flag=false;
	 Item itemOfStore;
	 while(iteratorInstanceOfStore.hasNext())
	 {
		 itemOfStore=iteratorInstanceOfStore.next();
		 if(itemOfStore.getName().equals(name))
		 {
			 while (iteratorInstanceofCart.hasNext())
	         {
	    	     Item item=iteratorInstanceofCart.next();
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
	        	 double price=itemOfStore.getPrice();
		     Item item=new Item(name,price,1);
		     itemList.add(item);
	         }
		 }
	 }
         
    }
    /*
    * removes an item from the cart
    * @param name contains the name of the item to be removed 
    */
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
/*
    * display items of the cart
    */
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
 /*
    * generates bill of items in the cart
    * @return sum contains total bill of the items
    */
 public double generateBill()
 {
	 Iterator<Item> itr = itemList.iterator();
	 double sum=0.0;
	 Promotion promotionInstance=new FixedProductPromotion();
	 boolean isApply=promotionInstance.isPromotionApplicable();
	 while(itr.hasNext())
	 {
		 Item item=itr.next();
		 double price=item.getPrice();
		 int quantity=item.getQuantity();
		 if(isApply)
		 {
		 if(price>=promotionInstance.getMinimumPrice());
		 {
			 //FixedDiscount is in percentage
			 price=price-price*promotionInstance.getFixedDiscount()/100;
		 }
		 }
		 sum=sum+price*quantity;
	 }
	 promotionInstance=new FixedOrderPromotion();
	 double totalDiscount=0.0;
	 if(promotionInstance.isPromotionApplicable() && sum>=promotionInstance.getMinimumPrice())
	 {
		totalDiscount=promotionInstance.getFixedDiscount();
	 }
	 sum=sum-sum*totalDiscount/100;
	 return sum;
 }
}