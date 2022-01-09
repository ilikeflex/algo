public class Recursion {
	
	public static void print(String statement) {
		System.out.println(statement);
	}
	
	public static void print(int statement) {
		System.out.println(statement);
	}
	
	public static void main(String args[]){
		printIntegers(5);
		PD(5);
	}
	
	public static int printIntegers(int x){
		
		if(x == 0) return -1;
		else {
			print(x);
			return printIntegers(x-1);
		}
	}
	
	
	public static void PD(int x){
		
		if(x == 0) return ;
		print(x);
		printIntegers(x-1);
		
	}
	
}