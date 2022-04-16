//Backtracing
public class QueenPermutation {

	static int count = 0;
	
	public static void main(String[] args) {
		QueenPermutation(new boolean[4], 0, 2, "") ;
	}
	
	//qpsf = quuen place so far
	//tq = total queen
	//answer = answer like ( b0q0 -> box zero and queen zero )
	//boxes = total boxes in which queens needs to be placed. There will be only one queen in each box.
	public static void QueenPermutation(boolean[] boxes, int qpsf, int tq, String answer) {
		
		if (qpsf == tq) {
			++count;
			System.out.println(count + " " + answer);
			return;
		}
		
		for (int i = 0; i < boxes.length; ++i ) {			
			
			if( boxes[i] == false){ // check if the queen is not present then place the queen else ignore position
				boxes[i] = true;
				//System.out.println(String.format("queenplaced at box ={%d},qpsf={%d},tq={%d},answer={%s},loop={%d}", i, qpsf + 1, tq , answer + "b" + i + "q" + qpsf + "," , i));
				QueenPermutation(boxes, qpsf + 1, tq , answer + "b" + i + "q" + qpsf + ",");
				boxes[i] = false;
			}
		}
	}
}