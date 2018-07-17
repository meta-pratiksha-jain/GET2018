
public class Item {
 private String name;
 private double price;
 private int quantity;
 Item(String name,double price)
 {
	 this.name=name;
	 this.price=price;
	 this.quantity=1;
 }
 public String getName()
 {
	 return name;
 }
 public double getPrice()
 {
	 return price;
 }
 public int getQuantity()
 {
	 return quantity;
 }
 public void setQuantity(int newQuantity)
 {
	 quantity=newQuantity;
 }
}
