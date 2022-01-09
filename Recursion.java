public class Recursion {
	
	public static void print(String statement) {
		System.out.println(statement);
	}
	
	public static void print(int statement) {
		System.out.println(statement);
	}
	
	public static void main(String args[]){
		//printIntegers(5);
		//PD(5);
		//PI(5);
		PDI(5);
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
		PD(x-1);
	}
	
	public static void PI(int x){
		if(x == 0) return ;
		PI(x-1);		
		print(x);
	}
	
	
	public static void PDI(int x){
		if(x == 0) return ;
		print(x);
		PDI(x-1);
				
		print(x);
		if(x == 5) return ;		
	}
	
}
