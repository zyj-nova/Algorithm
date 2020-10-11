class Solution {
    public boolean canPartition(int[] nums) {
        // 转为01背包问题；给定n件物品，背包容量为 sum / 2 能否选择一些物品，恰好装满背包
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if((sum & 1) == 1){//总和为奇数，一定不可以对半分
            return false;
        }
        int target = sum / 2; // 背包容量
        int dp[] = new int[target + 1];
        for(int i = 0; i < nums.length; i++){
            for(int  j = target; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}