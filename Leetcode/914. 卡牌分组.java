import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static boolean hasGroupsSizeX(int[] deck) {
        int len = deck.length;
        if (len <= 1) {
            return false;
        }
        if (len == 2) {
            return deck[0] == deck[1];
        }
        // 暴力
        // ArrayList<Integer> arr = new ArrayList<>();
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int i = 2; i <= len / 2; i++) {
        // if (len % i == 0) {
        // arr.add(i);
        // }
        // }

        // for (int i = 0; i < len; i++) {
        // int cnt = map.getOrDefault(deck[i], 0);
        // map.put(deck[i], cnt + 1);
        // }
        // for (Integer t : arr) {
        // boolean flag = false;
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        // if (entry.getValue() % t == 0) {
        // continue;
        // } else {
        // flag = true;
        // break;
        // }
        // }
        // if (!flag) {
        // return true;
        // }
        // }

        // return false;

        // 统计各个数字出现次数，然后求不为1的公约数。
        int map[] = new int[10001];
        for (int n : deck) {
            map[n]++;
        }
        int ans = 0;
        for (int x : map) {
            ans = gcd(ans, x);
            if (ans == 1)
                return false;
        }

        return ans >= 2;
    }

    public static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public static void main(String[] args) {

        System.out.println(gcd(0, 2));
    }
}