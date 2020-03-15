import java.util.LinkedList;

class Solution {
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int dir[][] = new int[][] { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    // 广度搜索
    public int orangesRotting(int[][] grid) {
        boolean flag = false; // 是否有新鲜橘子
        boolean bad_flag = false; // 是否有坏橘子
        int ans = 0, x = 0, y = 0, total = 0;// 新鲜橘子数量
        LinkedList<Point> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    Point root = new Point(i, j);
                    q.offer(root);
                    bad_flag = true;

                } else if (grid[i][j] == 1) {
                    total++;
                }
            }
        }

        if (total > 0) {
            flag = true;
        }
        if (flag == false) {
            return 0;
        }
        if (bad_flag == false) {
            return -1;
        }
        while (!q.isEmpty() && total > 0) {
            int size = q.size();
            ans++;
            for (int j = 0; j < size; j++) {
                Point top = q.poll();
                for (int i = 0; i < 4; i++) {
                    int dx = top.x + dir[i][0];
                    int dy = top.y + dir[i][1];

                    if (in(dx, dy, grid.length, grid[0].length) && grid[dx][dy] == 1) {
                        total--;
                        q.offer(new Point(dx, dy));
                        grid[dx][dy] = 2;
                    }
                }
            }
            // System.out.println("剩余新鲜橘子：" + total);
        }

        return total == 0 ? ans : -1;
    }

    private boolean in(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    public static void main(String args[]) {
        // [[2,1,1],[1,1,0],[0,1,1]]
        int grid[][] = new int[][] { { 1, 0 } };
        int ans = new Solution().orangesRotting(grid);
        System.out.println("ans = " + ans);
    }
}