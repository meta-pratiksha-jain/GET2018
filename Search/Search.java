public class Search {
    
    /*
     * search an element in an array
     * @param array contains array of elements
     * @param index contains index of array at which element is to be searched
     * @param elementToSearch contains element to be search in an array
     * @return index contains the index of the array at which element is found.If element is not found then it will return -1.
     */
    public int linearSearch(int[] array,int index, int elementToSearch)
    {
        if(array.length==0)
        {
            throw new AssertionError("array is empty");
        }
        if(index==array.length)
        {
            return index=-1;
        }
        if(array[index]==elementToSearch)
        {
            return index;
        }
        else
        {
            return linearSearch(array,++index,elementToSearch);
        }
    }
    
    /*
     * search an element in an array using binary search algorithm
     * @param array contains array of elements
     * @param startIndex contains starting index of array
     * @param endIndex contains last index of array
     * @param elementToSearch contains element to be search in an array
     * Assume array is sorted
     * @return index contains the index of the array at which element is found.If element is not found then it will return -1.
     */
    public int binarySearch(int[] array,int startIndex,int endIndex,int elementToSearch)
    {
        if(array.length==0)
        {
            throw new AssertionError("array is empty");
        }
        int middleIndex=(startIndex+endIndex)/2;
        if(startIndex>endIndex)
        {
            return -1;
        }
        if(array[middleIndex]==elementToSearch)
        {
            return middleIndex;
        }
        else
        {
            if(elementToSearch<array[middleIndex])
            {
                return binarySearch(array, startIndex, middleIndex-1, elementToSearch);
            }
            else
            {
                return binarySearch(array, middleIndex+1, endIndex, elementToSearch);
            }
        }
    }

}
