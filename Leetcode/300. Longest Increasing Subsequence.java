import java.util.Arrays;

class Solution {
    public static int lengthOfLIS(int[] nums) {

        if (nums.length == 0 || nums == null)
            return 0;
        if (nums.length == 1)
            return 1;
        // 时间复杂度 O(n^2)
        // int dp[] = new int[nums.length];
        // int max = 1;
        // for (int i = 0; i < nums.length; i++)
        // dp[i] = 1;
        // for (int i = 1; i < nums.length; i++) {
        // for (int j = 0; j < i; j++) {
        // if (nums[j] < nums[i]) {
        // dp[i] = Math.max(dp[i], dp[j] + 1);
        // max = Math.max(dp[i], max);
        // }
        // }
        // }
        // return max;
        // 以下时间复杂度 O(nlogn) 贪心 + 二分查找
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            // 如果num比dp最后一个元素大，直接加到dp末尾，len++
            if (nums[i] > dp[len]) {
                dp[len + 1] = nums[i];
                len++;
            } else {
                // 否则，利用二分查找找到应该插入的位置
                boolean flag = false;
                int left = 0, right = len;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[i] == dp[mid]) {
                        flag = true;
                        break;
                    }
                    if (nums[i] < dp[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                if (!flag)
                    dp[left] = nums[i];
            }
            // System.out.println(Arrays.toString(dp));
        }
        return len + 1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
    }
}