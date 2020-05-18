class Solution {
    public boolean canJump(int[] nums) {
        // 如果能跳到某个位置，那么该位置左边的点都可以到达。
        int len = nums.length;
        int most = 0;
        for (int i = 0; i < len; i++) {
            if (i <= most) {
                most = Math.max(most, nums[i] + i);
                if (most >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}