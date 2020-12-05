
class Solution {
    static public int integerBreak(int n) {
        //int maxn = Integer.MIN_VALUE;
        /**
         * 先这么想：设 f(n) 表示 n 拆分成至少2个整数的和的最大乘积。
         * f(n) = max(1 * f(n - 1), 2 * f(n - 2), ... , (n-1) * f(1))
         * 可以看出这是递归，可以用自顶向下+记忆化解决，也可以自底向上通过递推解决
         * 
         */
        int dp[] = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                // 分为多个和 vs 直接分为两个和
                dp[i] = Math.max(Math.max(j * dp[i - j], j * (i - j)), dp[i]);
            }
        }

        return dp[n];
    }

}