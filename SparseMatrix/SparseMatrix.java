/**
 * Immutable class for sparse matrices which stores only non zero elements
 * @author admin
 *
 */
public final class SparseMatrix {
    //0th column of matrixArray is used to store row, 1st column for column and 2nd column for matrix element.
    private final int[][] matrixArray;
    private final int COLUMNSIZE=3;
    private final int row;
    private final int column;
    /**
     * constructor initializes matrixArray
     * @param inputArray
     * @param row
     * @param column
     */
    public SparseMatrix(int[][] inputArray,int row,int column)
    {
        this.row=row;
        this.column=column;
        matrixArray=new int[inputArray.length][COLUMNSIZE];
        for(int i=0;i<matrixArray.length;i++)
        {
            matrixArray[i][0]=inputArray[i][0];
            matrixArray[i][1]=inputArray[i][1];
            matrixArray[i][2]=inputArray[i][2];
        }
    }
    
    public int[][] getMatrixArray()
    {
        return matrixArray;
    }
    
    /**
     * helper method which converts sparse matrix into stored form
     * @param matrix
     * @return returns a 2D matrix which stores non zero elements of sparse matrix with their row and column index
     */
    public int[][] convertToStoredForm(int[][] matrix)
    {
        //complexity O(n^2)
        int nonZeroElements=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j]!=0)
                {
                    nonZeroElements++;
                }
            }
        }
        int[][] convertedMatrix=new int[nonZeroElements][COLUMNSIZE];
        int index=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j]!=0)
                {
                    convertedMatrix[index][0]=i;
                    convertedMatrix[index][1]=j;
                    convertedMatrix[index][2]=matrix[i][j];
                    index++;
                }
            }
        }
        return convertedMatrix;
    }
    
    /**
     * Calculate transpose of matrix
     * @return returns transpose matrix object
     */
    public SparseMatrix getTranspose()
    {
        //complexity O(n)
        int[][] transposeArray=new int[matrixArray.length][COLUMNSIZE];
        for(int i=0;i<matrixArray.length;i++)
        {
            transposeArray[i][0]=matrixArray[i][1];
            transposeArray[i][1]=matrixArray[i][0];
            transposeArray[i][2]=matrixArray[i][2];
        }
        SparseMatrix transposeMatrix=new SparseMatrix(transposeArray,this.row,this.column);
        return transposeMatrix;
    }
    
    /**
     * Checks whether matrix is symmetric or not
     * @return symmetric returns true if matrix is symmetric otherwise false
     */
    public boolean isSymmetric()
    {
        //complexity O(n^2)
        if(row!=column)
        {
            throw new AssertionError("Rows must be equal to column for the symmetric property");
        }
        boolean symmetric=true;
        for(int i=0;i<matrixArray.length;i++)
        {
            for(int j=0;j<matrixArray.length;j++)
            {
                if(matrixArray[i][0]==matrixArray[j][1])
                {
                    if(matrixArray[i][2]==matrixArray[j][2])
                    {
                        break;
                    }
                }
                else if(j==matrixArray.length-1)
                {
                    symmetric=false;
                    return symmetric;
                }
            }
        }
        return symmetric;
    }
    
    /**
     * add two matrices
     * @param matrix
     * @return result returns addition of two matrices
     */
    public SparseMatrix add(SparseMatrix matrix)
    {
        //complexity O(n)
        if(this.row!=matrix.row || this.column!=matrix.column)
        {
            throw new AssertionError("Dimensions of matrices are not same, so addition can,t be performed");
        }
        int[][] temporaryArray=new int[this.matrixArray.length+matrix.matrixArray.length][COLUMNSIZE];
        int index=0;
        int i=0,j=0;
        while(i<this.matrixArray.length && j<matrix.matrixArray.length)
        {
            if(this.matrixArray[i][0]<matrix.matrixArray[j][0]
                    ||(this.matrixArray[i][0]==matrix.matrixArray[j][0] &&
                            this.matrixArray[i][1]<matrix.matrixArray[j][1]  ))
            {
                temporaryArray[index][0]=this.matrixArray[i][0];
                temporaryArray[index][1]=this.matrixArray[i][1];
                temporaryArray[index][2]=this.matrixArray[i][2];
                index++;
                i++;
            }
            else if(this.matrixArray[i][0]>matrix.matrixArray[j][0]
                    ||(this.matrixArray[i][0]==matrix.matrixArray[j][0] &&
                    this.matrixArray[i][1]>matrix.matrixArray[j][1]  ))
            {
                temporaryArray[index][0]=matrix.matrixArray[j][0];
                temporaryArray[index][1]=matrix.matrixArray[j][1];
                temporaryArray[index][2]=matrix.matrixArray[j][2];
                index++;
                j++;
            }
            else
            {
                temporaryArray[index][0]=this.matrixArray[i][0];
                temporaryArray[index][1]=this.matrixArray[i][1];
                temporaryArray[index][2]=this.matrixArray[i][2]+matrix.matrixArray[j][2];
                index++;
                i++;
                j++;
            }
        }
        if(i<this.matrixArray.length)
        {
            while(i<this.matrixArray.length)
            {
                temporaryArray[index][0]=this.matrixArray[i][0];
                temporaryArray[index][1]=this.matrixArray[i][1];
                temporaryArray[index][2]=this.matrixArray[i][2];
                index++;
                i++;
            }
        }
        else if(j<matrix.matrixArray.length)
        {
            while(j<matrix.matrixArray.length)
            {
                temporaryArray[index][0]=matrix.matrixArray[j][0];
                temporaryArray[index][1]=matrix.matrixArray[j][1];
                temporaryArray[index][2]=matrix.matrixArray[j][2];
                index++;
                j++;
            }
        }
        int[][] resultArray=new int[index][COLUMNSIZE];
        for(int k=0;k<index;k++)
        {
            resultArray[k][0]=temporaryArray[k][0];
            resultArray[k][1]=temporaryArray[k][1];
            resultArray[k][2]=temporaryArray[k][2];
        }
        SparseMatrix result=new SparseMatrix(resultArray,this.row,this.column);
        return result;
    }
    
    /**
     * Multiplies two matrices
     * @param matrix
     * @return result returns multiplication of two matrices
     */
    public SparseMatrix multiply(SparseMatrix matrix)
    {
        //complexity O(n^2)
        if(this.column!=matrix.row)
        {
            throw new AssertionError("number of columns of first matrix is not equal to number of row of second matrix which must be equal for matrix multiplication");
        }
        int[][] temporaryMatrix=new int[this.row][matrix.column];
        for(int i=0;i<this.matrixArray.length;i++)
        {
            for(int j=0;j<matrix.matrixArray.length;j++)
            {
                if(this.matrixArray[i][1]==matrix.matrixArray[j][0])
                {
                    temporaryMatrix[this.matrixArray[i][0]][matrix.matrixArray[j][1]]+=
                            this.matrixArray[i][2]*matrix.matrixArray[j][2];
                }
            }
        }
        int[][] resultMatrix=convertToStoredForm(temporaryMatrix);
        SparseMatrix result=new SparseMatrix(resultMatrix, this.row, matrix.column);
        return result;
    }
    
}

