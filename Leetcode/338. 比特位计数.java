class Solution {
    // 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
    public static int[] countBits(int num) {
        int ans[] = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ans[i] = Integer.bitCount(i);
            System.out.println(ans[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        countBits(5);
    }
}