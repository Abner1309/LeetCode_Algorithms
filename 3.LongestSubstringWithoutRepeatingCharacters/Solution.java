/*
 * Given a string s, find the length of the longest without duplicate characters.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder string_original = new StringBuilder(s);
        StringBuilder string_intermediary = new StringBuilder();
        StringBuilder string_final = new StringBuilder();
        boolean permission = true;
        
        for (int i = 0; i < string_original.length(); i++) {
            char character = string_original.charAt(i);
            for (int j = 0; j < string_intermediary.length(); j++) {
                if (string_intermediary.charAt(j) == character) {
                    permission = false;
                    break;
                }
            }
            if (permission) {
                string_intermediary.append(character);
            }
            else {                
                if (string_intermediary.length() > string_final.length()) {
                    string_final.setLength(0);
                    string_final.append(string_intermediary.toString());
                }
                i = i - string_intermediary.length();
                string_intermediary.setLength(0);
                permission = true;                
            }
        }
        
        if (string_intermediary.length() > string_final.length()) {
            string_final.setLength(0);
            string_final.append(string_intermediary.toString());
        }

        return string_final.length();
    }
}
