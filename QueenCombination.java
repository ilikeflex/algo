//Backtracing
public class QueenCombination {

	public static void main(String[] args) {
		QueenCombination(new boolean[4], 0, 2, "", -1) ;
	}
	
	static int count = 0;
	//qpsf = quuen place so far
	//tq = total queen
	//answer = answer like ( b0q0 -> box zero and queen zero )
	//boxes = total boxes in which queens needs to be placed. There will be only one queen in each box.
		
	
	public static void QueenCombination(boolean[] boxes, int qpsf, int tq, String answer, int lastBoxUsed) {
		
		if (qpsf == tq) {
			count++;
			System.out.println(count + ". " + answer);
			return;
		}
		
		for (int i = lastBoxUsed + 1 ; i < boxes.length; ++i ) {
			
			//System.out.println(String.format("lastBoxUsed={%d},qpsf={%d},tq={%d},answer={%s},loop={%d}", lastBoxUsed, qpsf + 1, tq , answer + "b" + i + "q" + qpsf + "," , i));
			
			if( boxes[i] == false){ // check if the queen is not present then place the queen else ignore position
				boxes[i] = true;
				QueenCombination(boxes, qpsf + 1, tq , answer + "b" + i + "q" + qpsf + "," , i);
				boxes[i] = false;
			}
		}
	}
}