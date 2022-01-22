public class ArrayAlgos 	{
	
	public static void print(String statement) {
		System.out.println(statement);
	}
	
	public static void print(String statement, boolean newLine) {
		if(newLine)
			System.out.println(statement);
		else
			System.out.print(statement);
	}
	
	public static void printArray(int[] array) {
		for(int arrayIndex=0; arrayIndex<=array.length-1 ; ++arrayIndex){
			print("value at  index " + arrayIndex +  " = " +  array[arrayIndex]);
		}
	}
	
	public static void print(int[] array) {
		for(int arrayIndex=0; arrayIndex<=array.length-1 ; ++arrayIndex){
			if(arrayIndex < (array.length-1) )
				print("[" + arrayIndex +  "]=" +  array[arrayIndex] + ",", false);
			else
				print("[" + arrayIndex +  "]=" +  array[arrayIndex], false);
		}
		System.out.println("");
	}
	
	public static void main(String arr[]){
		print("Hello World");
				
		/*int[] array = { 88,11,44,99,55 };
		print("Input Array");
		printArray(array);
		bubbleSort(array);
		print("Sorted Array");
		printArray(array);*/

		//arraySelectionSort(array);
		
		/*int[] array = { 88,11,44,99,55 };
		int item = 99;
		print("LinearSearch Result " +  linearSearch(array,item));*/
		
		//int[] array = { 2,6,8,12,14,16,20,24,26,34 }; [ BinarySearch Needs Array Item In Sorted Order ]
		//print("BinarySearch Result " +  binarySearch(array, 16));
		
		
		/*int[] array1 = {10,11,44,45,55};
		int[] array2 = {4};*/
		//printArray(mergeTwoSortedArrays(array1,array2));
		
		/*int[] array = {45,78,12,45};
		print("Input Array");
		printArray(array);
		print("Result Array");
		printArray(mergeSort(array,0,array.length-1));*/
		
		
		
		//int[] array = {40,20,90,30,70,10,80,60,50};
		int[] array = {40,20,90,30,70};
		print("Input Array");
		print(array);
		quickSort(array,0,array.length-1);
		print("Result Array");
		print(array);
		
	}
	
	public static void quickSort(int[] array, int low, int high){
		
		//print(array);		
		if(low >= high) {
			return;
		}
						
		int left = low;
		int right = high;
		int pivotPoint = (low + high)/2;
		
		//print("Before Bigger Loop left=" + left + " ,right=" + right);
		
		while(left<=right){		
			
			//print("left" + left + " ,array[left]" + array[left]);
			//print("pivotPoint" + pivotPoint + " ,array[pivotPoint]" + array[pivotPoint]);
			while(array[left]<array[pivotPoint]){
				//print("inside left loop left" + left + " ,array[left]" + array[left]);
				++left;
			}
			//print("Left should be 2 and value should be 90, left=" + left + " ,array[left]=" + array[left]);
			while(array[right]>array[pivotPoint]){
				--right;
			}
			
			if(left<=right){
				//print("swap");
				//print("swap left" + left + " ,array[left]" + array[left]);
				//print("swap right" + right + " ,array[right]" + array[right]);
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				
				++left;
				--right;
			}
			
			/*++left; This does not work but why ???
			--right;*/
			
			
			print("After each loop");
			print(array);	
		}
		
		//print("End Bigger Loop left=" + left + " ,right=" + right);
		quickSort(array,low,right);
		quickSort(array,left,high);
		
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

	//Input: Array	
	//Result will be Sorted Array as array is passed by reference
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
	
	//MergeSort:
	//Input: Array1 which all elements in sorted order ( increasing order)
	//Input: Array2 which all elements in sorted order ( increasing order)
	//Output: Array3(Result) which will have all elements sorted combined of array1 and array2
	public static int[] mergeTwoSortedArrays(int[] array1,int[] array2){
		int[] result = new int[array1.length + array2.length];
		
		int i=0,j=0,k=0;
		
		while ( i < array1.length || j < array2.length ) {
			
			if( i == array1.length && j < array2.length )
			{
				result[k] = array2[j];
				++k;
				++j;
			}
			
			if( j == array2.length && i < array1.length )
			{
				result[k] = array1[i];
				++k;
				++i;
			}
			
			if(i < array1.length && j < array2.length && array1[i]<array2[j]){
				result[k] = array1[i];
				++k;
				++i;
			}
			else if(i < array1.length && j < array2.length && array1[i]>=array2[j]){
				result[k] = array2[j];
				++k;
				++j;
			}				
		}
		
		return result;
		
	}
	
	public static int[] mergeSort(int[] array,int low, int high){
		
		if( low == high ) {
			//System.out.println("Value" + low + "array.length=" + array.length);
			int[] result = new int[1];
			result[0] = array[low];
			return result;
		}
			
		
		int mid = (low+high)/2;
		
		int[] fh = mergeSort(array,low,mid);
		int[] sh = mergeSort(array,mid+1,high);
		
		int[] result = mergeTwoSortedArrays(fh,sh);
		
		return result;
	}
	
	
	
	
	private static int[] getArrayElements(int[] array,int start, int end){
		
		System.out.println("start=" + start + ",end=" + end);
		
		int[] result = new int[end-start];
		for(int x = start, y = 0; x < end; ++x, ++y)
			result[y] = array[x];
		
		return result;
		
	}
	
	//Input: Array
	//Input: Item to find in Array
	//Result: Location of the item in array
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
	
	//Input: Sorted Array
	//Input: Item to find in Array
	//Prequiste : Array should be sorted
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
