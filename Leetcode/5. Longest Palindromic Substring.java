class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.equals("")) {
            return s;
        }

        int len = s.length();
        char[] chars = s.toCharArray();

        boolean[][] dp = new boolean[len][len];
        // 1字母初始化
        for(int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // 2字母初始化 P(i,i+1)=(Si==Si+1)
        for(int i = 0; i < len - 1; i++) {
            dp[i][i+1] = (chars[i] == chars[i+1]);
        }

        int left = 0;
        int right = 0;
        int max = 1;
        for(int i = len - 2; i >= 0; i--) {
            for(int j = i + 1; j < len; j++) {
                // P(i,j)=(P(i+1,j−1) and Si==Sj)
                if(j != i+1) {
                    dp[i][j] = dp[i+1][j-1] && chars[i] == chars[j];
                }
                if(dp[i][j] && max < j - i + 1) {
                    max = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right+1);
    }
}