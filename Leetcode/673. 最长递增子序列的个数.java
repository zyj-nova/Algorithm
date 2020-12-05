class Solution {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int dp[] = new int[len + 1];
        //需要利用一个counter数组记录每个数字的最长递增序列的组合数是多少
        int counter[] = new int[len + 1];
         int maxn = -1, res = 0;
        for(int i = 0; i < len; i++){
            dp[i] = 1;
            counter[i] = 1;//自身为一个序列，只有一种组合数
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if (dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        counter[i] = counter[j];
                    }else if (dp[j] + 1 == dp[i]){
                        counter[i] += counter[j];
                    }
                }
            }
            maxn = Math.max(dp[i], maxn);
        }
        for (int i = 0; i < len; i++){
            if (dp[i] == maxn){
                res += counter[i];
            }
        }
        return res;
    }
}