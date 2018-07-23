package shoppingCart;

import java.util.*;
public class FixedProductPromotion implements Promotion
{
	double minimumPrice, discount;
	List<PromotionEnum> listOfFixedOrderPromotion;
	public FixedProductPromotion()
	{
		listOfFixedOrderPromotion=new ArrayList<PromotionEnum>();
		listOfFixedOrderPromotion.add(PromotionEnum.FLAT10);
		minimumPrice=200.0;
		discount=10.0;                   //discount is in percentage
	}
	@Override
	public double getMinimumPrice()
	{
		return minimumPrice;
	}
	@Override
	public void setMinimumPrice(double minimumPrice)
	{
		this.minimumPrice = minimumPrice;	
	}
	@Override
	public double getFixedDiscount() 
	{
		return discount;
	}
	@Override
	public void setFixedDiscount(double discount) 
	{
		this.discount = discount;
		
	}
         /*
	 * Checks whether promotion is applicable or not
	 * @return returns true if promotion is applicable otherwise false
	 */
	@Override
	public boolean isPromotionApplicable()
	{
		Date currentDate=new Date();
		boolean isApply=false;
		for(PromotionEnum promotion:listOfFixedOrderPromotion)
		{
				if(currentDate.after(promotion.getStartDate().getTime()) && currentDate.before(promotion.getEndDate().getTime()))
				{
					isApply=true;
					break;
				}
				else
				{
					isApply=false;
				}
		}
		return isApply;
	}
}