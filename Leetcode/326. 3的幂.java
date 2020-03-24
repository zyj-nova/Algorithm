class Solution {
    public static boolean isPowerOfThree(int n) {
        // if (n == 0)
        // return false;
        // // n是3的幂 => log_3(n) 是整数
        // // 对数换底公式 log_3(n) = lg(n)/lg(3)
        // double res = Math.log10(n) / Math.log10(3.0);
        // return res - (int) res == 0 ? true : false;
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
    }
}