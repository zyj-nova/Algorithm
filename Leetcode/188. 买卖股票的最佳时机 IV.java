class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        if (k > len / 2) {
            // 无限次交易 贪心
            int ans = 0;
            for (int i = 1; i < len; i++) {
                int tmp = prices[i] - prices[i - 1];
                if (tmp > 0) {
                    ans += tmp;
                }
            }
            return ans;
        }
        int dp[][][] = new int[len][k + 1][2];
        // dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
        // dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] + prices[i]);
        for (int i = 0; i < len; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);// sell
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);// buy
            }
        }
        return dp[len - 1][k][0];
    }
}