class Solution {
    // 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
    public boolean isAnagram(String s, String t) {
        // if (s.length() != t.length())
        // return false;
        // for (int i = 0; i < s.length(); i++) {
        // if (!t.contains("" + s.charAt(i))) {
        // continue;
        // } else {
        // return false;
        // }
        // }
        // return true;
        // aaac ccca 不行
        // 哈希表,如果两个单词各个字母出现的频率完全一致，即为字母异位词，那么最后数组中都是0。
        if (s.length() != t.length())
            return false;
        int table[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
            table[s.charAt(i) - 'a']--;
        }
        for (int t = 0; t < table.length; t++) {
            if (table[t] != 0)
                return false;
        }
        return true;

    }
}