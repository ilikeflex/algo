/*
Take as input str, a string. Write a recursive function which moves all ‘x’ from the string to its end.
E.g. for "abexexdexed" return "abeedeedxxx".
Print the value returned

Input Format
Single line input containing a string

Constraints
Length of string <= 1000

Output Format
Single line displaying the string with all x's moved at the end

Sample Input
axbxc
Sample Output
abcxx
Explanation
All x's are moved to the end of string while the order of remaining characters remain the same.
*/

import java.util.Scanner;

public class MoveAllXtoEnd {
	
	
	public static void main(String str[]){
			
		Scanner s = new Scanner(System.in);
		System.out.println("Enter String");
		String inputString = s.nextLine();
		moveallXtoEnd(inputString,0);
		//System.out.println("Answer " + inputString);
		
	}
	
	
	public static void moveallXtoEnd2(String inputString, int position){
		
		if ( position == inputString.length() - 1 )
			return ; 
			
		String s = inputString.substring(position,position+1);
		if( s.equalsIgnoreCase("X") )
		{
			//remove x
			String prexString = inputString.substring(0,position);	
			String postxString = inputString.substring(position+1,inputString.length());	
			//inputString = prexString.append(postxString).append(s);
			inputString = prexString + postxString + s;
		}
		
		System.out.println(String.format("Input String {%s} , position {%d}, length = {%d}" , inputString, position, inputString.length() ));
		moveallXtoEnd(inputString, position + 1);

	}
	
	public static void moveallXtoEnd(String inputString, int position){
		
		if ( position == inputString.length() - 1 )
			return ; 
			
		String s = inputString.substring(position,position+1);
		if( s.equalsIgnoreCase("X") )
		{
			//remove character 'x'
			String prexString = inputString.substring(0,position);	
			String postxString = inputString.substring(position+1,inputString.length());	
			//inputString = prexString.append(postxString).append(s);
			inputString = prexString + postxString + s;
		}
		
		System.out.println(String.format("Input String {%s} , position {%d}, length = {%d}" , inputString, position, inputString.length() ));
		moveallXtoEnd(inputString, position + 1);

	}
}