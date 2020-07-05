import java.util.*;

class Solution {
    // public static int kthSmallest(int[][] matrix, int k) {
    // // 矩阵中各行各列都是升序的
    // PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    // for (int i = 0; i < matrix.length; i++) {
    // for (int j = 0; j < matrix[0].length; j++) {
    // queue.add(matrix[i][j]);
    // }
    // }

    // while (k > 1) {
    // queue.poll();
    // k--;
    // }

    // return queue.peek();
    // }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

}