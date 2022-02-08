/**Replace all occurrences of pi with 3.14

Input Format
Integer N, no of lines with one string per line

Constraints
0 < N < 1000
0 <= len(str) < 1000

Output Format
Output result one per line

Sample Input
3
xpix
xabpixx3.15x
xpipippixx
Sample Output
x3.14x
xab3.14xx3.15x
x3.143.14p3.14xx
Explanation
All occurrences of pi have been replaced with "3.14".
**/
import java.util.Scanner;
public class ReplaceAllPie {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(replaceAllPie(input,0, false));
    }

    static String replaceAllPie(String input, int selectedIndex, boolean isPiPresent){

        String s = String.format("Input String=%s ,Length=%d, selectedIndex=%d, isPiPresent=%s",input,input.length(),selectedIndex,isPiPresent);
        //System.out.println(s);

        if(input.length() < selectedIndex + 2 && !isPiPresent) {
            System.out.println("input.length() < selectedIndex + 2 && !isPiPresent");
            return "";
            //return "EMPTY";
        }


        if(input.length() < selectedIndex + 2 && isPiPresent) {
            System.out.println("input.length() < selectedIndex + 2 && isPiPresent");
            return input;
        }

        String currentString = input.substring(selectedIndex,selectedIndex+2);

        if(currentString.equalsIgnoreCase("pi")){
            input = replacePiWithDecimal(input,selectedIndex);
            isPiPresent = true;
        }

        return replaceAllPie(input,selectedIndex+1, isPiPresent);

    }


    static String replacePiWithDecimal(String input, int selectedIndex){

        String pi = input.substring(selectedIndex,selectedIndex+2);
        String result;

        if("pi".equalsIgnoreCase(pi)){
            StringBuffer newInput = new StringBuffer();
            String fp = input.substring(0,selectedIndex);
            String piString = input.substring(selectedIndex,selectedIndex+2);
            String sp = input.substring(selectedIndex+2);
            String pieNumerical = "3.14";

            newInput.append(fp);
            newInput.append(pieNumerical);
            newInput.append(sp);

            result = newInput.toString();
        }
        else {
            result = input;
        }

        String s = String.format("replacePiWithDecimal Input String =%s ,OutputString %s",input,result);
        //System.out.println(s);
        return result;
    }

}