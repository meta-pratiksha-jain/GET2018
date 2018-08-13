package nestedList;

import java.io.*;

import java.util.*;

import org.json.*;
import org.json.simple.*;
import org.json.simple.parser.*;

/**
 * this class implements Interface INestedList upto 2 level.
 *
 */
public class NestedList implements INestedList {
    List<List<Integer>> nestedList;
    
    /**
     * constructor
     * It initializes nested list from Json file.
     */
    public NestedList() {
        nestedList=ReadJSON.readJSON();
    }

    @Override
    public int getsum() {
        int sum=0;
        for(List<Integer> listOfInteger:nestedList)
        {
            for(int value:listOfInteger)
            {
                sum=sum+value;
            }
        }
        return sum;
    }

    @Override
    public int getLargestValue() {
        int largestValue=Integer.MIN_VALUE;
        for(List<Integer> listOfInteger:nestedList)
        {
            for(int value:listOfInteger)
            {
                if(largestValue<value)
                {
                    largestValue=value;
                }
            }
        }
        if(largestValue==Integer.MIN_VALUE)
        {
            throw new AssertionError("list is empty");
        }
        return largestValue;
    }

    @Override
    public boolean search(int valueToBeSearch) {
        for(List<Integer> listOfInteger:nestedList)
        {
            for(int value:listOfInteger)
            {
                if(value==valueToBeSearch)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public List<List<Integer>> getNestedList() {
        return nestedList;
    }
    
    

}
