import java.util.ArrayList;

public class Recursion {
	
	public static void print(String statement) {
		System.out.println(statement);
	}

	public static void print(String statement, boolean newline) {
		if (newline)
			System.out.println(statement);
		else
			System.out.print(statement);
	}
	
	public static void print(int statement) {
		System.out.println(statement);
	}

	public static void print(int statement, boolean newline) {
		if (newline)
			System.out.println(statement);
		else
			System.out.print(statement);
	}
	
	public static void print(int[] array){

		for(int n = 0;  n < array.length; ++n){
			print("index " + n + " value " + array[n]);
		}
	}
	
	public static void main(String args[]){
		
		
		//printIntegers(5);
		//PD(5);
		//PI(5);
		//PDI(5);
		//PDISkip(5);
		//print(Fact(4));
		//print(fib(6));
		//print(pow(2,5));
		//int[] array =  {3,8,6,1,9,7};
		//int[] array =  {5,4,4,4,2,1};
		//int[] array =  {1,2,4,4,4,5,7};
		//int[] array =  {1,2,5,7};
		//int[] array =  {1};
		//print("Result isSorted=" + isSorted(array,array.length-1));
		
		//int[] array =  {6,8,1,1,8,3,4};
		//print("Result integer at index = " + firstIndex(array,0,7));
		
		
		//int[] array =  {3,8,1,8,8,7};
		//print("Result integer at index = " + lastIndex(array,0,8));
		//print("Result integer at index = " + lastIndex(array,0,9));
		
		/*int[] array =  {3,8,1,8,8,7};
		print(allIndices(array,0,1, 0));*/

		//pattern(5,0,0);

		/*int[] array =  {3,8,1,8,8,7};
		bubbleSort(array,0, array.length);
		print(array);*/
		
		/*print(getSS("abcd").size());
		print(getSS("abcd").toString());*/
		
		/*print(getPermutation("abc").size());
		print(getPermutation("abc").toString());*/
		
		//print(getBoardPath(0,5).size());
		//print(getBoardPath(0,5).toString());
		
		//print(getMazePath(0,0,2).toString());
		//print(getMazePathImprove(0,0,2,2).toString());
		//print(getMazePathDiagonal(0,0,2,2).toString());
		
		
		//printSS("abc"); Not able to understand
		
		//printPermutation("abc","");
		
		//printBoardPath("",0,5);
		
		//printMazePath("",0,0,2,2);
		
		printMazePathDiagonal("",0,0,2,2);
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
	
	//print in increasing order
	public static void PI(int x){
		if(x == 0) return ;
		PI(x-1);		
		print(x);
	}
	
	//print in decreasing order
	public static void PDI(int x){
		if(x == 0) return ;
		print(x);
		PDI(x-1);
		print(x);
	}
	
	//print in decreasing order with skip for even numbers
	public static void PDISkip(int x){
	
		if(x==0)return;
	 
		if(x%2==1) // Print only odd numbers
			print(x);
	
		PDISkip(x-1);
		
		if(x%2==0) // Print only even numbers
			print(x);
				
	}
	
	public static int Fact(int n){
		
		if (n == 1 )return 1;
		int fnm1 = Fact(n-1);
		int fn = n * fnm1;
		return fn;
		
		/*if (n == 1 )return 1;
		return n*Fact(n-1);*/
	}
	
	public static int fib(int n){
		
		if (n == 0 || n == 1 ) return n;
		int fibn = fib(n-1) + fib(n-2);
		return fibn;
	
	}
	
	public static int pow ( int x, int n ) {
	
		if( n == 0 ) return 1;
		int result = x * pow ( x , n - 1 );
		return result;
	
	}
	
	
	public static boolean isSorted ( int[] array, int si ) {
	
		if( si == 0 ) return true;
		boolean result = (array[si] >= array[si-1]) && isSorted(array,si-1);
		return result;
	
	}
	
	public static int firstIndex(int[] arr, int si, int data){
		
		if(arr.length == si )
			return -1;
		
		if(arr[si] == data )
			return si;
		else 
			return firstIndex(arr,si+1,data);
		
	}
	
	public static int lastIndex(int[] arr, int si, int data){
		
		int match = -1;
				
		if(arr.length == si )
			return -1;
		
		if(arr[si] == data ) {
			match = si;
		}

		int result = lastIndex(arr,si+1,data);
		
		if( match > result ) 
			return match;
		else
			return result;
		
	}
	
	public static int[] allIndices(int[] arr, int si, int data, int count){
		if( si == arr.length) {
			int[] result = new int[count];
			return result;
		}

		int[] indices = null;

		if(arr[si] == data) {
			indices =  allIndices(arr,si+1,data, count + 1);
		}
		else {
			indices = allIndices(arr,si+1,data, count);
		}

		if ( arr[si] == data ) {
			indices[count] = si;
		}

		return  indices;
	}

	public static void pattern(int n, int row, int col) {

		for(int x = 0; x <= row; ++x){
			System.out.print("x");
		}
		System.out.println("");

		if( row == (n-1) )
			return;

		pattern(n, row+1, col +1 );

	}

	public static void bubbleSort(int[] arr, int si, int li){

		if( arr.length == si ) return;

		for( int x = si ; x < arr.length - 1; ++x) {
			for (int y = si + 1; y < arr.length -1 ; ++y) {
				if (arr[x] > arr[y+1]) {
					int temp = arr[y+1];
					arr[y+1] = arr[x];
					arr[x] = temp;
				}
			}
		}

		bubbleSort(arr,si+1, li);

	}
	
	//"hamburger".substring(4, 8) returns "urge" [ StartIndex from 0, beginIndex(4) is inclusive, endIndex(8) is exclusive ]
	
	//get Substring of given String
	//Sample: 
	//Input = "abc"
	//Output = { "", "c", "b", "a", "bc", "ac", "ab", "abc" }
	//Formula = 2 pow n = 2 pow 3 = 8
	// "cb", "ca" are not correct as this is permutation
	
	public static ArrayList<String> getSS(String inputString) {
		
		//System.out.println("Input" + inputString);
		
		if(inputString.length() == 0)	 {
			ArrayList<String> emptyArrayList = new ArrayList<>();
			emptyArrayList.add("");
			return emptyArrayList;
		}
		
		char cc = inputString.charAt(0);
		
		// String ros = inputString.substring(1); Can also work as it will start from first and till end.
		
		String ros = inputString.substring(1,inputString.length()); 
		
		ArrayList<String> recResult = getSS(ros); // recResult is recursion result
		
		//System.out.println("recResult" + recResult.toString());
		
		ArrayList<String> currentResult = new ArrayList<>();
		for(int index = 0; index < recResult.size(); ++index){
			currentResult.add(recResult.get(index));
			currentResult.add(cc+recResult.get(index));
		}
		
		//System.out.println("currentResult" + currentResult.toString());
		return currentResult;		
	}
	
	//Let Input String "abc"
	//Last Result  ""
	//With Character c ( megre "" with c) -> Output -> c
	//With String bc ( megre "b" with "c") -> Output -> bc,cb
	//With String abc	
	// Two Steps
	//			One Step ( ( megre "a" with "bc") -> Output abc,bac,bca
	//			Second Step ( ( megre "a" with "cb") -> Output acb,cab,cba
	public static ArrayList<String> getPermutation(String inputString) {
		
		//System.out.println("Input" + inputString);
		if(inputString.length() == 0)	 {
			ArrayList<String> emptyArrayList = new ArrayList<>();
			emptyArrayList.add("");
			return emptyArrayList;
		}
		
		char cc = inputString.charAt(0);
		// String ros = inputString.substring(1); Can also work as it will start from first and till end.
		String ros = inputString.substring(1,inputString.length()); 
		
		//System.out.println("InputString" + ros);
		ArrayList<String> recResult = getPermutation(ros); // recResult is recursion result
		//System.out.println("recResult" + recResult.toString());
		//System.out.println("recResult size" + recResult.size());
		
		ArrayList<String> currentResult = new ArrayList<>();
		for(int index=0; index<recResult.size(); ++index ){ // can be better loop -> for( String oneOfTheCombination : recResult );
			String oneOfTheCombination = recResult.get(index);
			//System.out.println("oneOfTheCombination" + oneOfTheCombination);
			//System.out.println("Length oneOfTheCombination " + oneOfTheCombination.length());
			
			for (int y=0; y<=oneOfTheCombination.length(); ++y ){
				
				String firstHalf = oneOfTheCombination.substring(0,y);
				String secondHalf = oneOfTheCombination.substring(y); 		// String secondHalf = oneOfTheCombination.substring(y); Can also work as it will start from first and till end.
				//System.out.println("firstHalf + cc + secondHalf = " + firstHalf + cc + secondHalf);
				currentResult.add(firstHalf + cc + secondHalf);
			}
			
		}
		
		//System.out.println("currentResult" + currentResult.toString());
		return currentResult;		
	}
	
	public static ArrayList<String> getBoardPath(int start,int end) {
		
		//System.out.println("Input: start,end = " + start +  "," + end);
		
		if(start > end){
			ArrayList<String> baseResult = new ArrayList<>();
			return baseResult;
		}
		
		if(start == end){
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}
		
		ArrayList<String> currentResult = new ArrayList<>();
		for(int dice=1; dice<=6; ++dice) {
			ArrayList<String> recResult = getBoardPath(start+dice,end); // start + dice, gives where we have reached the count
			for( String oneOfTheCombination : recResult ){
				currentResult.add(dice + oneOfTheCombination);
			}				
		}
					
		
		return currentResult;
	}
	
	
	public static ArrayList<String> getMazePath(int startx,int starty,int end) {
		
		System.out.println("Input: startx,starty,end = " + startx +  "," + starty +  "," + end);
		
		if(startx > end){
			ArrayList<String> endResult = new ArrayList<>();
			return endResult;
		}
		
		if(starty > end){
			ArrayList<String> endResult = new ArrayList<>();
			return endResult;
		}
		
		if(starty == end && startx == end){
			ArrayList<String> endResult = new ArrayList<>();
			endResult.add("");
			return endResult;
		}
		
		
		ArrayList<String> currentResult = new ArrayList<>();
		
		if(startx < end) {
				ArrayList<String> recResult = getMazePath(startx+1,starty,end);
				for( String oneOfTheCombination : recResult ) { // for condition which are not satisfied, empty array will return and will not contribut to end result
					currentResult.add("H" + oneOfTheCombination);
				}
		}
		
		if(starty < end) {
				ArrayList<String> recResult = getMazePath(startx,starty+1,end);
				for( String oneOfTheCombination : recResult ) { // for condition which are not satisfied, empty array will return and will not contribut to end result
					currentResult.add("V" + oneOfTheCombination);
				}
		}
		return currentResult;
	}
	
	
	
	public static ArrayList<String> getMazePathImprove(int startx,int starty,int endx, int endy) {
		
		System.out.println("Input: startx,starty,endx,endy = " + startx +  "," + starty +  "," + endx + "," + endy);
		
		if(startx > endx){
			ArrayList<String> endResult = new ArrayList<>();
			return endResult;
		}
		
		if(starty > endy){
			ArrayList<String> endResult = new ArrayList<>();
			return endResult;
		}
		
		if(starty == endx && startx == endy){
			ArrayList<String> endResult = new ArrayList<>();
			endResult.add("");
			return endResult;
		}
		
		
		ArrayList<String> currentResult = new ArrayList<>();
		
	
		ArrayList<String> recResultHorizontal = getMazePathImprove(startx+1,starty,endx,endy);//horizontal move
		for( String oneOfTheCombination : recResultHorizontal ) {
			currentResult.add("H" + oneOfTheCombination);
		}
		

		ArrayList<String> recResultVertical = getMazePathImprove(startx,starty+1,endx,endy); //vertical move
		for( String oneOfTheCombination : recResultVertical ) {
			currentResult.add("V" + oneOfTheCombination);
		}
		
		return currentResult;
	}
	
	
	public static ArrayList<String> getMazePathDiagonal(int startx,int starty,int endx, int endy) {
		
		System.out.println("Input: startx,starty,endx,endy = " + startx +  "," + starty +  "," + endx + "," + endy);
		
		if(startx > endx){
			ArrayList<String> endResult = new ArrayList<>();
			return endResult;
		}
		
		if(starty > endy){
			ArrayList<String> endResult = new ArrayList<>();
			return endResult;
		}
		
		if(starty == endx && startx == endy){
			ArrayList<String> endResult = new ArrayList<>();
			endResult.add("");
			return endResult;
		}
		
		
		ArrayList<String> currentResult = new ArrayList<>();
		
		
		ArrayList<String> recResultHorizontal = getMazePathDiagonal(startx+1,starty,endx,endy);//horizontal move
		for( String oneOfTheCombination : recResultHorizontal ) {
			currentResult.add("H" + oneOfTheCombination);
		}
		
		ArrayList<String> recResultVertical = getMazePathDiagonal(startx,starty+1,endx,endy); //vertical move
		for( String oneOfTheCombination : recResultVertical ) {
			currentResult.add("V" + oneOfTheCombination);
		}
		
		ArrayList<String> recResultDiagonal = getMazePathDiagonal(startx+1,starty+1,endx,endy); //diagonal move
		for( String oneOfTheCombination : recResultDiagonal ) {
			currentResult.add("D" + oneOfTheCombination);
		}
			
		
		return currentResult;
	}
	
	/*
	static void printSS(String inputString,String result) {
		
		if(inputString.length==0)
			return;
		else
			System.out.println(inputString);
				
		char cc = inputString.getChar(0);
		String ros = inputString.substring(1,inputString.length());
		
		ArrayList<String> currentResult = new ArrayList<>();
		
		printSS(ros);
		
		for(String oneOfTheCombination:recResult)
			System.out.println(cc+oneOfTheCombination);
		
		return currentResult;
		
	}
	*/
	
	static void printPermutation(String question, String answer) {
		
		//System.out.println("InputString question + answer = " + question + "," + answer);
		
		if(question.length()==0)
			System.out.println(answer);
		
		for(int x=0; x<question.length(); ++x){
			String firstHalf = question.substring(0,x); // first half
			String cc = question.substring(x,x+1); //get single character
			String secondHalf = question.substring(x+1,question.length()); // get secondHalf
			//System.out.println("firstHalf + cc + secondHalf = " + firstHalf + "," + cc + "," +secondHalf);
			String newQuestion =  firstHalf+secondHalf;
			String newAnswer = answer + cc;
			printPermutation(newQuestion,newAnswer);
		}
		
		
	}
	
	
	static void printBoardPath(String diceTotalPath, int diceTotal, int finalNumber) {
		
		//System.out.println("InputString diceTotalPath,diceTotal,finalNumber = " + diceTotalPath + "," + diceTotal + "," + finalNumber);
		
		if(diceTotal==finalNumber) {
			System.out.println(diceTotalPath);
			return;
		}
		
		if(diceTotal>finalNumber)
			return;
		
		
		for(int currentDiceNumber=1; currentDiceNumber<6; ++currentDiceNumber){
			int addAllDiceNumbersTotal = currentDiceNumber + diceTotal;
			String newdiceTotalPath = String.valueOf(currentDiceNumber) + diceTotalPath;
			//System.out.println("newdiceTotalPath = " + newdiceTotalPath);
			printBoardPath(newdiceTotalPath,addAllDiceNumbersTotal,finalNumber);			
		}
			
	}
	
	
	
	static void printMazePath(String answer, int startx, int starty,  int endx, int endy) {
		
		//System.out.println("InputString diceTotalPath,diceTotal,finalNumber = " + diceTotalPath + "," + diceTotal + "," + finalNumber);
		
		if(startx==endx && starty==endy) {
			System.out.println(answer);
			return;
		}
		
		if(startx>endx) {
			return;
		}
		
		if(starty>endy) {
			return;
		}
		
		String newHanswer = answer + "H";
		printMazePath(newHanswer,startx+1,starty,endx,endy);
		
		String newVanswer = answer + "V";
		printMazePath(newVanswer,startx,starty+1,endx,endy);
			
	}
	
	static void printMazePathDiagonal(String answer, int startx, int starty,  int endx, int endy) {
		
		//System.out.println("InputString diceTotalPath,diceTotal,finalNumber = " + diceTotalPath + "," + diceTotal + "," + finalNumber);
		
		if(startx==endx && starty==endy) {
			System.out.println(answer);
			return;
		}
		
		if(startx>endx) {
			return;
		}
		
		if(starty>endy) {
			return;
		}
		
		String newHanswer = answer + "H";
		printMazePathDiagonal(newHanswer,startx+1,starty,endx,endy);
		
		String newVanswer = answer + "V";
		printMazePathDiagonal(newVanswer,startx,starty+1,endx,endy);
		
		String newDanswer = answer + "D";
		printMazePathDiagonal(newDanswer,startx+1,starty+1,endx,endy);
		
			
	}
	
}
