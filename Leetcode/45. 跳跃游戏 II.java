class Solution {
    // 2 3 1 1 4
    public int jump(int[] nums) {
        int len = nums.length;
        int steps = 0;
        int maxPos = 0;
        int end = 0;
        for (int i = 0; i < len - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                steps++;
                end = maxPos;
            }
        }
        return steps;
    }
}