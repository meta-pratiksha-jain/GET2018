import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class IntSetTest {

    //Test cases for isMember()
    @Test
    public void testisMemberWithIntegerPresentInTheList() {
        int[] inputArray={4,5,3,2,6,7,32,48};
        IntSet intSetInstance=new IntSet(inputArray);
        boolean actualOutput=intSetInstance.isMember(7);
        boolean expectedOutput=true;
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testisMemberWithIntegerNotPresentInTheList() {
        int[] inputArray={4,5,3,2,6,7,32,48};
        IntSet intSetInstance=new IntSet(inputArray);
        boolean actualOutput=intSetInstance.isMember(9);
        boolean expectedOutput=false;
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testisMemberWithEmptyArray() {
        int[] inputArray={};
        IntSet intSetInstance=new IntSet(inputArray);
        boolean actualOutput=intSetInstance.isMember(7);
        boolean expectedOutput=false;
        assertEquals(expectedOutput, actualOutput);
    }
    
    //Test cases for getSize()
    @Test
    public void testGetSize() {
        int[] inputArray={4,5,3,2,6,7,32,48};
        IntSet intSetInstance=new IntSet(inputArray);
        int actualOutput=intSetInstance.getSize();
        int expectedOutput=8;
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testGetSizeWithEmptyArray() {
        int[] inputArray={};
        IntSet intSetInstance=new IntSet(inputArray);
        int actualOutput=intSetInstance.getSize();
        int expectedOutput=0;
        assertEquals(expectedOutput, actualOutput);
    }

    //Test cases for isSubSet()
    @Test
    public void testIsSubSetWithAllIntegersOfSubSetPresentInSuperSet() {
        int[] inputArray={4,5,3,2,6,7,32,48};
        IntSet intSetInstance=new IntSet(inputArray);
        int[] inputSubSet={3,2,32};
        IntSet subSetInstance=new IntSet(inputSubSet);
        boolean actualOutput=intSetInstance.isSubSet(subSetInstance);
        boolean expectedOutput=true;
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testIsSubSetWithSomeIntegersOfSubSetPresentInSuperSet() {
        int[] inputArray={4,5,3,2,6,7,32,48};
        IntSet intSetInstance=new IntSet(inputArray);
        int[] inputSubSet={3,2,32,20};
        IntSet subSetInstance=new IntSet(inputSubSet);
        boolean actualOutput=intSetInstance.isSubSet(subSetInstance);
        boolean expectedOutput=false;
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testIsSubSetWithEmptySubSet() {
        int[] inputArray={4,5,3,2,6,7,32,48};
        IntSet intSetInstance=new IntSet(inputArray);
        int[] inputSubSet={};
        IntSet subSetInstance=new IntSet(inputSubSet);
        boolean actualOutput=intSetInstance.isSubSet(subSetInstance);
        boolean expectedOutput=true;
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testIsSubSetWithBothSetsEmpty() {
        int[] inputArray={};
        IntSet intSetInstance=new IntSet(inputArray);
        int[] inputSubSet={};
        IntSet subSetInstance=new IntSet(inputSubSet);
        boolean actualOutput=intSetInstance.isSubSet(subSetInstance);
        boolean expectedOutput=true;
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testIsSubSetWithSubSetIsSuperSet() {
        int[] inputArray={4,5,3,2,6,7,32,48};
        IntSet intSetInstance=new IntSet(inputArray);
        int[] inputSubSet={4,5,3,2,6,7,32,48};
        IntSet subSetInstance=new IntSet(inputSubSet);
        boolean actualOutput=intSetInstance.isSubSet(subSetInstance);
        boolean expectedOutput=true;
        assertEquals(expectedOutput, actualOutput);
    }
    
    //Test cases for getComplement()
    @Test
    public void testGetComplement() {
        int[] inputArray={1,2,3,4,5,6,7,8,9,10};
        IntSet intSetInstance=new IntSet(inputArray);
        IntSet complement=intSetInstance.getComplement();
        int[] actualOutput=complement.getSet();
        Arrays.sort(actualOutput);
        int[] expectedOutput=new int[1000-inputArray.length];
        for(int i=0;i<expectedOutput.length;i++)
        {
            expectedOutput[i]=i+11;
        }
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testGetComplementWithEmptyArray() {
        int[] inputArray={};
        IntSet intSetInstance=new IntSet(inputArray);
        IntSet complement=intSetInstance.getComplement();
        int[] actualOutput=complement.getSet();
        Arrays.sort(actualOutput);
        int[] expectedOutput=new int[1000];
        for(int i=0;i<expectedOutput.length;i++)
        {
            expectedOutput[i]=i+1;
        }
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testGetComplementWithUniversalArray() {
        int[] inputArray=new int[1000];
        for(int i=0;i<inputArray.length;i++)
        {
            inputArray[i]=i+1;
        }
        IntSet intSetInstance=new IntSet(inputArray);
        IntSet complement=intSetInstance.getComplement();
        int[] actualOutput=complement.getSet();
        Arrays.sort(actualOutput);
        int[] expectedOutput= {};
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    //Test Cases for getUnion()
    @Test
    public void testGetUnion() {
        int[] firstInputArray={1,2,3,4,5,6,7,8,9,10};
        IntSet firstInputSet=new IntSet(firstInputArray);
        int[] secondInputArray={1,34,2,5,56,6,8};
        IntSet secondInputSet=new IntSet(secondInputArray);
        IntSet union=firstInputSet.getUnion(secondInputSet);
        int[] actualOutput=union.getSet();
        Arrays.sort(actualOutput);
        int[] expectedOutput= {1,2,3,4,5,6,7,8,9,10,34,56};
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testGetUnionWithOneSetEmpty() {
        int[] firstInputArray={1,2,3,4,5,6,7,8,9,10};
        IntSet firstInputSet=new IntSet(firstInputArray);
        int[] secondInputArray={};
        IntSet secondInputSet=new IntSet(secondInputArray);
        IntSet union=firstInputSet.getUnion(secondInputSet);
        int[] actualOutput=union.getSet();
        Arrays.sort(actualOutput);
        int[] expectedOutput= {1,2,3,4,5,6,7,8,9,10};
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testGetUnionWithBothSetEmpty() {
        int[] firstInputArray={};
        IntSet firstInputSet=new IntSet(firstInputArray);
        int[] secondInputArray={};
        IntSet secondInputSet=new IntSet(secondInputArray);
        IntSet union=firstInputSet.getUnion(secondInputSet);
        int[] actualOutput=union.getSet();
        int[] expectedOutput= {};
        assertArrayEquals(expectedOutput, actualOutput);
    }

}
