/*
Take as input N, the size of array. Take N more inputs and store that in an array. Take as input M, a number. Write a recursive function which returns an array containing indices of all items in the array which have value equal to M. Print all the values in the returned array.

Input Format
Enter a number N(size of the array) and add N more numbers to the array Enter number M to be searched in the array

Constraints
1 <= Size of array <= 10^5

Output Format
Display all the indices at which number M is found in a space separated manner

Sample Input
5
3
2
1
2
3
2
Sample Output
1 3
Explanation
2 is found at indices 1 and 3.
*/
import java.util.Scanner;
public class AllIndiciesProblem {
	
	public static void print(String statement) {
		System.out.println(statement);
	}
	
	public static void print(int[] array){

		for(int n = 0;  n < array.length; ++n){
			print("index " + n + " value " + array[n]);
		}
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int sizeofArray = sc.nextInt();

		sc.nextLine();

		int[] array = new int[sizeofArray];
		for (int x=0; x<array.length; x++){
			int arrayElement = sc.nextInt();
			sc.nextLine();
			array[x] = arrayElement;
		}
		
		
		int elementToSearch = sc.nextInt();
	 
		int[] resultAllIndicies = allIndiciesProblem(array,elementToSearch,0,0);
		
		for(int n = 0;  n < resultAllIndicies.length; ++n){
			if(n == resultAllIndicies.length -1 )
				System.out.print(resultAllIndicies[n]);
			else	
				System.out.print(resultAllIndicies[n] + " ");
		}
		
		//print("Final Result");
		//print(resultAllIndicies);

	}	
	
	static int[] allIndiciesProblem(int[] array, int elementToSearch, int si, int count) {
		
		if( si < array.length) {
			//String input = "arrayElement=" + array[si] + ",elementToSearch=" + elementToSearch + ",si=" + si + ",count=" + count;
			//System.out.println("Input ->" + input);
		}
		
		if( si == array.length) {
			//String input = "elementToSearch=" + elementToSearch + ",si=" + si + ",count=" + count;
			//System.out.println("BASE CONDITION Input ->" + input);
			int[] result = new int[count];
			return result;
		}

		int[] indices = null;

		if(array[si] == elementToSearch) {
			//print("Result Match ->");
			indices =  allIndiciesProblem(array,elementToSearch, si+1, count + 1);
			//print("Result Match ->");
		
		}
		else {
			//print("Result Non Match ->");
			indices = allIndiciesProblem(array,elementToSearch, si+1, count);
			//print("Result Non Match ->");
			
		}

		if ( array[si] == elementToSearch ) {
			//print("Insert at  = " + count );
			indices[count] = si;
		}

		//print("Function Output");
		//print(indices);
		return  indices;
		
	}
}