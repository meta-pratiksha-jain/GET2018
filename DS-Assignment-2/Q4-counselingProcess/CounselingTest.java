package counselingProcess;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CounselingTest {
    Counseling counseling;

    //test cases for allocatePrograms()
    @Test
    public void testAllocateProgramShouldReturnAllocatedProgramListOfStudent() {
        counseling=new Counseling();
        HashMap<String,String> actualOutput=counseling.allocatePrograms();
        for(Map.Entry<String, String> entry:actualOutput.entrySet())
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

}
