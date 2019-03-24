/*
 * 
 * Dillon Ney
 * ID # 1705097
 * Programming Assignment 2
 * 
 */




public class Queens {

	 static int n = 0;
	
	public static void main(String[] args) 
	{
		if(args.length == 2 )
		{
			try	{
				n = Integer.parseInt(args[1]);
				} catch(RuntimeException exception)
				{
					System.out.println("Usage: Queens [-v] number\n Option: -v   verbose output, print all solutions");
					return;
				}
		}
		else if(args.length == 1)
		{
			try	{
				n = Integer.parseInt(args[0]);
				} catch(RuntimeException exception)
				{
					System.out.println("Usage: Queens [-v] number\n Option: -v   verbose output, print all solutions");
					return;
				}
		}
		else
		{
			System.out.println("Usage: Queens [-v] number\n Option: -v   verbose output, print all solutions");
			return;
		}
		
		int[][] board = new int[n + 1][n + 1];
		
		setBoard(board);
		
		
		
		System.out.println(n + "-Queens has " + findSolutions(board , 1, args[0]) + " solutions");

		
	}

	
	static void setBoard(int[][] B)
	{
		for(int i = 0; i < B.length; i++)
		{
			for(int j = 0; j < B[i].length; j++)
			{
				B[i][j] = 0;
			}
			
		}
		
	}

	
	static void placeQueen(int[][] B, int row, int col)
	{
		B[row][col] ++;
		B[row][0] = col;
		
		for (int i = row; i <= n; i++) 
            B[row][i] --; 	//check row
		
		for (int i = 1; i > row; i--) 
            B[row][i] --; 	//check row above
		
		for (int i=row, j=col; i>=1 && j>=1; i--, j--) 
            B[i][j] --;	//check up/left
		
		for (int i=row, j=col; j>=1 && i <= n; i++, j--) 
	            B[i][j] --;	//check down/left
		
		for (int i = 1; i <= n; i++) 
            B[i][col] --; 	//check column
		
		for (int i = 1; i > col; i--) 
            B[i][col] --;
		
		for (int i=row, j=col; i<= n && j <= n; i++, j++) 
            B[i][j] --;	//check down/right
		
		for (int i=row, j=col; j <= n && i >= 1; i--, j++) 
	            B[i][j] --;	//check up/right
			
	
	}
		
		
	
		
		
	

	
	static void removeQueen(int[][] B, int row, int col)
	{
		B[row][col] --;
		B[row][0] = 0;
			
		for (int i = row; i <= n; i++) 
            B[row][i] ++; 	//check row
		
		for (int i = 1; i > row; i--) 
            B[row][i] ++; 	//check row above
		
		for (int i=row, j=col; i>=1 && j>=1; i--, j--) 
            B[i][j] ++;	//check up/left
		
		for (int i=row, j=col; j>=1 && i <= n; i++, j--) 
	            B[i][j] ++;	//check down/left
		
		for (int i = 1; i <= n; i++) 
            B[i][col] ++; 	//check column
		
		for (int i = 1; i > col; i--) 
            B[i][col] ++;
		
		for (int i=row, j=col; i<= n && j <= n; i++, j++) 
            B[i][j] ++;	//check down/right
		
		for (int i=row, j=col; j <= n && i >= 1; i--, j++) 
	            B[i][j] ++;	//check up/right
	}
			
		
		
		
		
	
	
	static void printBoard(int[][] B)
	{
		System.out.print("(");
		for(int i = 1; i < B.length; i++)
		{
			System.out.print(B[i][0]);
			if(i < B.length - 1)
				System.out.print(", ");
		}
		System.out.println(")");
		
	}
	
	static int findSolutions(int[][] B, int i, String mode)
	{
		int sum = 0;
		if( i > n)
		{
			if (mode.equals("-v"))
			{
				printBoard(B);
			}

			return 1;
			
		} 
		else
		{
			
			for(int j = 1; j <= n; j++)
			{
				if(B[i][j] == 0)
				{
					placeQueen(B, i, j);
					
					sum += findSolutions(B, i + 1, mode);
					
					removeQueen(B, i , j);
				}
			}
		}
		
		return sum;
	}
}
