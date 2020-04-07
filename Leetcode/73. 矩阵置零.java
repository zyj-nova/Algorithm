class Solution {
    boolean r[] = null;
    boolean c[] = null;

    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 0) {
            return;
        }
        // 用于标记是否已经置0的行或列
        r = new boolean[row];
        c = new boolean[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    if (r[i] || c[j]) {
                        continue;
                    }
                    System.out.println(i + "," + j);
                    dfs(i, j, matrix);
                }
            }
        }
    }

    private void dfs(int x, int y, int map[][]) {
        if (!r[x]) {
            r[x] = true;
            for (int i = 0; i < map[0].length; i++) {
                if (map[x][i] == 0) {
                    dfs(x, i, map);
                } else {
                    map[x][i] = 0;
                }

            }
        }
        if (!c[y]) {
            c[y] = true;
            for (int j = 0; j < map.length; j++) {
                if (map[j][y] == 0) {
                    dfs(j, y, map);
                } else {
                    map[j][y] = 0;
                }

            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        new Solution().setZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
