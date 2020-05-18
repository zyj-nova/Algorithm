import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 暴力
        // ArrayList<List<String>> ans = new ArrayList<>();
        // boolean vis[] = new boolean[strs.length];
        // for (int i = 0; i < strs.length; i++) {
        // if (vis[i]) {
        // continue;
        // }
        // ArrayList<String> tmp = new ArrayList<>();
        // tmp.add(strs[i]);
        // for (int j = i + 1; j < strs.length; j++) {
        // if (judge(strs[i], strs[j]) && !vis[j]) {
        // tmp.add(strs[j]);
        // vis[j] = true;
        // }
        // }
        // ans.add(tmp);
        // }
        // return ans;
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }

    private boolean judge(String s1, String s2) {
        int ch1[] = new int[26];
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            ch1[s1.charAt(i) - 'a']++;
            ch1[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (ch1[i] != 0) {
                return false;
            }
        }
        return true;
    }
}