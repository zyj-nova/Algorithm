class Solution {
    /*
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * 
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * 
     * 请找出其中最小的元素。
     * 
     * 你可以假设数组中不存在重复元素。 .
     * 
     * 找到变化点：变化点之前的元素都大于数组第一个元素，变化点之后的元素都小于数组第一个元素
     * 
     * 结束条件：mid
     * 
     * 7 2
     */
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int left = 0, right = len - 1;
        if (nums[0] < nums[len - 1]) {
            return nums[0];
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid + 1] < nums[mid]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
