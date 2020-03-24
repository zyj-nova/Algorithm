class Solution {
    // 打家劫舍的翻版 DP
    // dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
    public static int massage(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 2 1 1 3
        int dp[] = new int[len];
        dp[0] = nums[0];
        // 注意dp[1]的取值，不是nums[1]，如果nums[1]>nums[0]就不预约第一个，所以取两者最大值
        // dp[i]代表的就是到i所达到的最大值，因此，不必设置max变量记录最大值。最后一个dp元素就是答案
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(massage(new int[] { 1, 3, 1 }));
    }
}