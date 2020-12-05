class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        // dp[i][j] 表示前 i 个数，和为 j 的方案数
        // 状态转移方程：dp[i][j] = dp[i-1][j - nums[i]] + dp[i-1][j + nums[i]];

        int len = nums.length, sum = 0;
        for (int i = 0; i < len; i++){
            sum += nums[i];
        }
        if (sum < Math.abs(S)){
            return 0;
        }
        int t = 2 * sum + 1;
        int dp[][] = new int[len][t];
//        if (nums[0] == 0){
//            // 注意：这儿的dp[0][sum]表示只有一个数，和为0的情况，
//            // 当第一个数是0，+0 -0都可以，所以是2；
//            dp[0][sum] = 2;
//        }else{
//            dp[0][sum + nums[0]] = 1;
//            dp[0][sum - nums[0]] = 1;
//        }
        dp[0][sum + nums[0]] = 1;
        dp[0][sum - nums[0]] += 1;//nums[0] = 0的情况，dp[0][sum] = 2

        for (int i = 1; i < len; i++){
            for (int j = -sum; j <= sum; j++){
                if (j + nums[i] + sum >= t){
                    //数组索引不会为负数，加个偏移量sum
                    dp[i][j + sum] = dp[i - 1][j - nums[i] + sum];
                }else if (j - nums[i] + sum < 0){
                    dp[i][j + sum] = dp[i - 1][j + nums[i] + sum];
                }else
                    dp[i][j + sum] = dp[i - 1][j - nums[i] + sum] + dp[i - 1][j + nums[i] + sum];
            }
        }
        
        return dp[len - 1][sum + S];
    }
}