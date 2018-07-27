import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BinarySearchTest {
    private int[] array;
    private int startIndex;
    private int endIndex;
    private int elementToSearch;
    private int expectedResult;
    private Search binarySearchInstance;
    
    public BinarySearchTest(int[] array, int startIndex,int endIndex,int elementTosearch,int expectedResult) {
        super();
        this.array=array;
        this.startIndex=startIndex;
        this.endIndex=endIndex;
        this.elementToSearch=elementTosearch;
        this.expectedResult=expectedResult;
    }
    
    @Before
    public void initialize()
    {
        binarySearchInstance=new Search();
    }
    
    @Parameterized.Parameters
    public static Collection input()
    {
        return Arrays.asList(new Object[][]{
                {new int[]{1,4,7,8,12,28},0,5,28,5},
                {new int[]{1,4,7,8,12,28},0,5,2,-1},
                {new int[]{1,4,7,8,12,28},0,5,4,1},
        });
    }

    @Test
    public void test() {
       assertEquals(expectedResult,binarySearchInstance.binarySearch(array, startIndex,endIndex, elementToSearch));
    }
    
    @Test(expected=AssertionError.class)
    public void throwAssertionErrorIfArrayIsEmpty()
    {
        binarySearchInstance=new Search();
        binarySearchInstance.binarySearch(new int[]{}, 0,0,2);
    }


}
