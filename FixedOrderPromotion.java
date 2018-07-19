import java.util.*;
public class FixedOrderPromotion implements Promotion
{
	double minimumPrice, discount;
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
	 * Checks whether promotion is applicable on promocode enterd by user
	 * @param code is the promotion code that should be checked
	 * @return returns true if promotion is applicable otherwise false
	 */
	@Override
	public boolean isPromotionApplicable(String code)
	{
		Date currentDate=new Date();
		boolean isApply=false;
		for(PromotionEnum promo:PromotionEnum.values())
		{
			if(code.equals(promo.getCode()))
			{
				if(currentDate.after(promo.getStartDate().getTime()) && currentDate.before(promo.getEndDate().getTime()))
				{
					isApply=true;
				}
				else
				{
					isApply=false;
				}
			}
		}
		return isApply;
	}
}