import java.util.*;

class Solution {
    /**
     * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
     * 
     * 两个相邻元素间的距离为 1 。
     */
    int dir[][] = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = bfs(i, j, matrix);
                }
            }
        }

        return matrix;
    }

    public int bfs(int x, int y, int matrix[][]) {
        int cnt = 0;
        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[] { x, y });
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                int tmp[] = q.poll();
                for (int j = 0; j < 4; j++) {
                    int dx = tmp[0] + dir[j][0];
                    int dy = tmp[1] + dir[j][1];
                    if (dx >= 0 && dy >= 0 && dx < matrix.length && dy < matrix[0].length) {
                        if (matrix[dx][dy] == 0)
                            return cnt;
                        else {
                            q.offer(new int[] { dx, dy });
                        }
                    }
                }
            }
        }

        return cnt;
    }

}