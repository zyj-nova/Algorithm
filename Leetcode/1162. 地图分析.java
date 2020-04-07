import java.util.LinkedList;

class Solution {
    static int dir[][] = new int[][] { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    public static int maxDistance(int[][] grid) {
        int row = grid.length;
        // 多源bfs 将所有陆地入队，然后开始广搜
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                }
            }
        }
        int point[] = null;
        boolean flag = false;
        while (!queue.isEmpty()) {
            point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int dx = point[0] + dir[i][0];
                int dy = point[1] + dir[i][1];
                if (dx >= 0 && dx < row && dy >= 0 && dy < row && grid[dx][dy] == 0) {
                    queue.offer(new int[] { dx, dy });
                    flag = true;
                    grid[dx][dy] = grid[point[0]][point[1]] + 1;
                }
            }
        }
        if (point == null || !flag) {
            return -1;
        }
        return grid[point[0]][point[1]] - 1;
    }

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } }));
    }
}
