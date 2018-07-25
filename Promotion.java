package shoppingCart;

public interface Promotion
{
    public double getMinimumPrice();
	
    public void setMinimumPrice(double minimumPrice);
	
    public double getFixedDiscount();
	
    public void setFixedDiscount(double discount);
	
    public boolean isPromotionApplicable(); 
}