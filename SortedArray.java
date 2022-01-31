/**
Take as input N, the size of an integer array. Take one more input, which is a list of N integers separated by a space, and store that in an array. 
Write a recursive function which prints true if the array is sorted in Increasing Order, and false otherwise.

Input Format
N x y z

Constraints
1 < N < 1000
-10^9 < i < 10^9, where i is an element of the array

Output Format
true OR false

Sample Input
5
1 2 3 4 5
Sample Output
true
**/
import java.util.Scanner;
public class SortedArray {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		String sizeofArray = sc.nextLine();
		String elementsofArray = sc.nextLine();
		int[] array = new int[Integer.parseInt(sizeofArray)];
		String[] result = elementsofArray.split("\\s");
		for (int x=0; x<result.length; x++)
         		array[x] = Integer.parseInt(result[x]);
	 
		System.out.println(isArrayInIncreasingOrder(array,0));
	 
	}
	
	
	static boolean isArrayInIncreasingOrder(int[] array, int selectedIndex)  {
		
		if(selectedIndex == array.length-1 ){
			return true;
		}
			
		boolean result = true;	
		for( int x=selectedIndex; x<array.length-1; ++x){
			
			if(array[x+1] >= array[x])
			{
				boolean currentResult = isArrayInIncreasingOrder(array,x+1);
				result = result && currentResult;
			}
			else
				result = false;
			
			if(!result)
				break;
			
		}
		
		return result;
		
	}
}
