import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countCharacters(String[] words, String chars) {
        // int ans = 0;
        // // 统计words中每个字符串的字符频率，只要chars包含字符的频率大于，就可以拼成
        // Map<Character, Integer> ch = new HashMap<>();
        // for (int j = 0; j < chars.length(); j++) {
        // int times = ch.getOrDefault(chars.charAt(j), 0);
        // ch.put(chars.charAt(j), times + 1);
        // }

        // for (int i = 0; i < words.length; i++) {
        // String tmp = words[i];
        // Map<Character, Integer> map = new HashMap<>();
        // for (int j = 0; j < tmp.length(); j++) {
        // int times = map.getOrDefault(tmp.charAt(j), 0);
        // map.put(tmp.charAt(j), times + 1);
        // }
        // boolean flag = true;
        // for (int j = 0; j < tmp.length(); j++) {
        // char c = tmp.charAt(j);
        // if (ch.getOrDefault(c, 0) < map.get(c)) {
        // flag = false;
        // break;
        // }
        // }
        // if (flag) {
        // ans += tmp.length();
        // }
        // }
        // return ans;

        // 利用数组，自定义map
        int ans = 0;
        int chars_map[] = new int[26];
        int words_map[] = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            chars_map[chars.charAt(i) - 97]++;
            words_map[chars.charAt(i) - 97]++;
        }
        for (int i = 0; i < words.length; i++) {
            String tmp = words[i];
            boolean flag = true;
            if (tmp.length() > chars.length()) {
                continue;
            } else {
                for (int j = 0; j < tmp.length(); j++) {
                    if (chars_map[tmp.charAt(j) - 97] > 0) {
                        chars_map[tmp.charAt(j) - 97]--;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans += tmp.length();
                }
                for (int j = 0; j < 26; j++) {
                    chars_map[j] = words_map[j];
                }
            }

        }
        return ans;
    }
}