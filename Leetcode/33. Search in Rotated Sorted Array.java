class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {// 整个左边数组是升序的，按照普通二分继续查找
                if (nums[left] <= target && target < nums[mid]) {// target就在left - mid 之间
                    right = mid - 1;
                } else {
                    left = mid + 1;// target不在这半边
                }
            } else {// 由于旋转过，因此存在降序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}