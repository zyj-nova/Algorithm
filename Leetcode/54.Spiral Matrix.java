import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return ans;
        int dr[] = { 0, 1, 0, -1 };// 行方向上的移动
        int dc[] = { 1, 0, -1, 0 };// 列方向上的移动
        int r = 0, c = 0, di = 0;
        int R = matrix.length;// 矩阵的行数
        int C = matrix[0].length;// 矩阵的列数
        int rr = 0, cc = 0;
        boolean seen[][] = new boolean[R][C];
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            rr = r + dr[di];
            cc = c + dc[di];
            if (rr >= 0 && rr < R && cc >= 0 && cc < C && !seen[rr][cc]) {
                r = rr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }
}