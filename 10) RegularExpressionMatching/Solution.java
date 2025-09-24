public class Solution {
    public boolean isMatch(String s, String p) {
        int string_len = s.length();
        int pattern_len = p.length();
        
        boolean[][] regex = new boolean[string_len + 1][pattern_len + 1];
        regex[0][0] = true;

        for (int j = 1; j < pattern_len; j++) {
            if (p.charAt(j) == '*') {
                regex[0][j + 1] = regex[0][j - 1];
            }
        }

        for (int i = 0; i < string_len; i++) {
            for (int j = 0; j < pattern_len; j++) {
                char sc = s.charAt(i);
                char pc = p.charAt(j);

                if (pc == '.' || pc == sc) {
                    regex[i + 1][j + 1] = regex[i][j];
                } 
                else if (pc == '*') {
                    regex[i + 1][j + 1] = regex[i + 1][j - 1];

                    char prev = p.charAt(j - 1);
                    if (prev == '.' || prev == sc) {
                        regex[i + 1][j + 1] |= regex[i][j + 1];
                    }
                }
            }
        }

        return regex[string_len][pattern_len];
    }
}
