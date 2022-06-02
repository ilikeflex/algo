Working On it.

/*
Ravi has been given two strings named string1 and string 2. He is supposed to find the minimum length substring of the string1 which contains all the 
characters of string2. Help him to find the substring

Input Format
The first line of the input contains string1. String1 can be a string containing spaces also. The second line of the input contains string2. String2 can be a 
string containing spaces also.

Constraints
Length of both the strings can be at max 10^4

Output Format
Output the substring in a single line. If no such substring exist then output "No String" without quotes

Sample Input
qwerty asdfgh qazxsw
qas
Sample Output
qazxs
Explanation
The substring "qazxs" is the shortest substring of s1 that contains all the characters of s2.

*/


function checkInString(input21, input22) {

	//String input21 = "qas";
	//String input22 = "qwerty";
	
	let result = false;
	let resultPositions = [];
	
	for( let x = 0 ; x < input21.length ; ++x ) {
	
		let input1Char = input21.substring(x,x+1);
		let matchFound = false;
		
		for( let y = x ; y < input22.length ; ++y ) {
			let input2Char = input22.substring(y,y+1);
			
			if( input1Char === input2Char ) {
				resultPositions[resultPositions.length] = { "char": input1Char, "pos" : y };
				matchFound = true;
				break;
			}
		}
		
		if(!matchFound) {
			break; 
		}
		
	}
	
	if(resultPositions.length === input21.length)
		result = true;

	console.log(`result= ${result} , resultPositions ${JSON.stringify(resultPositions)}, input21 = ${input21}, input22 = ${input22}` );

	return result;
}

function checkInSentence(input11, input12) {
	
	let result = false;
	let resultString = "No String";
	const input2Array = input12.split(" ");
	
	if(input2Array.length == 0){
		input2Array.push(input12);
	}
	
	for(let x = 0; x < input2Array.length ; ++x ){
		result = checkInString ( input11, input2Array[x] );
		if( result ) {
			resultString = input2Array[x];
			break;
		}
	}
	
	return resultString;
}

let input1 = "qas";
let input2 = "qwerty asdfgh qazxsw";
//let input2 = "qazxsw qwerty asdfgh";

console.log(checkInSentence(input1,input2));
