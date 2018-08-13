package nestedList;

/**
 * This Interface represents nested list of Integers.
 * 
 */

public interface INestedList {
    
    /**
     * Return the sum of integers in nested list.
     * @return returns sum.
     */
    public int getsum();
    
    /**
     * finds largest value from the nested list
     * @return returns largest value.
     */
    public int getLargestValue();
    
    /**
     * search the value in the nested list
     * @param value
     * @return returns true if value is found in nested list otherwise returns false.
     */
    public boolean search(int value);

}
