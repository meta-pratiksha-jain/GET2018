package dictionary;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class DictionaryUsingBSTTest {
    IDictionary dictionary;

    //test cases for addNode()
    @Test
    public void testAddNode() {
        dictionary=new DictionaryUsingBST();
        dictionary.addNode(8, "sam");
        List<Node> sortedList=dictionary.getSortedList();
        int[] expectedList={1,2,4,7,8,10};
        for(int i=0;i<expectedList.length;i++)
        {
            int actualKey=sortedList.get(i).getKey();
            assertEquals(expectedList[i], actualKey);
        }
    }
    
    //test cases for deleteNode()
    @Test
    public void testDeleteNode() {
        dictionary=new DictionaryUsingBST();
        dictionary.deleteNode(7);
        List<Node> sortedList=dictionary.getSortedList();
        int[] expectedList={1,2,4,10};
        for(int i=0;i<expectedList.length;i++)
        {
            int actualKey=sortedList.get(i).getKey();
            assertEquals(expectedList[i], actualKey);
        }
    }
    
    //test cases for getValue()
    @Test
    public void testGetValueShouldReturnValueWhenKeyExistInDictionary() {
        dictionary=new DictionaryUsingBST();
        String value=dictionary.getValue(10);
        assertEquals("ankit",value);
    }
    
    @Test(expected=AssertionError.class)
    public void testGetValueShouldThrowExceptionWhenKeyNotExistInDictionary() {
        dictionary=new DictionaryUsingBST();
        dictionary.getValue(5);
    }
    
    //test cases for getSortedList()
    @Test
    public void testGetSortedListShouldReturnSortedList() {
        dictionary=new DictionaryUsingBST();
        List<Node> actualSortedList=dictionary.getSortedList();
        int[] expectedList={1,2,4,7,10};
        for(int i=0;i<expectedList.length;i++)
        {
            int actualKey=actualSortedList.get(i).getKey();
            assertEquals(expectedList[i], actualKey);
        }
    }
    
    //test cases for getSortedListInRangeOfKey()
    @Test
    public void testGetSortedListShouldReturnSortedListWhenSomeKeysInRange() {
        dictionary=new DictionaryUsingBST();
        List<Node> actualSortedList=dictionary.getSortedListInRangeOfKey(5, 8);
        int[] expectedList={7};
        for(int i=0;i<expectedList.length;i++)
        {
            int actualKey=actualSortedList.get(i).getKey();
            assertEquals(expectedList[i], actualKey);
        }
    }
    
    @Test
    public void testGetSortedListShouldReturnSortedListWhenAllKeysInRange() {
        dictionary=new DictionaryUsingBST();
        List<Node> actualSortedList=dictionary.getSortedListInRangeOfKey(-1, 10);
        int[] expectedList={1,2,4,7,10};
        for(int i=0;i<expectedList.length;i++)
        {
            int actualKey=actualSortedList.get(i).getKey();
            assertEquals(expectedList[i], actualKey);
        }
    }
    
    @Test
    public void testGetSortedListShouldReturnEmptyListWhenNoneKeysInRange() {
        dictionary=new DictionaryUsingBST();
        List<Node> actualSortedList=dictionary.getSortedListInRangeOfKey(-5,-1);
        assertEquals(0,actualSortedList.size());
    }

}
