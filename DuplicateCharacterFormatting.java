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
public class DuplicateCharacterFormatting {

	public static void main(String[] str){
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		System.out.println(duplicateNumberFormatting(input,0));
	}
	
	private static String duplicateNumberFormatting(String input,int selectedIndex){
		
		//System.out.println("input="+input+",selectedIndex="+selectedIndex+",input.length()-1="+(input.length() - 1));
		
		if(selectedIndex == input.length() - 1 ){
			String result = input.substring(selectedIndex,input.length());
			//System.out.println("Result="+result);
			return result;
			//return input;
		}
				
		for(int x=selectedIndex; x<input.length()-1 ; ++x){
			
			String currentchar = input.substring(x,x+1);
			String nextchar = input.substring(x+1,x+2);
		
			if(currentchar.equalsIgnoreCase(nextchar)){
				StringBuffer sb = new StringBuffer(input.substring(0,x+1));
				sb.append("*");
				sb.append(input.substring(x+1));
				x = x + 1;
				input = sb.toString();
			}
			
			System.out.println("Before input="+input+",selectedIndex="+selectedIndex+",input.length()-1="+(input.length() - 1)+",currentchar="+currentchar+",nextchar="+nextchar);
			duplicateNumberFormatting(input,x+1);
			System.out.println("After input="+input+",selectedIndex="+selectedIndex+",input.length()-1="+(input.length() - 1)+",currentchar="+currentchar+",nextchar="+nextchar);
		}
		
		return input;
	}
	
}
