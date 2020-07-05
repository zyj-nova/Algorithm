class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int len = nums.length;
        int sum = 0;
        int start = 0, end = 0;
        while (end < len) {
            sum += nums[end];
            while (sum >= s) {
                sum -= nums[start];
                ans = Math.min(ans, end - start + 1);
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}