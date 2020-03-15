class Solution {
    public static String gcdOfStrings(String str1, String str2) {
        // 想的太复杂，超时!
        // int min_len = 0;
        // String str_short = "", str_long = "";
        // if (str1.length() <= str2.length()) {
        // min_len = str1.length();
        // str_short = str1;
        // str_long = str2;
        // } else {
        // min_len = str2.length();
        // str_short = str2;
        // str_long = str1;
        // }
        // String res = "";
        // for (int i = 0; i < min_len; i++) {
        // for (int j = i + 1; j <= min_len; j++) {
        // String tmp = str_short.substring(i, j);
        // String p = "";
        // int t1 = 0, t2 = 0;
        // for (int k = 1; k <= str_long.length() / tmp.length(); k++) {
        // p = p + tmp;
        // if (p.trim().equals(str_long)) {
        // t1 = k;
        // break;
        // }
        // }
        // p = "";
        // for (int k = 1; k <= str_short.length() / tmp.length(); k++) {
        // p = p + tmp;
        // if (p.trim().equals(str_short)) {
        // t2 = k;
        // break;
        // }
        // }
        // if (t1 != 0 && t2 != 0 && tmp.length() > res.length()) {
        // res = tmp;
        // }

        // }
        // }

        // return res;
        // 其实就是求最大公因子 -> 辗转相除法
        // str1 含有m个x str2有n个x，str1+str2 == str2+str1 m+n个x
        // 否则的话就没有公共因子。
        if (!(str1 + str2).trim().equals(str2 + str1))
            return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    // 求a b 的最大公因子
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {

        String ans = Solution.gcdOfStrings("AAAAAA", "AA");
        System.out.println(ans);
    }
}