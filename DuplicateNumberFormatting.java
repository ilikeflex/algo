/**
Take as input str, a string. Write a recursive function which returns a new string in which all duplicate consecutive characters are separated "*" by a . E.g. for hello return hel*lo. Print the value returned

Input Format
Enter a String

Constraints
1<= Length of string <= 10^4

Output Format
Display the resulting string (i.e after inserting (*) b/w all the duplicate characters)

Sample Input
hello
Sample Output
hel*lo
Explanation
We insert a "*" between the two consecutive 'l' .
**/
import java.util.Scanner;
public class DuplicateNumberFormatting {

	public static void main(String[] str){
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		System.out.println(duplicateNumberFormatting(input,0));
	}
	
	private static String duplicateNumberFormatting(String input,int selectedIndex){
		
		String result = input;
		
		if(selectedIndex == input.length() - 1){
			return input;
		}
				
		for(int x=selectedIndex; x <= input.length()-1; ++x){
			
			if( x + 2 <= input.length() ){
				
				String currentchar = input.substring(x,x+1);
				String nextchar = input.substring(x+1,x+2);
				if(currentchar.equalsIgnoreCase(nextchar)){
					System.out.println("input="+input+",input.length="+input.length()+",x="+x+",x+1="+(x+1)+",currentchar="+currentchar+",nextchar="+nextchar+",pos="+x);
					result = duplicateNumberFormatting(input,x+1);
				}
				
				/*
				String newString ; 
				if(currentchar.equalsIgnoreCase(nextchar)){
					StringBuilder sb = new StringBuilder();
					sb.append(input.substring(0,x+1));
					sb.append("*");
					sb.append(input.substring(x+1));
					newString = new String(sb.toString());
				}
				else
					newString = new String(input);
				
				System.out.println("input="+input+",input.length="+input.length()+",x="+x+",x+1="+(x+1)+",currentchar="+currentchar+",nextchar="+nextchar+",newString="+newString);
				
				result = duplicateNumberFormatting(newString,x+1);
				*/
			}
			
			//result = input;
			
		}
		
		return result;
	}
}