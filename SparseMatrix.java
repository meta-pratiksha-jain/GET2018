package sparseMatrix;

public final class SparseMatrix {
    private final int[][] matrixArray;
    private final int COLUMNSIZE=3;
    //0th column of matrixArray is used to store row, 1st column for column and 2nd column for matrix element.
    
    public SparseMatrix(int[][] inputArray)
    {
        matrixArray=inputArray;
    }
    
    public int[][] getMatrixArray()
    {
        return matrixArray;
    }
    
    public int getNumberOfRows()
    {
        return matrixArray[matrixArray.length-1][0];
    }
    
    public int getNumberOfColumn()
    {
        int numberOfColumn=0;
        for(int i=0;i<matrixArray.length;i++)
        {
            if(matrixArray[i][1]>numberOfColumn)
            {
                numberOfColumn=matrixArray[i][1];
            }
        }
        return numberOfColumn;
    }
    
    public SparseMatrix getTranspose()
    {
        int[][] transposeArray=new int[matrixArray.length][COLUMNSIZE];
        for(int i=0;i<matrixArray.length;i++)
        {
            transposeArray[i][0]=matrixArray[i][1];
            transposeArray[i][1]=matrixArray[i][0];
            transposeArray[i][2]=matrixArray[i][2];
        }
        SparseMatrix transposeMatrix=new SparseMatrix(transposeArray);
        return transposeMatrix;
    }
    
    public boolean isSymmetric()
    {
        SparseMatrix transpose=getTranspose();
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
    
    public SparseMatrix add(SparseMatrix matrix)
    {
        int rowsOfFirstMatrix=this.getNumberOfRows();
        int columnOfFirstMatrix=this.getNumberOfColumn();
        int rowsOfSecondMatrix=matrix.getNumberOfRows();
        int columnOfSecondMatrix=matrix.getNumberOfColumn();
        if(rowsOfFirstMatrix!=rowsOfSecondMatrix && columnOfFirstMatrix!=columnOfSecondMatrix)
        {
            throw new AssertionError("Dimensions of matrices are not same, so addition can,t be performed");
        }
        int[][] temporaryArray=new int[rowsOfFirstMatrix+rowsOfSecondMatrix][COLUMNSIZE];
        int index=0;
        int i=0,j=0;
        while(i<rowsOfFirstMatrix && j<rowsOfSecondMatrix)
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
                temporaryArray[index][2]=this.matrixArray[i][2]+matrix.matrixArray[i][2];
                index++;
                i++;
                j++;
            }
        }
        if(i<rowsOfFirstMatrix)
        {
            while(i<rowsOfFirstMatrix)
            {
                temporaryArray[index][0]=this.matrixArray[i][0];
                temporaryArray[index][1]=this.matrixArray[i][1];
                temporaryArray[index][2]=this.matrixArray[i][2];
                index++;
                i++;
            }
        }
        else
        {
            while(j<rowsOfSecondMatrix)
            {
                temporaryArray[index][0]=matrix.matrixArray[j][0];
                temporaryArray[index][1]=matrix.matrixArray[j][1];
                temporaryArray[index][2]=matrix.matrixArray[j][2];
                index++;
                j++;
            }
        }
        int[][] resultArray=new int[index][COLUMNSIZE];
        for(int k=0;k<index;i++)
        {
            resultArray[k][0]=temporaryArray[k][0];
            resultArray[k][1]=temporaryArray[k][1];
            resultArray[k][2]=temporaryArray[k][2];
        }
        SparseMatrix result=new SparseMatrix(resultArray);
        return result;
    }

}
