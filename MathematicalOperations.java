public class MathematicalOperations {
	int resultOfLCM;
	
	/*
	 * constructor initializes resultOfLCM variable.
	 */
	public MathematicalOperations()
	{
		resultOfLCM=1;
	}
	
	/*
	 * finds LCM of two numbers
	 * @param number1 contains first number to find LCM
	 * @param number2 contains second number 
	 * @return resultOfLCM contains LCM of number1 and number2
	 */
	public int LCMOfTwoNumbers(int number1,int number2)
	{
		if(resultOfLCM%number1==0 && resultOfLCM%number2==0)
		{
			return resultOfLCM;
		}
		else
		{
			resultOfLCM++;
			return LCMOfTwoNumbers(number1, number2);
		}
	}
	
	/*
	 * finds HCF of two numbers
	 * @param number1 contains first number to find HCF
	 * @param number2 contains second number 
	 * @return number2 contains HCF of two numbers
	 */
	public int HCFOfTwoNumbers(int number1,int number2)
	{
		if(number1==0)
		{
			return number2;
		}
		else
		{
			if(number1>number2)
			{
			    return HCFOfTwoNumbers(number1%number2,number2);
			}
			else
			{
				return HCFOfTwoNumbers(number2%number1,number1); 	
			}
		}
	}

}
