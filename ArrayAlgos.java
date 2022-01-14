public class ArrayAlgos {
	
	public static void print(String statement) {
		System.out.println(statement);
	}
	
	public static void printArray(int[] array) {
		for(int arrayIndex=0; arrayIndex<=array.length - 1 ; ++arrayIndex){
			print("value at  index " + arrayIndex +  " = " +  array[arrayIndex]);
		}
	}
	
	public static void main(String arr[]){
		print("Hello World");
				
		int[] array = { 88,11,44,99,55 };

		printArray(array);
		bubbleSort(array);
		printArray(array);

		//arraySelectionSort(array);
		//int[] array = { 2,6,8,12,14,16,20,24,26,34 };
		//int item = 20;
		//print("LinearSearch Result " +  linearSearch(array,item));
		//print("BinarySearch Result " +  binarySearch(array,item));
	}
	
	public static void arraySelectionSort(int[] array){
		for ( int counter = 0; counter < array.length -1; ++counter )
		{
			int min = counter;
			for(int arrayIndex = counter + 1; arrayIndex < array.length-1 ; ++arrayIndex) {
				if(array[min]>array[arrayIndex]) //change here to change the increasing or decreasing order
					min = arrayIndex;
			}
			swap(array, counter , min );
		}
	}
	
	public static void swap(int array[], int arrayIndex, int arrayIndex2) {
		int temp = array[arrayIndex];
		array[arrayIndex] = array[arrayIndex2];
		array[arrayIndex2] = temp;
	}
	
	public static void bubbleSort (int[] array){
		for ( int counter = 0; counter <= array.length; ++counter )
		{
			for(int arrayIndex=0; arrayIndex<array.length - ( 1 + counter ); ++arrayIndex)
			{
				if(array[arrayIndex]>array[arrayIndex+1]) //change here to change the increasing or decreasing order
					swap(array, arrayIndex , arrayIndex+1);
			}
		}
	}
	
	public static int linearSearch (int[] array, int item){
		print("Inside linearSearch");
		int index = -1;
		//for(int arrayIndex: array) { // This loop will not work as this gives the value in the array but not the location
		for(int arrayIndex = 0; arrayIndex < array.length -1; ++arrayIndex ){
			if(array[arrayIndex] == item){
				index = arrayIndex;
				break;
			}
		}
		return index;
	}
	
	public static int binarySearch (int[] array, int item){
		print("Inside binarySearch");
		int index = -1;
		
		int high = array.length - 1;
		int low = 0;
		int mid = (high + low) / 2;
		
		while(high >= low) {
			
			print("Executing Loop");
			print("mid" + mid + "value" + array[mid]);
			print("low" + low + "value" + array[low]);
			print("high" + high + "value" + array[high]);
			print("item" + item);
			
			print("array[mid]" + array[mid]);
			
			if( array[mid] > item ){
				high = mid - 1;
			}
			else if( array[mid] < item ){
				low = mid + 1;
			}
			else if( array[mid] == item ) {
				index = mid;
				break;
			}
			
			mid = (high + low) / 2;
			
		}
		
		return index;
	}
}
