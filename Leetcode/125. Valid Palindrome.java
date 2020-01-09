class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        char ch[] = s.toLowerCase().toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'a' && ch[i] <= 'z' || ch[i] >= '0' && ch[i] <= '9')
                str.append(ch[i]);
        }
        String tmp = str.toString();
        String reverse = str.reverse().toString();
        return reverse.contains(tmp);
    }
}