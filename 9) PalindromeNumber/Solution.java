/*
 * Given an integer x, return true if x is a palindrome, and false otherwise.
*/

public class Solution {
    public boolean isPalindrome(int x) {
        String auxiliary = String.valueOf(x);
        boolean answer = true;
        int len = auxiliary.length();

        int i = 0, j = len - 1;
        while (i <= j) {
            if (auxiliary.charAt(i) != auxiliary.charAt(j)) {
                answer = false;
                break;
            }
            i++;
            j--;
        }

        return answer;
    }
}