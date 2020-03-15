class Solution {
    public static boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }

        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Solution.isPowerOfTwo(256);
    }
}