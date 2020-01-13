class Solution {
    public int searchInsert(int[] nums, int target) {
        // 解决target不存在数组中时，返回要插入的位置
        int left = 0, right = nums.length - 1;
        while (left <= right) {// 注意这儿的边界条件，当left = right 表示只有一个元素的区间仍然可以查找
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}