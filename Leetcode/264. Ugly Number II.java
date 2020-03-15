import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个程序，找出第 n 个丑数。
 * 
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 */
class Solution {
    static List<Integer> ans = new ArrayList<>(1691);

    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        // 暴力肯定是不行滴
        // int index = 0;
        // List<Integer> ans = new ArrayList<>(n);
        // for (int i = 1;; i++) {
        // if (isUgly(i)) {
        // index++;
        // ans.add(i);
        // if (index == n)
        // break;
        // }
        // }
        // return ans.get(n);
        int nums[] = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            nums[i] = Math.min(2 * nums[index2], Math.min(3 * nums[index3], 5 * nums[index5]));
            if (nums[i] == dp[index2] * 2)
                index2++;
            if (nums[i] == dp[index3] * 3)
                index3++;
            if (nums[i] == dp[index5] * 5)
                index5++;
        }
        return nums[n - 1];

    }

    // public boolean isUgly(int num) {
    // if (num == 1)
    // return true;
    // while (num != 0) {
    // int tmp = num;
    // if (num % 2 == 0) {
    // num /= 2;
    // }
    // if (num % 3 == 0) {
    // num /= 3;
    // }
    // if (num % 5 == 0) {
    // num /= 5;
    // }
    // if (num == tmp)
    // return false;
    // if (num == 1)
    // return true;
    // }
    // return false;
    // }
}