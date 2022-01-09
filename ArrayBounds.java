public class ArrayBounds {
	
	public static void main(String args[]){
		int[] array = { 1, 2, 3, 3, 3, 4, 4 };
		System.out.println(lowerBound(array,3));
		System.out.println(upperBound(array,3));
		System.out.println(upperBound(array,10));
	}
	
	public static void print(String statement) {
		System.out.println(statement);
	}
	
	public static int lowerBound(int[] array, int data){
		
		int ans = -1;
		int low = 0;
		int high = array.length - 1;
		
		
		while( high >= low ){ 
			
			int mid = (low+high)/2;
			
			/*print("LOOP BEGIN");
			print("mid" + mid + " value" + array[mid]);
			print("low" + low + " value" + array[low]);
			print("high" + high + " value" + array[high]);
			print("LOOP END");*/
			
			
			if( array[mid] == data ){
				high = mid - 1; //Only Change in Upper and Lower Bound
				ans = mid;
			}
			else if ( array[mid] > data ){
				high = mid - 1;
			}
			else if( array[mid] < data  ){
				low = mid + 1;
			}
		}
		
		return ans;
	}
	
	public static int upperBound(int[] array, int data){
		
		int ans = -1;
		int low = 0;
		int high = array.length - 1;
		
		
		while( high >= low ){ 
			
			int mid = (low+high)/2;
			
			/*print("LOOP BEGIN");
			print("mid" + mid + " value" + array[mid]);
			print("low" + low + " value" + array[low]);
			print("high" + high + " value" + array[high]);
			print("LOOP END");*/
			
			
			if( array[mid] == data ){
				low = mid + 1; //Only Change in Upper and Lower Bound
				ans = mid;
			}
			else if ( array[mid] > data ){
				high = mid - 1;
			}
			else if( array[mid] < data  ){
				low = mid + 1;
			}
		}
		
		return ans;
	}
}