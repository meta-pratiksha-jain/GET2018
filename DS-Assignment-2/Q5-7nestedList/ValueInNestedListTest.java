package nestedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValueInNestedListTest {
    ValueInNestedList nestedList;

    //test cases for getValue()
    @Test
    public void testGetValueShouldReturnValueWhenPositionContainValue() {
        nestedList=new ValueInNestedList();
        int value=nestedList.getValue("THH");
        assertEquals(10,value);
    }
    
    @Test(expected=AssertionError.class)
    public void testGetValueShouldThrowExceptionWhenPositionEndWithT() {
        nestedList=new ValueInNestedList();
        nestedList.getValue("THTT");
    }
    
    @Test(expected=AssertionError.class)
    public void testGetValueShouldThrowExceptionWhenPositionNotExist() {
        nestedList=new ValueInNestedList();
        nestedList.getValue("THTHTTTH");
    }
    
    @Test(expected=AssertionError.class)
    public void testGetValueShouldThrowExceptionWhenPositionContainsList() {
        nestedList=new ValueInNestedList();
        nestedList.getValue("HTTT");
    }

}
