import java.util.*;
public class ArrOperation {

	/*
	 * find largest length of mirror elements in array
	 * @param array contains array elements 
	 * @return largestLength contains largest length of mirror elements in array
	 */
	public int largestMirror(int[] array)
	{
	    if(array.length==0)
	    {
	        throw new AssertionError("Array is empty");
	    }
		int mirrorLength=0;
		int largestLength=0;
		for(int i=0;i<array.length;i++)
		{
			for(int j=array.length-1;j>i;j--)
			{
				mirrorLength=0;
				if(array[i]==array[j])
				{
					int index=i;
					int mirrorIndex=j;
					while(index<array.length && mirrorIndex>=0)
					{
						if(array[index]==array[mirrorIndex])
						{
						    mirrorLength++;
						    index++;
						    mirrorIndex--;
						}
						else
						{
							break;
						}
					}
					if(largestLength<mirrorLength)
					{
						largestLength=mirrorLength;
						mirrorLength=0;
					}
				}
			}
		}
		return largestLength;
	}
	
	/*
	 * Counts number of clumps in an array, where clump is the two or more same consecutive elements in an array 
	 * @param array contains array elements 
	 * @return numberOfClumps contains total number of clumps in array
	 */
	public int countClumps(int[] array)
	{
	    if(array.length==0)
        {
            throw new AssertionError("Array is empty");
        }
		int numberOfClumps=0;
		for(int i=0;i<array.length-1;i++)
		{
			if(array[i]==array[i+1])
			{
				if(i==0)
				{
					numberOfClumps++;
				}
				else if(array[i-1]!=array[i])
				{
					numberOfClumps++;
				}
			}
		}
		return numberOfClumps;
	}
	
	/*
	 * fixes array elements in such a way that element Y comes just after the element X in array by moving element Y only. Position of elemnet Y can't be changed. 
	 * @param array contains array elements
	 * @param x contains element X which can't be moved from its position in array
	 * @param y contains element y which is shifted to fix X and Y 
	 * @return array contains array of elements after fixXY
	 */
	public int[] fixXY(int[] array,int x,int y)
	{
	    int indexOfY=0;
	    if(array.length==0)
        {
            throw new AssertionError("Array is empty");
        }
	    if(array[array.length-1]==x)
	    {
	        throw new AssertionError(x+"is at last index of array");
	    }
	    for(int i=0;i<array.length;i++)
	    {
	        if(array[i]==x)
	        {
	            if(array[i+1]==x)
	            {
	                throw new AssertionError("two "+x+" are at consecutive place");
	            }
	            if(array[i+1]!=y)
	            {
	                for(int j=indexOfY;j<array.length;j++)
	                {
	                    if(array[j]==y)
	                    {
	                    if(j==0)
	                    {
	                        int swap=array[i+1];
	                        array[i+1]=array[j];
	                        array[j]=swap;
	                        indexOfY=j+1;
	                        break;
	                    }
	                    else if(array[j-1]!=x)
	                    {
	                        int swap=array[i+1];
                            array[i+1]=array[j];
                            array[j]=swap;
                            indexOfY=j+1;
                            break;
	                    }
	                    else if(j==array.length-1)
	                    {
	                        throw new AssertionError("there are unequal numbers of "+x+" and "+y);
	                    }
	                    }
	                }
	            }
	        }
	    }
		return array;
	}
	
	/*
	 * Split the array in a way such that sum of elements of left array is equal to sum of elements of right array
	 * @param array contains array elements 
	 * @return index contains index of array at which array has split.
	 */
	public int splitArray(int[] array)
	{
	    if(array.length==0)
        {
            throw new AssertionError("Array is empty");
        }
		int index=0;
		int sumLeft=0;
		int sumRight=0;
		for(int i=0,j=array.length-1;i<=j;)
		{
			if(sumLeft==sumRight)
			{
				if(i==j)
				{
					index=-1;
					break;
				}
				else
				{
					sumLeft=sumLeft+array[i];
					sumRight=sumRight+array[j];
					index=j;
					i++;
					j--;
				}
			}
			else if(sumLeft>sumRight)
			{
				sumRight=sumRight+array[j];
				index=j;
				j--;
			}
			else
			{
				sumLeft=sumLeft+array[i];
				i++;
			}
		}
		return index;
	}
}
