package nQueen;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class NQueenTest {
    private int[][] board;
    private int startRow;
    private int dimensionOfMatrix;
    private boolean expectedResult;
    private NQueen nQueenInstance;
    
    public NQueenTest(int[][] board,int startRow, int dimensionOfMatrix,boolean expectedResult) {
        super();
        this.board=board;
        this.startRow=startRow;
        this.dimensionOfMatrix=dimensionOfMatrix;
        this.expectedResult=expectedResult;
    }
    
    @Before
    public void initialize()
    {
        nQueenInstance=new NQueen();
    }
    
    @Parameterized.Parameters
    public static Collection input()
    {
        return Arrays.asList(new Object[][]{
                {new int[][]{{0,0,0},{0,0,0},{0,0,0}},0,3,false},
                {new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0,}},0,4,true},
                {new int[][]{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}},0,3,false},
                });
    }

    @Test
    public void test() {
       assertEquals(expectedResult,nQueenInstance.nQueen(board,startRow,dimensionOfMatrix));
    }

}