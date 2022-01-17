public class CountNQueens {
	
	public static void print(String statement) {
		System.out.println(statement);
	}

	public static void print(String statement, boolean newline) {
		if (newline)
			System.out.println(statement);
		else
			System.out.print(statement);
	}
	
	public static void print(int statement) {
		System.out.println(statement);
	}

	public static void print(int statement, boolean newline) {
		if (newline)
			System.out.println(statement);
		else
			System.out.print(statement);
	}
	
	public static void print(int[] array){

		for(int n = 0;  n < array.length; ++n){
			print("index " + n + " value " + array[n]);
		}
	}
	
	public static void main(String args[]){
		boolean[][] board = new boolean[4][4];
		//print(countNQueens(board,0));
		printcountNQueens(board,0,"");
	}
	
	static int countNQueens(boolean[][] board, int row){
		
		//last row where queen is safe to be put
		if( row == board.length )
			return 1;
				
		int count = 0;
		for (int col = 0; col < board[row].length ; ++col){
			if ( isItSafe(board,row,col) ) {
				board[row][col] = true;
				int result = countNQueens(board, row+1); // recurcise loop will check for all the rows ( notice: row + 1 ) 
				count = count + result;
				board[row][col] = false;
			}
		}
		return count;

	}
	
	
	static void checkallTrue(boolean[][] board){
		
		for(int row=0; row < board.length ; ++row)
			for(int column=0; column < board[row].length ; ++column)
				if(board[row][column])
					System.out.println("row,column=" + row + " " + column);
	}
	
	
	static void printcountNQueens(boolean[][] board, int row, String result){
		
	//	System.out.println("printcountNQueens row,column=" + row + " " + column);
	//	System.out.println(" Flag=" + board[row][column]);
		
		//last row where queen is safe to be put
		if( row == board.length ) {
			System.out.print(result);
			return ;
		}
				

		int col = 0;
		for (col = 0; col < board[row].length ; ++col){
			if ( isItSafe(board,row,col) ) {
				board[row][col] = true;
				printcountNQueens(board, row+1, result + " { " + (row) + "," + (col) + " } "); // recurcise loop will check for all the rows ( notice: row + 1 ) 
				board[row][col] = false;
			}
		}
		

	}
	
	static boolean isItSafe(boolean[][] board, int row, int col) {
		//look on top
		for(int i=row, j=col; i >=0 ; --i){
			if(board[i][col])
				return false;
		}			
		
		//look diagonal left
		for(int i=row, j=col; i>=0 && j>=0 ; --i, --j){
			//System.out.println("row,column=" + i + " " + j);
			if(board[i][j])
				return false;
		}
		
		//look diagonal right
		for(int i=row, j=col; i >=0 && j < board[row].length ; --i, ++j){
			if(board[i][j])
				return false;
			
		}
		
		return true;
		
	}
}
	