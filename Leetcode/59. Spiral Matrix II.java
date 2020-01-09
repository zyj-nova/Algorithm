class Solution {
    public int[][] generateMatrix(int n) {
        int ans[][] = new int[n][n];// 初始化为0
        int cc, rr;
        int dr[] = { 0, 1, 0, -1 };
        int dc[] = { 1, 0, -1, 0 };
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < n * n; i++) {
            ans[r][c] = i;
            rr = r + dr[di];
            cc = c + dc[di];
            if (rr >= 0 && rr < n && cc >= 0 && cc < n && ans[rr][cc] != 0) {
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