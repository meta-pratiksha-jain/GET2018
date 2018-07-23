public class NQueen {
	
	/*
	 * Places the n Queens on n x n square board such that no two queens can attack each other
	 * @param board contains a matrix with dimension n x n on which queens are placed
	 * @param startRow contains the row in which current queen is placed
	 * @param dimensionOfMatrix contains dimension of board
	 * @return returns true if it is possible to place n queens on n x n square board otherwise false 
	 */
	public boolean nQueen(int[][] board,int startRow,int dimensionOfMatrix)
	{
		if(startRow==dimensionOfMatrix)
		{
			return true;
		}
		else
		{
			for(int column=0;column<dimensionOfMatrix;column++)
			{
				if(isQueenSafe(board,startRow,column))
				{
					board[startRow][column]=1;
					if(nQueen(board,++startRow,dimensionOfMatrix))
					{
						return true;
					}
					else
					{
						board[--startRow][column]=0;
					}
				}
			}
			return false;
		}
	}
	
	/*
	 * Checks whether it is safe to place queen on current square of board
	 * @param board contains a matrix with dimension n x n on which queens are placed
	 * @param startRow contains the row of square on which current queen is placed
	 * @param column contains column of square on which current queen is placed
	 * @return returns true if it is safe to place queen on the square otherwise false 
	 */
	public boolean isQueenSafe(int[][] board, int startRow, int column)
	{
		int i,j;
		//check for row and column
		for(i=0;i<board.length;i++)
		{
			if(board[startRow][i]==1)
			{
				return false;
			}
			if(board[i][column]==1)
			{
				return false;
			}
		}
		//check for upper left diagonal
		for(i=startRow,j=column;i>=0 && j>=0;i--,j--)
		{
			if(board[i][j]==1)
			{
				return false;
			}
		}
		//check for upper right diagonal
		for(i=startRow,j=column;i>=0 && j<board.length;i--,j++)
		{
			if(board[i][j]==1)
			{
				return false;
			}
		}
		return true;
	}

}
