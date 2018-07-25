/*
 * 
 */
public class Strings {
	
	public Strings(){}
	
	/*
	 * Compares the equality of two strings
	 * @param str1 contains first string to be compared
	 * @param str2 contains second string to be compared with first
	 * @returns 1 if both strings are equal otherwise false
	 */
	public int compare(String str1, String str2)
	{
		if(str1.length()!=str2.length())
		{
			return 0;
		}
		else
		{
			for(int i=0;i<str1.length();i++)
			{
				if(str1.charAt(i)!=str2.charAt(i))
				{
					return 0;
				}
			}
			return 1;
		}
	}
	
	/*
	 * Reverse the string
	 * @param str contains the string that is to be reversed
	 * @return reversed contains the reversed string
	 */
	public String reverse(String str)
	{
		String reversed="";
		for(int i=str.length()-1;i>=0;i--)
		{
			reversed=reversed+str.charAt(i);
		}
		return reversed;
	}
	
	/*
	 * Change Uppercase characters of the string into lowercase characters of the string and vice versa
	 * @param str contains the string whose character case is to be changed
	 * @return changedCase contains the converted string
	 */
	public String changeCase(String str)
	{
		int asciiOfA=(int)'A';
		int asciiOfa=(int)'a';
		int diffAscii=asciiOfa-asciiOfA;
		String changedCase="";
		for(int i=0;i<str.length();i++)
		{
			int asciiOfChar=(int)str.charAt(i);
			if(asciiOfChar>=asciiOfA && asciiOfChar<=(int)'Z')
			{
				asciiOfChar=asciiOfChar+diffAscii;
				changedCase=changedCase+(char)asciiOfChar;
			}
			else if(asciiOfChar>=asciiOfa && asciiOfChar<=(int)'z')
			{
				asciiOfChar=asciiOfChar-diffAscii;
				changedCase = changedCase+(char)asciiOfChar;
			}
			else
			{
				changedCase = changedCase + str.charAt(i);
			}
		}
		return changedCase;
	}
	
	/*
	 * Find largest word of the string.If number of largest word is greater than one than it will return last word.  
	 * @param str contains the string from which largest word has to find 
	 * @return word contains the largest word of the string
	 */
	public String largestWord(String str) {
		int startLargest = 0;
		int endLargest = 0;
		int startCurrent = 0;
		int lengthLargest = 0;
		int lengthCurrent = 0;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)!=' ')
			{
				lengthCurrent++;
				if(lengthCurrent>=lengthLargest)
				{
					lengthLargest=lengthCurrent;
					startLargest=startCurrent;
					endLargest=i;
				}
			}
			else
			{
				startCurrent=i;
				lengthCurrent=0;
			}
		}
		String word="";
		for(int i=startLargest+1;i<=endLargest;i++)
		{
			word=word+str.charAt(i);
		}
		return word;
	}

}
