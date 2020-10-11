class Solution {
      // 代表每列1-9数字
    boolean col[][] = new boolean[10][10];
    // 代表每块1-9数字
    boolean square[][] = new boolean[10][10];
    // 代表每行1-9数字
    boolean row[][] = new boolean[10][10];
    // 所有待填入数字
    int nums[][] = new int[81][2];
    int total ;


    boolean ok = false;
    public void solveSudoku(char[][] board) {

        int cnt = 0;
        for (int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    int t = board[i][j] - '0';
                    row[i][t] = true;
                    col[j][t] = true;
                    square[(i / 3) * 3 + j / 3 ][t] = true;
                }else {
                    nums[cnt][0] = i;
                    nums[cnt++][1] = j;
                }
            }
        }
        total = cnt;
        dfs(0,board);
    }

    private void dfs(int cnt, char [][] maze){
        if (cnt == total){
            ok = true;
            return;
        }

        int point[] = nums[cnt];
        int x = point[0];
        int y = point[1];
        int t = (x / 3) * 3 + y / 3;
        // 待填入的空选择1-9中的数字
        for (int i = 1; i <= 9; i++){
            if (!row[x][i] && !col[y][i] && !square[t][i]){
                row[x][i] = true;
                col[y][i] = true;
                square[t][i] = true;
                maze[x][y] = String.valueOf(i).charAt(0);
                dfs(cnt + 1,maze);
                if (ok)
                    return;
                maze[x][y] = '.';
                row[x][i] = false;
                col[y][i] = false;
                square[t][i] = false;
            }
        }
    }
}