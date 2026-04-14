public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int calcI = 0, calcJ = 0, repetitions = 0;
        char actual = 'x', mem = 'x';

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                actual = board[i][j];
                if (actual != '.') {
                    repetitions = 0; mem = 'x';
                    for (int k = 0; k < 9; k++) {
                        mem = board[i][k];
                        if (actual == mem) { repetitions++; }
                        if (repetitions > 1) { return false; }                        
                    }
                    repetitions = 0; mem = 'x';
                    for (int k = 0; k < 9; k++) {
                        mem = board[k][j];
                        if (actual == mem) { repetitions++; }
                        if (repetitions > 1) { return false; }                        
                    }
                    calcI = (i / 3) * 3;
                    calcJ = (j / 3) * 3;
                    repetitions = 0; mem = 'x';
                    for (int l = calcI; l < calcI + 3; l++) {
                        for (int m = calcJ; m < calcJ + 3; m++) {
                            mem = board[l][m];
                            if (actual == mem) { repetitions++; }
                            if (repetitions > 1) { return false; }                            
                        }
                    }
                }
            }
        }

        return true;
    }
}
