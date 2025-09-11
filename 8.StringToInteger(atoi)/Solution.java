/*
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit
 * signed integer.
 * 
 * The algorithm for myAtoi(string s) is as follows:
 * Whitespace: Ignore any leading whitespace (" ").
 * 
 * Signedness: Determine the sign by checking if the next character is '-' or '+',
 * assuming positivity if neither present.
 * 
 * Conversion: Read the integer by skipping leading zeros until a non-digit
 * character is encountered or the end of the string is reached. If no digits were
 * read, then the result is 0.
 * 
 * Rounding: If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1],
 * then round the integer to remain in the range. Specifically, integers less
 * than -2^31 should be rounded to -2^31, and integers greater than 2^31 - 1 should
 * be rounded to 2^31 - 1.
 * 
 * Return the integer as the final result.
*/

public class Solution {

    public void conversionAtoi(StringBuilder s) {
        char c;

        if (s.length() == 1 && (s.charAt(0) == '+' || s.charAt(0) == '-')) s.setCharAt(0, '0');
        else {
            int i = 0;
            while (i < s.length()) {
                c = s.charAt(i);

                if (c == '+' || c == '-') {
                    i++;
                    continue;
                }
                else if (c == '0') {
                    s.deleteCharAt(i);
                }
                else break;
            }
        }        

        if (s.length() == 0) s.append('0');
        else if (s.length() == 1 && (s.charAt(0) == '+' || s.charAt(0) == '-')) s.setCharAt(0, '0');

        return;
    }

    public int roundingAtoi(StringBuilder s) {
        StringBuilder aux = new StringBuilder(s);
        String max = "2147483647";
        char c, d, signal;
        int result = 0;

        signal = aux.charAt(0);
        if (signal == '+' || signal == '-') aux.deleteCharAt(0);
        if (aux.length() > 10) {
            if (signal == '-') result = -1;
            else result = 1;
        }
        else if (aux.length() < 10) result = 0;
        else {
            for (int i = 0; i < aux.length(); i++) {
                c = aux.charAt(i);
                d = max.charAt(i);
                if (c - '0' < d - '0') {
                    break;
                }
                else if (c - '0' > d - '0') {
                    if (signal == '-') result = -1;
                    else result = 1;
                    break;
                }
            }
        }

        return result;
    }

    public int myAtoi(String s) {
        StringBuilder original = new StringBuilder(s);
        StringBuilder auxiliary = new StringBuilder();
        int answer = 0;
        int len = original.length();

        char character;
        for (int i = 0; i < len; i++) {
            character = original.charAt(i);
            
            if (character == ' ' && auxiliary.length() == 0) continue;
            else if ((character == '+' || character == '-') && auxiliary.length() == 0) auxiliary.append(character);
            else if (character < '0' || character > '9') break;
            else auxiliary.append(character);
        }
        conversionAtoi(auxiliary);
        int r = roundingAtoi(auxiliary);
        
        if (r == 1) answer = Integer.MAX_VALUE;
        else if (r == -1) answer = Integer.MIN_VALUE;
        else answer = Integer.parseInt(auxiliary.toString());

        return answer;
    }
}
