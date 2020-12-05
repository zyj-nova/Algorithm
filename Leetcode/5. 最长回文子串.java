class Solution {
    public String longestPalindrome(String s) {
        char ch[] = s.toCharArray();
        int begin = 0, maxLen = 1, len = ch.length;
        boolean dp[][] = new boolean[len + 1][len + 1];
        for(int i = 0; i < len; i++){
            // 单个字母肯定是回文串
            dp[i][i] = true;
        }
        //dp[i][j] 表示s[i:j]是否为一个回文串 i <= j
        for(int j = 1; j < len; j++){//外层循环j
            for(int i = 0; i < j; i++){//内层循环i , 保证i <= j
                if(ch[i] != ch[j]){
                    dp[i][j] = false;
                }else{
                    if(j - i < 3){
                        //若长度为2，且两个字母相等，是回文串
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }

            }
        }
        return s.substring(begin, begin + maxLen );
    }
}