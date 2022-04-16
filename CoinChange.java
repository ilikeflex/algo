public class CoinChange {

static int count = 0;

 public static void main(String[] args){
	int[] coins = {2,3,5,6};
	int amount = 10;
	System.out.println("COMBINATION");
	coinChangeCombination(coins, amount, "", 0);
	count = 0;
	System.out.println("PERMUTATION");
	coinChangeCombinationPermutation(coins, amount, "", 0);
 }
 
 
 static void coinChangeCombination(int[] coins, int amount, String answer, int lastDenomIndex){
 
	//System.out.println(String.format("amount={%d},answer={%s},lastDenomIndex={%d}",amount,answer,lastDenomIndex));
	
	if ( amount == 0 ) {
		++count;
		System.out.println(count + " " + answer);
	}
 
	for ( int x = lastDenomIndex ; x < coins.length ; ++x ){
		if( amount >= coins[x] )
			coinChangeCombination(coins, amount - coins[x], answer + coins[x], x);
	}
 
 }
 
  static void coinChangeCombinationPermutation(int[] coins, int amount, String answer, int lastDenomIndex){
 
	//System.out.println(String.format("amount={%d},answer={%s},lastDenomIndex={%d}",amount,answer,lastDenomIndex));
	
	if ( amount == 0 ) {
		++count;
		System.out.println(count + " " + answer);
	}
 
	for ( int x = lastDenomIndex ; x < coins.length ; ++x ){ //lastDenomIndex is redundent and it is always zero.
		if( amount >= coins[x] )
			coinChangeCombinationPermutation(coins, amount - coins[x], answer + coins[x], lastDenomIndex);
	}
 
 }

}