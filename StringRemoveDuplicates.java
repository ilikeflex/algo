/**
Take as input S, a string. Write a function that removes all consecutive duplicates. Print the value returned.

Input Format
String

Constraints
A string of length between 1 to 1000

Output Format
String

Sample Input
aabccba
Sample Output
abcba
Explanation
For the given example, "aabccba", Consecutive Occurrence of a is 2, b is 1, and c is 2.

After removing all of the consecutive occurences, the Final ans will be : - "abcba".
**/
import java.util.Scanner;
public class StringRemoveDuplicates {

	public static void main(String[] str){
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		System.out.println(stringRemoveDuplicates(input,0));
	}
	
	private static String stringRemoveDuplicates(String input,int selectedIndex){
		
		if(selectedIndex == input.length() - 1 ){
			String result = input.substring(selectedIndex,input.length());
			return result;
		
		}
				
		for(int x=selectedIndex; x<input.length()-1 ; ++x){
			
			String currentchar = input.substring(x,x+1);
			String nextchar = input.substring(x+1,x+2);
		
			if(currentchar.equalsIgnoreCase(nextchar)){
				StringBuffer sb = new StringBuffer(input.substring(0,x+1));
				sb.append(input.substring(x+2));
				input = sb.toString();
			}
			
			stringRemoveDuplicates(input,x+1);
		}
		
		return input;
	}
	
}
