class Solution {
    // 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
    public static int convertInteger(int A, int B) {
        return Integer.bitCount(A ^ B);
    }

}