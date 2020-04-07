class Solution {
    public static int surfaceArea(int[][] grid) {
        // 底面积也算表面积
        // 用总的面积减去重叠的面积，重叠的面积分为叠着的方体（上下）间的，还有四周的。
        //
        int ans = 0, total = 0, s = 0;
        int row = grid.length;
        int col = grid[0].length;
        int dir[][] = new int[][] { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int tmp = grid[i][j];
                if (tmp == 0) {
                    continue;
                }
                total += tmp * 6;

                s += 2 * (tmp - 1);// 上下重叠的
                for (int k = 0; k < 4; k++) {
                    int dx = i + dir[k][0];
                    int dy = j + dir[k][1];
                    if (dx >= 0 && dx < row && dy >= 0 && dy < col && grid[dx][dy] != 0) {
                        s += Math.min(grid[i][j], grid[dx][dy]);
                    }
                }
            }
        }
        ans = total - s;

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(surfaceArea(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }));
    }
}