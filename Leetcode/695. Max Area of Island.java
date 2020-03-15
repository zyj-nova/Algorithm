import jdk.internal.jshell.tool.resources.l10n;

class Solution {
    /**
     * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地)
     * 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
     * 
     * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
     * 
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/max-area-of-island
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param grid
     * @return
     */
    int dir[][] = new int[][] { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
    int m = 0, n = 0;
    int ans = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int row = grid.length;
        int col = grid[0].length;
        m = row;
        n = col;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    ans = 0;
                    dfs(grid, i, j);
                }
                max = Math.max(ans, max);
            }
        }
        return max;

    }

    private void dfs(int[][] grid, int x, int y) {
        grid[x][y] = 0;
        ans++;
        for (int i = 0; i < 4; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];
            if (in(dx, dy, m, n) && grid[dx][dy] == 1) {
                dfs(grid, dx, dy);
            }
        }

    }

    private boolean in(int x, int y, int row, int col) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }

    public static void main(String[] args) {
        int ans = new Solution().maxAreaOfIsland(new int[][] { { 1 } });
        System.out.println(ans);
    }
    /**
     * { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0,
     * 0, 0 }, { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0,
     * 1, 0, 1, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0,
     * 0, 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0,
     * 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }
     */
}