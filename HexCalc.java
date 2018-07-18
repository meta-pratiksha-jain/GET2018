
public class HexCalc {
	private final int BASE=16;
	private char[] hexChar={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	/*
	 * add two hexadecimal numbers
	 * @param hexnum1 is hexadecimal string
	 * @param hexnum2 is another hexadecimal number that should be added to first number
	 * @return hexResult hexadecimal number that is result of addition
	 */
	public String add(String hexNum1, String hexNum2)
	{
		int decimalRes=hexToDecimal(hexNum1)+hexToDecimal(hexNum2);
		String hexResult=decimalToHex(decimalRes);
		return hexResult;
	}
	/*
	 * subtract two hexadecimal numbers
	 * @param hexnum1 is hexadecimal string
	 * @param hexnum2 is another hexadecimal number that should be subtracted from first number
	 * @return hexResult hexadecimal number that is result of subtraction
	 */
	public String subtract(String hexNum1, String hexNum2)
	{
		int decimalRes=hexToDecimal(hexNum1)-hexToDecimal(hexNum2);
		String hexResult=decimalToHex(decimalRes);
		return hexResult;
	}
	/*
	 * multiply two hexadecimal numbers
	 * @param hexnum1 is hexadecimal string
	 * @param hexnum2 is another hexadecimal number that should be multiplied to first number
	 * @return hexResult hexadecimal number that is result of multiplication
	 */
	public String multiply(String hexNum1, String hexNum2)
	{
		int decimalRes=hexToDecimal(hexNum1)*hexToDecimal(hexNum2);
		String hexResult=decimalToHex(decimalRes);
		return hexResult;
	}
	/*
	 * divide two hexadecimal numbers
	 * @param hexnum1 is hexadecimal string
	 * @param hexnum2 is another hexadecimal number that should divide the first number
	 * @return hexResult hexadecimal number that is result of division
	 */
	public String divide(String hexNum1, String hexNum2)
	{
		int num1=hexToDecimal(hexNum1);
		int num2=hexToDecimal(hexNum2);
		if(num2==0)
		{
			throw new ArithmeticException();
		}
		String hexResult=decimalToHex(num1/num2);
		return hexResult;
	}
	/*
	 * convert hexadecimal number to decimal
	 * @param hex is hexadecimal number that should be converted into decimal
	 * @return decimal is converted decimal number
	 */
	public int hexToDecimal(String hex)
	{
		String tempHex=hex.toLowerCase();
		int decimal=0;
		int index=hex.length()-1;
		
		for(int i=0;i<hex.length();i++)
		{
			
			int value=0;
			for(int j=0;j<hexChar.length;j++)
			{
				if(hexChar[j]==tempHex.charAt(i))
				{
					value=j;
					break;
				}
			}
			decimal=decimal+value*(int)Math.pow(BASE, index);
			index=index-1;
		}
		return decimal;
	}
	/*
	 * convert decimal number to hexadecimal
	 * @param decimal is decimal number that should be converted into hexadecimal
	 * @return hex is converted hexadecimal number
	 */
	public String decimalToHex(int decimal)
	{
		String hex="";
		for(int i=decimal;i>0;i=i/BASE)
		{
			int remainder=i%BASE;
			hex=hexChar[remainder]+hex;
		}
		return hex;
	}
	/*
	 * compares two hexadecimal numbers whether they are equal or not
	 * @param hexnum1 is hexadecimal string
	 * @param hexnum2 is another hexadecimal number for comparison
	 * @return true if both numbers are equal otherwise false
	 */
	public boolean equalsTo(String hexNum1,String hexNum2)
	{
		if(hexNum1.length()!=hexNum2.length())
		{
			return false;
		}
		else
		{
		    String hex1=hexNum1.toLowerCase();
		    String hex2=hexNum2.toLowerCase();
		    for(int i=0;i<hex1.length();i++)
		    {
		    	if(hex1.charAt(i)!=hex2.charAt(i))
		    	{
		    		return false;
		    	}
		    }
		    return true;
		}
	}
	/*
	 * compares two hexadecimal numbers whether one is greater than other or not
	 * @param hexnum1 is hexadecimal string
	 * @param hexnum2 is another hexadecimal number for comparison
	 * @return true if first number is greater than second otherwise false
	 */
	public boolean greaterThan(String hexNum1,String hexNum2)
	{
		if(hexNum1.length()>hexNum2.length())
		{
			return true;
		}
		else if(hexNum1.length()<hexNum2.length())
		{
			return false;
		}
		else
		{
			String hex1=hexNum1.toLowerCase();
		    String hex2=hexNum2.toLowerCase();
		    for(int i=0;i<hex1.length();i++)
		    {
		    	if(hex1.charAt(i)>hex2.charAt(i))
		    	{
		    	    return true;
		    	}
		    }
		    return false;
		}
	}
	/*
	 * compares two hexadecimal numbers whether one is less than other or not
	 * @param hexnum1 is hexadecimal string
	 * @param hexnum2 is another hexadecimal number for comparison
	 * @return true if first number is less than second otherwise false
	 */
	public boolean lessThan(String hexNum1,String hexNum2)
	{
		if(hexNum1.length()<hexNum2.length())
		{
			return true;
		}
		else if(hexNum1.length()>hexNum2.length())
		{
			return false;
		}
		else
		{
			String hex1=hexNum1.toLowerCase();
		    String hex2=hexNum2.toLowerCase();
		    for(int i=0;i<hex1.length();i++)
		    {
		    	if(hex1.charAt(i)<hex2.charAt(i))
		    	{
		    	    return true;
		    	}
		    }
		    return false;
		}
	}

}
