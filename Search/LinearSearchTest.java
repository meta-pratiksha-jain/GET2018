import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LinearSearchTest {
    private int[] array;
    private int index;
    private int elementToSearch;
    private int expectedResult;
    private Search linearSearchInstance;
    
    public LinearSearchTest(int[] array, int index,int elementTosearch,int expectedResult) {
        super();
        this.array=array;
        this.index=index;
        this.elementToSearch=elementTosearch;
        this.expectedResult=expectedResult;
    }
    
    @Before
    public void initialize()
    {
        linearSearchInstance=new Search();
    }
    
    @Parameterized.Parameters
    public static Collection input()
    {
        return Arrays.asList(new Object[][]{
                {new int[]{1,23,45,6,8,4},0,23,1},
                {new int[]{1,23,45,6,8,4},0,2,-1},
                {new int[]{1,23,45,6,8,4},0,4,5},
        });
    }

    @Test
    public void test() {
       assertEquals(expectedResult,linearSearchInstance.linearSearch(array, index, elementToSearch));
    }
    
    @Test(expected=AssertionError.class)
    public void throwAssertionErrorIfArrayIsEmpty()
    {
        linearSearchInstance=new Search();
        linearSearchInstance.linearSearch(new int[]{}, 0,2);
    }

}
