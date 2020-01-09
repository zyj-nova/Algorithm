class Solution {
    /*
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     */

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int num = 1, i = len - 1;
        while (i >= 0) {
            num += digits[i];
            digits[i--] = num % 10;
            num /= 10;
        }
        if (num != 0) {
            int ans[] = new int[len + 1];
            ans[0] = num;
            for (int j = 1; j < ans.length; j++) {
                ans[j] = digits[j - 1];
            }
            return ans;
        }
        return digits;
    }
}