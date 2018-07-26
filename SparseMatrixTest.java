package sparseMatrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class SparseMatrixTest {

    @Test
    public void testgetTranspose() {
        int[][] inputArray={{0,2,3},
                            {0,4,4},
                            {1,2,5},
                            {1,3,7},
                            {3,1,2},
                            {3,2,6}};
        SparseMatrix matrixInstance=new SparseMatrix(inputArray);
        SparseMatrix transposeInstance=matrixInstance.getTranspose();
        int[][] actualOutput=transposeInstance.getMatrixArray();
        int[][] expectedOutput={{2,0,3},
                                {4,0,4},
                                {2,1,5},
                                {3,1,7},
                                {1,3,2},
                                {2,3,6}};
        assertArrayEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testIsSymmetricWithSymmetricMatrix()
    {
        int[][] inputArray={{0,1,1},
                            {1,0,1},
                            {1,2,2},
                            {2,1,2},
                            {3,3,4}};
        SparseMatrix matrixInstance=new SparseMatrix(inputArray);
        boolean actualOutput=matrixInstance.isSymmetric();
        boolean expectedOutput=true;
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testIsSymmetricWithNonSymmetricMatrix()
    {
        int[][] inputArray={{0,2,3},
                            {0,4,4},
                            {1,2,5},
                            {1,3,7},
                            {3,1,2},
                            {3,2,6}};
        SparseMatrix matrixInstance=new SparseMatrix(inputArray);
        boolean actualOutput=matrixInstance.isSymmetric();
        boolean expectedOutput=false;
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testAdd()
    {
        int[][] inputArray1={{0,2,3},
                             {0,4,4},
                             {1,2,5},
                             {1,3,7},
                             {3,1,2},
                             {3,2,6}};
        SparseMatrix firstMatrix=new SparseMatrix(inputArray1);
        int[][] inputArray2={{0,1,2},
                             {1,3,6},
                             {2,2,4},
                             {2,4,8},
                             {3,0,1},
                             {3,2,9}};
        SparseMatrix secondMatrix=new SparseMatrix(inputArray2);
        SparseMatrix resultMatrix=firstMatrix.add(secondMatrix);
        int[][] actualOutput=resultMatrix.getMatrixArray();
        int[][] expectedOutput={{0,1,2},
                                {0,2,3},
                                {0,4,4},
                                {1,2,5},
                                {1,3,13},
                                {2,1,4},
                                {2,4,8},
                                {3,0,1},
                                {3,1,2},
                                {3,2,15}};
        assertArrayEquals(expectedOutput, actualOutput);
    }

}
