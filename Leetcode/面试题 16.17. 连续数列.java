class Solution {
    public int maxSubArray(int[] nums) {
        // 对于数组的每个元素，都可以选择加或者不加，如果加了比自己大那就加，否则就不加
        // 同时注意必须是连续的序列（子段）
        int sum = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
            sum = Math.max(nums[i], sum);
        }
        return sum;
    }
}