package nestedList;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Test;

public class NestedListTest {
    NestedList nestedList;

    //test cases for getSum()
    @Test
    public void testGetSumShouldReturnSumOfIntegersInNestedList() {
        nestedList=new NestedList();
        int sum=nestedList.getsum();
        assertEquals(420,sum);
    }
    
    //test cases for getLargestValue()
    @Test
    public void testGetLargestValueShouldReturnLargestValueFromNestedList() {
        nestedList=new NestedList();
        int largest=nestedList.getLargestValue();
        assertEquals(66,largest);
    }
    
    //test cases for search()
    @Test
    public void testSearchShouldReturnTrueWhenValueIsPresent() {
        nestedList=new NestedList();
        boolean isPresent=nestedList.search(10);
        assertEquals(true,isPresent);
    }
    
    @Test
    public void testSearchShouldReturnFalseWhenValueNotPresent() {
        nestedList=new NestedList();
        boolean isPresent=nestedList.search(70);
        assertEquals(false,isPresent);
    }

}
