class Solution {
    public static int singleNumber(int[] nums) {
        int counts[] = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 31; j++) {
                counts[j] += nums[i] & 1;
                nums[i] = nums[i] >> 1;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            counts[i] %= 3; // 得到 只出现一次的数字 的第 (31 - i) 位

            res += counts[i] * (int) Math.pow(2, i);
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(1000000007);
    }
}