class Solution {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额
     * 
     * 由于每户都有偷和不偷两种选择，因此对于第i户， 动态转移方程 dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i])
     * 即抢第i户，和不抢第i户
     * 
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0)
            return 0;
        int dp[] = new int[length + 1];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                dp[0] = nums[0];
            } else if (i == 1) {
                dp[1] = Math.max(nums[0], nums[1]);
            } else
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[length - 1];
    }
}