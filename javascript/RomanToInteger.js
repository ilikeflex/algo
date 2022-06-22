/*

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, 
  which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. 
Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. 
There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

*/


/**
 * @param {string} s
 * @return {number}
 */

let notation = { 
    "I":1,
    "V":5,
    "X":10,
    "L":50,
    "C":100,
    "D":500,
    "M":1000
}

var romanToInt = function(s) {
    
    let count = 0;
    
    let len = s.length;
    //console.log(`input=${s} and length=${len} and s.substring(0,1)=${s.substring(0,1)}`);
	
    for(var k = 0; k < len; ){
        
        var lastIndex = k+1 >= len ? len : k+1;
        var currentChar = s.substring(k,lastIndex)
		//console.log(`currentChar=${currentChar}`);
		        
        var end = lastIndex + 1 >= len ? len : lastIndex + 1;
        var nextChar = s.substring(lastIndex,end);
		//console.log(`nextChar=${nextChar}`);
        
        var currentValue = notation[currentChar];
        var nextValue = notation[nextChar];
		
		//console.log(`currentValue=${currentValue}`);
		//console.log(`nextValue=${nextValue}`);
        
        if( currentValue < nextValue ) {
            k = k + 2;
            count = count + (nextValue - currentValue);
        }
        else {
            k = k + 1;
            count = count + currentValue;
        }
		
		//console.log(`count=${count}`);
		//console.log(`k=${k}`);
        
    }
    
    return count;
    
};

console.log(`Result=${romanToInt('IV')}`);
console.log(`Result=${romanToInt('III')}`);
console.log(`Result=${romanToInt('MCMXCIV')}`);
