//Backtracing
public class QueenPermutation {

	public static void main(String[] args) {
		QueenPermutation(new boolean[4], 0, 2, "") ;
	}
	
	//qpsf = quuen place so far
	//tq = total queen
	//answer = answer like ( b0q0 -> box zero and queen zero )
	//boxes = total boxes in which queens needs to be placed. There will be only one queen in each box.
	public static void QueenPermutation(boolean[] boxes, int qpsf, int tq, String answer) {
		
		if (qpsf == tq) {
			System.out.println(answer);
			return;
		}
		
		for (int i = 0; i < boxes.length; ++i ) {			
			
			if( boxes[i] == false){ // check if the queen is not present then place the queen else ignore position
				boxes[i] = true;
				QueenPermutation(boxes, qpsf + 1, tq , answer + "b" + i + "q" + qpsf + ",");
				boxes[i] = false;
			}
		}
	}
}