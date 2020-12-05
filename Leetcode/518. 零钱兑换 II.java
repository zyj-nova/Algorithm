class Solution {
    public int change(int amount, int[] coins) {
        // 即使每个硬币可以无限使用，但是amount是有限的，对于coins[i],最多也就使用 round(amount/coins[i])
        int n = coins.length;
        int dp[][] = new int[n + 1][amount + 1];
        
        for(int i = 0; i <= n; i++){
            //初始化, 面额为0时只有一种方案
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                if(j - coins[i - 1] >= 0)
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                else//j < coins[i-1] 当前硬币面额大于凑得数量，不可用。
                    dp[i][j] = dp[i-1][j];
            }
        }


        return dp[n][amount];
    }
}