/*
Take as input N, the size of array. Take N more inputs and store that in an array. Take as input M, a number. Write a recursive function which returns the last index at which M is found in the array and -1 if M is not found anywhere. Print the value returned.

Input Format
There will be three lines of input:

N - the size of the array
N space separated integers that make up the array
M
Constraints
1 < N < 1000
-10^9 < i,M < 10^9 , where i is any number within the array

Output Format
For each case, print the integer value of the last index that M is found at within the given array.
If it is not found, print '-1' (without the quotes).

Sample Input
7
86 -16 77 65 45 77 28
77
Sample Output
5
Explanation
Last occurence of 77 is found at index = 5.
*/
import java.util.Scanner;
public class FindLastElement {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String sizeofArray = sc.nextLine();
		String elementsofArray = sc.nextLine();
		String elementToSearch = sc.nextLine();
		int[] array = new int[Integer.parseInt(sizeofArray)];
		String[] result = elementsofArray.split("\\s");
		for (int x=0; x<result.length; x++)
         array[x] = Integer.parseInt(result[x]);
	 
	 
		System.out.println(findLastElement(array,Integer.parseInt(elementToSearch),0));

	}
	
	public static int findLastElement(int[] array, int numberToSearch, int selectedIndex){
		
		int result = -1;
				
		if(selectedIndex == array.length-1 ){
			if ( array[selectedIndex] == numberToSearch )
				return selectedIndex;	
			else
				return result;
		}
			
	
		for( int x=selectedIndex; x<array.length-1; ++x){
			
			if( array[selectedIndex] == numberToSearch)
				result = selectedIndex;
	
			int currentresult = findLastElement(array,numberToSearch,x+1);
			if( currentresult != -1 )
			{
				result = currentresult;
			}
			
		}
		
		return result;
	}
}