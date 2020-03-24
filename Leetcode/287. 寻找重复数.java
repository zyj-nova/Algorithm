import java.util.Arrays;

class Solution {
    public static int findDuplicate(int[] nums) {
        // 普通解法1 排序，然后看相邻元素是否是否相等
        // Arrays.sort(nums);
        // int ans = 0;
        // for (int i = 1; i < nums.length; i++) {
        // if (nums[i] == nums[i - 1]) {
        // ans = nums[i];
        // break;
        // }

        // }
        // return ans;
        // 普通解法2：hashmap统计次数或集合判重

        // 解法3
        // 双指针，类似于判断链表是否存在环
        // 数组中的值代表了索引，因为是1-n之间的数，数组包含n+1个数字，不会越界
        // nums[fast]->具体数值 以nums[fast]作为索引得到->nums[nums[fast]]
        // nums = [2,5,9,6,9,3,8,9,7,1] 构造成链表
        // 2->[9]->1->5->3->6->8->7->[9]->1->5->3...如果存在重复数字，有环存在，找到环的入口。
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            // System.out.println("fast=" + fast + ",slow=" + slow);
            if (fast == slow)
                break;
        }
        int finder = 0;
        while (true) {
            finder = nums[finder];
            slow = nums[slow];
            System.out.println("finder=" + finder + ",slow=" + slow);
            if (finder == slow)
                break;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] { 2, 5, 9, 6, 9, 3, 8, 9, 7, 1 }));
    }
}