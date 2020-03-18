class Solution {
    public static String compressString(String S) {
        if (S.length() <= 1) {
            return S;
        }
        StringBuilder s = new StringBuilder();
        char tmp[] = S.toCharArray();
        int count = 0;
        char ch = tmp[0];
        for (int i = 1; i < tmp.length; i++) {
            if (tmp[i] == ch) {
                count++;
            } else {
                s.append(ch + "" + count);
                count = 1;
                ch = tmp[i];
            }
        }
        return s.length() >= S.length() ? S : s.toString();
    }
}