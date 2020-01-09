class Solution {
    // 对一个n * n矩阵原地顺时针旋转90度，
    // 在原矩阵上进行修改
    /*
     * [ [1,2,3], [4,5,6], [7,8,9] ], [ [7,4,1], [8,5,2], [9,6,3] ]
     * 一种方法：先转置矩阵，然后反转每一行
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length; // 行数
        // 矩阵的转置,考虑转置矩阵的特点 a_ij = b_ji
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 翻转每一行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }

    }
}