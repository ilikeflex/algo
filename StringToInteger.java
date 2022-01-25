import java.lang.Integer;
import java.util.Scanner;

public class StringToInteger {

	public static void main(String[] args){
		
		//System.out.println(convertStringtoInteger("98752"));
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(convertStringtoInteger(input));
	}
		
	static int stringToInteger(String input){
	
		if(input.length() == 0)
		{
			return 0;
		}

		int total = 0;
		
		for(int x=0,y=input.length()-1; x<1; ++x,--y){ //!!!! Loop is running only once !!!!
			String currentChar = input.substring(x,x+1); // first is inclusive and second is exclusive
			String ros = input.substring(x+1); // It can also be written as String ros = input.substring(x+1);
			
			int currentCharAsInt = Integer.parseInt(currentChar);
			int currentValue =  currentCharAsInt * (int)Math.pow(10, y);
			
			int prevValue = stringToInteger(ros);
			
			total = currentValue + prevValue;
		}
		
		return total;
	}
	
	
	static int convertStringtoInteger(String input){
	
		int result = -1;
		String currentChar = input.substring(0,1); // getFirstCharacter
		
		//if( currentChar == "-") { // This does not work because it checks for address space
		if( currentChar.equals("-") ) {
			String ros = input.substring(1);	
			result = -1 * stringToInteger(ros);
		}
		else
			result = stringToInteger(input);
		
		return result;

	}	
	
	static int stringToIntegerWithoutRecursion(String input){
				
		int low = 0;
		int high = input.length() - 1;
		int total = 0;
		
		for( int x = 0, y = high; x <= high; ++x, --y){
		
			String currentChar = input.substring(x,x+1); // first is inclusive and second is exclusive
			String ros = input.substring(x+1); // It can also be written as String ros = input.substring(x+1);
			System.out.println("currentChar="+currentChar+",ros="+ros);
			int currentCharAsInt = Integer.parseInt(currentChar);
			int currentValue =  currentCharAsInt * (int)Math.pow(10, y);
			System.out.println("currentValue="+currentValue);
			total = total + currentValue;
		}
		
		return total;
	}

}