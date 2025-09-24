/*
 * Given a string s, return the longest palindromic substring in s.
*/

public class Solution {
    public boolean verifyPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        boolean palindrome = true;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                palindrome = false;
                break;
            }
            i++;
            j--;
        }

        return palindrome;
    }
    
    public String longestPalindrome(String s) {
        StringBuilder string_original = new StringBuilder(s);
        StringBuilder string_intermediary = new StringBuilder();
        StringBuilder string_final = new StringBuilder();
        
        for (int a = 0; a < string_original.length(); a++) {
            for (int b = a; b < string_original.length(); b++) {
                char character = string_original.charAt(b);
                string_intermediary.append(character);
                if (string_intermediary.length() > string_final.length() && 
                verifyPalindrome(string_intermediary.toString())) {
                    string_final.setLength(0);
                    string_final.append(string_intermediary.toString());
                }
            }
            string_intermediary.setLength(0);
        }        

        return string_final.toString();
    }
}