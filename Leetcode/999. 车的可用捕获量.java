class Solution {
    public int numRookCaptures(char[][] board) {

        int ans = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    // 向右
                    for (int k = j; k < 8; k++) {
                        if (board[i][k] == 'p') {
                            ans++;
                            break;
                        }
                        if (board[i][k] == 'B') {
                            break;
                        }
                    }
                    // 向左
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[i][k] == 'p') {
                            ans++;
                            break;
                        }
                        if (board[i][k] == 'B') {
                            break;
                        }
                    }
                    // 向上
                    for (int k = i; k >= 0; k--) {
                        if (board[k][j] == 'p') {
                            ans++;
                            break;
                        }
                        if (board[k][j] == 'B') {
                            break;
                        }
                    }
                    for (int k = i + 1; k < 8; k++) {
                        if (board[k][j] == 'p') {
                            ans++;
                            break;
                        }
                        if (board[k][j] == 'B') {
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
}