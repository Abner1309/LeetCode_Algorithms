/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given
 * number of rows like this:
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 */

public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder string_original = new StringBuilder(s);
        StringBuilder string_final = new StringBuilder();
        int[] jump = new int[string_original.length()];
        int middle = numRows - 2;
        int step = numRows + middle;

        if (numRows == 1) {
            return string_original.toString();
        }
        else if (numRows == 2) {
            char character;
            for (int i = 0; i < numRows; i++) {
                for (int j = i; j < string_original.length(); j = j + 2) {
                    character = string_original.charAt(j);
                    string_final.append(character);
                }
            }

            return string_final.toString();
        }

        int aux = step;
        for (int i = 0; i < string_original.length(); i++) {
            if (aux == 0) aux = step;            
            jump[i] = aux;
            aux = aux - 2;
        }

        char character;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < string_original.length(); j = j + jump[j]) {
                character = string_original.charAt(j);
                string_final.append(character);
            }
        }

        return string_final.toString();
    }
}
