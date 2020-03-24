import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int longestPalindrome(String s) {

        // HashMap<Character, Integer> map = new HashMap<>();
        // for (int i = 0; i < s.length(); i++) {
        // int times = map.getOrDefault(s.charAt(i), 0);
        // map.put(s.charAt(i), times + 1);
        // }
        // int ans = 0;
        // int max_odd = 0;
        // for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        // if ((entry.getValue() & 1) == 0) {// 偶数
        // ans += entry.getValue();
        // }
        // if ((entry.getValue() & 1) == 1) {
        // max_odd = Math.max(entry.getValue(), max_odd);
        // ans += entry.getValue() - 1;
        // }

        // }
        // System.out.println(map);
        // if (max_odd != 0)
        // ans += 1;
        // return ans;

        // 自定义数组map
        int ans = 0;
        int map[] = new int[75];
        for (char ch : s.toCharArray()) {
            map[ch - '0']++;
        }
        int max_odd = 0;
        for (int t : map) {
            if ((t & 1) == 0) {
                ans += t;
            } else {
                max_odd = Math.max(max_odd, t);
                ans += t - 1;
            }
        }
        if (max_odd != 0) {
            ans += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}