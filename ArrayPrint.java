public class ArrayPrint {
	
	public static void print(String statement) {
		System.out.println(statement);
	}
	
	public static void print(int statement) {
		System.out.println(statement);
	}
	
	public static void main(String arr[]){
	  /*
	    	11 12 13 14
		21 22 23 24
		31 32 33 34
		41 42 43 44
	  */
		int[][] array = {{11,12,13,14},{21,22,23,24},{31,32,33,34},{41,42,43,44}};
		//wavePrint(array);
		spiralPrint(array);
	}
	
	public static void wavePrint(int[][] array){
		
		for(int row=0; row<array.length; ++row){
			
			print("row" + row);
			print("row divide" + row%2);
			
			for(int column = 0; column<array[row].length && row%2 == 0; ++column)
				print(array[row][column]);	
			
			for(int column = array[row].length -1 ; column >= 0 && row%2 == 1; --column)
				print(array[row][column]);	
			
		}
	}
	
	public static void spiralPrint(int[][] array){
		
		
		// 6 parameters
		//top = 0;
		//bottom = array.length-1
		//left = 0
		//right = array[top].length-1
		//dir 1=right to left, 2=top to down, 3=left to right, 4=down to bottom
		//count = total number of elements (  array.length-1 * array[top].length-1 ) = ( 4 * 4 ) = 16 
		
		int top = 0;
		int bottom = array.length-1;
		int left = 0;
		int right = array[top].length-1;
		//dir 1=right to left, 2=top to down, 3=left to right, 4=down to bottom
		int dir = 1;
		//count = total number of elements (  array.length-1 * array[top].length-1 ) = ( 4 * 4 ) = 16 
		int count = (array.length)*(array[top].length);
		
		print("total count"+count);
		//print(array[1][0]);
		//print(array[2][0]);
		
		while(top <= bottom && left <= right){
			
			//print("dir"+dir);
			//print("count"+count);
			
			if(count>0){
				if( dir == 1){
					for(int i=left; i<=right; ++i){
						print(array[top][i]);
						--count;
					}
					dir = 2;
					top++;
				}
			}
			
			//print("dir"+dir);
			//print("count"+count);
			
			if(count>0){
				if (dir == 2) {
					for(int i=top; i<=bottom; ++i){
						//print(array[i][array[i].length-1]);
						print(array[i][right]);
						--count;
					}
					dir = 3;
					right--;
				}
			}
			
			//print("dir"+dir);
			//print("count"+count);
			
			if(count>0){
				if (dir == 3) {
					//print("dir"+dir);
					//print("right"+right);
					//print("left"+left);
					//print("bottom"+bottom);
					for(int i=right; i>=left; --i){
						//print("Result array[bottom][i] array["+bottom+"]["+i+"]"+array[bottom][i]);
						print(array[bottom][i]);
						--count;
					}
					dir = 4;
					bottom--;
				}
			}
			
			//print("dir"+dir);
			//print("count"+count);
					
			if(count>0){
				if (dir == 4) {
					//print("dir"+dir);
					//print("right"+right);
					//print("left"+left);
					//print("bottom"+bottom);
					//print("top"+top);
					for(int i=bottom; i>=top; --i){
						//print("Result array[bottom][i] array["+i+"]["+left+"]"+array[i][left]);
						print(array[i][left]);
						--count;
					}
					dir = 1;
					left++;
				}
			}
			
		}
		
	}
	
	
}
