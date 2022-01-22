import java.lang.Integer;

public class StringToInteger {

	public static void main(String[] args){
		System.out.println("Hello World");
		System.out.println(stringToInteger("98752"));
	}
		
	static int stringToInteger(String input){
		
		//System.out.println("First Statement input="+input+",input.lenght="+input.length());
	
		if(input.length() == 0)
		{
			return 0;
		}

		
		//int low = 0;
		//int high = input.length() - 1;
		int total = 0;
		
		for(int x=0,y=input.length()-1; x<1; ++x,--y){ //!!!! Loop is running only once !!!!
			String currentChar = input.substring(x,x+1); // first is inclusive and second is exclusive
			String ros = input.substring(x+1); // It can also be written as String ros = input.substring(x+1);
			//System.out.println("Match 1 currentChar="+currentChar+",ros="+ros+",x="+x);
			int currentCharAsInt = Integer.parseInt(currentChar);
			int currentValue =  currentCharAsInt * (int)Math.pow(10, y);
			//System.out.println("Befor Recursive Loop x="+x+",currentChar="+currentChar+",ros="+ ros + ",currentValue="+currentValue+",total="+total);
			int prevValue = stringToInteger(ros);
			//System.out.println("Mid Recursive Loop prevValue=" + prevValue);
			total = currentValue + prevValue;
			//System.out.println("Match 2 currentChar="+currentChar+",ros="+ros+",x="+x);
			//System.out.println("After Recurcive currentValue="+currentValue+"total="+total+",input="+input);
		}
		
		return total;
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