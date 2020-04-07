class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int dp[][][] = new int[len][3][2];
        // dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
        // dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] + prices[i]);
        for (int i = 0; i < len; i++) {
            for (int k = 2; k >= 1; k--) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);// sell
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);// buy
            }
        }
        return dp[len - 1][2][0];
    }
}