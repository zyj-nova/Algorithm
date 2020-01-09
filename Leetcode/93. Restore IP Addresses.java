import java.util.ArrayList;

class Solution {
    public static List<String> restoreIpAddresses(String s) {
        // 1.暴力解法
        // ArrayList<String> ans = new ArrayList<>();
        // for (int a = 1; a < 4; a++) {
        // for (int b = 1; b < 4; b++) {
        // for (int c = 1; c < 4; c++) {
        // for (int d = 1; d < 4; d++) {
        // if (a + b + c + d == s.length()) {
        // int A = Integer.parseInt(s.substring(0, a));
        // int B = Integer.parseInt(s.substring(a, a + b));
        // int C = Integer.parseInt(s.substring(a + b, a + b + c));
        // int D = Integer.parseInt(s.substring(a + b + c));
        // if (A <= 255 && B <= 255 && C <= 255 && D <= 255) {
        // String tmp = A + "." + B + "." + C + "." + D;
        // if (tmp.length() == s.length() + 3)
        // ans.add(tmp);
        // }
        // }
        // }
        // }
        // }
        // }
        // return ans;

        // 2.回溯深搜解法

    }
}