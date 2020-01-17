class Solution {
    /*
     * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     */
    public int[] sortedSquares(int[] A) {
        int ans[] = new int[A.length];
        // A数组中，负数的平方和逆序，非负数的平方和升序，双指针合并为一个升序数组
        int i = 0, j = 0, len = A.length, index = 0;
        while (A[i] < 0) {
            i++;
        }
        j = i - 1;// j指向最后一个负数, i指向第一个非负数
        while (j >= 0 && i < len) {
            if (A[i] * A[i] >= A[j] * A[j]) {
                ans[index] = A[j] * A[j];
                j--;
            } else {
                ans[index] = A[i] * A[i];
                i++;
            }
            index++;
        }
        while (j >= 0) {
            ans[index++] = A[j]*A[j];j--;
        }
        while (i < len) {
            ans[index++] = A[i]*A[i];i++;
        }
        return ans;
    }
}