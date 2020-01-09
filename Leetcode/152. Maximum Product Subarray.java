class Solution {
    public int maxProduct(int[] nums) {
        // 不像最大连续子数组的和，积有可能由正数*正数，负数*负数得到
        // 所以，正的可以变为负的，负的也可以成为正的
        // 要有两个变量，保存当前的最大值和最小值
        int ans = Integer.MIN_VALUE, max = 1, min = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                // 负数，交换最大和最小值
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            ans = Math.max(max, ans);
        }
        return ans;
    }
}