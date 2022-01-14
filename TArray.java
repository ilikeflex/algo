import java.util.ArrayList;

public class TArray {
	
	public static void print(String statement) {
		System.out.println(statement);
	}
	
	public static void print(int statement) {
		System.out.println(statement);
	}
	
	public static void print(int[] array){
		for(int n = 0;  n < array.length; ++n){
			print(array[n]);
		}
	}
	
	public static void main(String args[]){
	
		/*ArrayList completeArray = new ArrayList();
		completeArray.add(100);
		System.out.println("array" + completeArray);
		print("array" + completeArray);*/
		
		int[] completeArray = {};
		//completeArray[completeArray.length-1] = 100;
		System.out.println("array" + completeArray.length);
		print("array" + completeArray);
		print(completeArray);
	}
}