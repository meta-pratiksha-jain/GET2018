package uniqueCharacterCount;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueCharacterCountTest {
    UniqueCharacterCount uniqueCharacterCountInstance;

    //test cases for countUniqueCharater()
    @Test
    public void testCountShouldReturnCountWhenStringNotNull() {
        uniqueCharacterCountInstance=new UniqueCharacterCount();
        int actualOutput=uniqueCharacterCountInstance.getNumberOfUniqueCharacter("charactercount");
        assertEquals(5, actualOutput);
        actualOutput=uniqueCharacterCountInstance.getNumberOfUniqueCharacter("aSsignment");
        assertEquals(8, actualOutput);
        actualOutput=uniqueCharacterCountInstance.getNumberOfUniqueCharacter("charactercount");
        assertEquals(5, actualOutput);
        actualOutput=uniqueCharacterCountInstance.getNumberOfUniqueCharacter("string");
        assertEquals(6, actualOutput);
    }
    
    @Test(expected=AssertionError.class)
    public void testGetNumberShouldThrowExceptionWhenStringNull() {
        uniqueCharacterCountInstance=new UniqueCharacterCount();
        String string=null;
        uniqueCharacterCountInstance.getNumberOfUniqueCharacter(string);
    }

}
