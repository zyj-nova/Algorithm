class Solution {
    int dir[][] = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 } };

    // 由于细胞的生和死是同时发生的，因此在原board上做修改会影响到后面的状态
    // board中细胞的变化必须按照初始board状态来进行变化。
    public void gameOfLife(int[][] board) {
        // 原地算法
        int row = board.length;
        int col = board[0].length;
        if (row == 0) {
            return;
        }
        int copy[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                copy[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (copy[i][j] == 1) {
                    // 活细胞
                    int count = 0;
                    for (int k = 0; k < 8; k++) {
                        int dx = i + dir[k][0];
                        int dy = j + dir[k][1];
                        if (dx >= 0 && dy >= 0 && dx < row && dy < col) {
                            if (copy[dx][dy] == 1) {
                                count++;
                            }
                        }
                    }
                    if (count < 2 || count > 3) {
                        board[i][j] = 0;
                    }

                } else {// 死细胞，看周围有没有3个活细胞
                    int live = 0;
                    for (int k = 0; k < 8; k++) {
                        int dx = i + dir[k][0];
                        int dy = j + dir[k][1];
                        if (dx >= 0 && dy >= 0 && dx < row && dy < col) {
                            if (copy[dx][dy] == 1) {
                                live++;
                            }
                        }
                    }
                    if (live == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}