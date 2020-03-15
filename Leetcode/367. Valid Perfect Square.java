class Solution {
    /**
     * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
     * 
     * 说明：不要使用任何内置的库函数，如  sqrt。
     * 
     * 
     */
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        int left = 2, right = num / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long tmp = (long) mid * mid;
            if (tmp == num) {
                return true;
            }
            if (tmp > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}