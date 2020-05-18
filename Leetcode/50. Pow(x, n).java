class Solution {
    public double myPow(double x, int n) {
        // 用分治的思想，计算x的64次
        // 64 -> 32 -> 16 -> 8 -> 4 -> 2 -> 1 只需要乘6次，而不是循环乘64次
        if (x == 0) {
            return 0;
        }
        return n > 0 ? help(x, n) : 1 / help(x, -n);
    }

    private double help(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = help(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}