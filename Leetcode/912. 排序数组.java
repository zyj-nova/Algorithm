class Solution {
    public int[] sortArray(int[] nums) {
        // 尝试堆排序
        heapSort(nums);
        return nums;
    }

    public void heapSort(int[] nums) {
        // 完全二叉树中，最后一个非叶子结点索引：len/2 - 1；
        // 从最后一个非叶子结点开始，shift up调整
        int len = nums.length;
        // 构建堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, len, i);
        }
        for (int i = len - 1; i >= 0; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            // 调整堆
            adjustHeap(nums, i, 0);
        }
    }

    public void adjustHeap(int[] nums, int len, int index) {
        int tmp = nums[index];
        // 从index结点的左子树结点（索引2*index+1）开始
        int left = 2 * index + 1;
        while (left < len) {
            int right = left + 1;
            if (right < len && nums[left] < nums[right]) {
                left++;
            }

            if (tmp >= nums[left]) {
                break;
            }

            nums[index] = nums[left];

            index = left;
            left = 2 * left + 1;
        }
        nums[index] = tmp;
    }

    public static void main(String[] args) {
        int nums[] = new int[] { 16, 7, 3, 20, 17, 3 };
        new Solution().sortArray(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}