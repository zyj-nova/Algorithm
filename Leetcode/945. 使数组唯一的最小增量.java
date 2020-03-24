import java.util.Arrays;

class Solution {
    public static int minIncrementForUnique(int[] A) {

        // 2, 2, 2, 2, 0
        // sort: 0 2 2 2 2
        // i = 2 : 0 2 3 2 2; sort: 0 2 2 2 3 -> 0 2 3 2 3
        // 超时
        // Arrays.sort(A);
        // int count = 0;
        // for (int i = 1; i < A.length; i++) {
        // while (A[i] == A[i - 1]) {
        // A[i]++;
        // count++;
        // }
        // while (i < A.length - 1) {
        // if (A[i + 1] >= A[i]) {
        // break;
        // }
        // Arrays.sort(A);
        // while (A[i] == A[i - 1]) {
        // A[i]++;
        // count++;
        // }
        // }

        // }

        // return count;

        // 1 1 2 2 3 7

        int res = 0;
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                res += A[i - 1] + 1 - A[i];
                A[i] = A[i - 1] + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[] { 3, 2, 1, 2, 1, 7 }));
    }
}