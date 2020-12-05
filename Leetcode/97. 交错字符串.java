class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char ch1[] = s1.toCharArray();
        char ch2[] = s2.toCharArray();
        char ch3[] = s3.toCharArray();
        int len1 = ch1.length, len2 = ch2.length;
        if (len1 + len2 != ch3.length){
            return false;
        }
        boolean dp[][] = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        // 处理边界
        for (int i = 1; i <= len1; i++){
            dp[i][0] = ch1[i-1] == ch3[i-1] && dp[i-1][0];
        }
        for (int i = 1; i <= len2; i++){
            dp[0][i] = ch2[i-1] == ch3[i-1] && dp[0][i-1];
        }
        
        // dp[i][j] 表示 s1[0 - i-1] s2[0 - j-1] 是否可以交错构成 s3[0 : i + j - 1]
        for (int i = 1; i <= len1; i++){
            for (int j = 1; j <= len2; j++){
                dp[i][j] = dp[i-1][j] && ch1[i-1] == ch3[i+j-1] || dp[i][j-1] && ch2[j-1] == ch3[i+j-1];
            }
        }
        return dp[len1][len2];
    }
}