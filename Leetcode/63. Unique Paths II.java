class Solution {
    /*
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * 
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     * 
     * dfs会超时
     * 
     * 动态规划
     */
    // private int dir[][] = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
    // };
    // private int ans = 0;

    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    // boolean vis[][] = new boolean[obstacleGrid.length][obstacleGrid[0].length];
    // dfs(0, 0, vis, obstacleGrid);
    // return ans;
    // }

    // private void dfs(int x, int y, boolean vis[][], int[][] map) {
    // if (x == map.length - 1 && y == map[0].length - 1 && map[x][y]!=1) {
    // ans++;
    // return;
    // }
    // for (int i = 0; i < dir.length; i++) {
    // int dx = x + dir[i][0];
    // int dy = y + dir[i][1];
    // if (dx >= 0 && dx < map.length && dy >= 0 && dy < map[0].length &&
    // !vis[dx][dy] && map[dx][dy] != 1) {
    // vis[dx][dy] = true;
    // dfs(dx, dy, vis, map);
    // vis[dx][dy] = false;// 回溯
    // }
    // }

    // }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0 && obstacleGrid[i][j] != 1) {
                    dp[0][0] = 1;
                    continue;
                }
                if (i == 0 && obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0 && obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
