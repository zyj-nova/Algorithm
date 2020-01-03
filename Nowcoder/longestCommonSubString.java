//最长公共子串
public static int longestCommonSubString(String a, String b){
        int dp[][] = new int[105][105];
        char cha[] = a.toCharArray();
        char chb[] = b.toCharArray();
        int lena = cha.length, lenb = chb.length;
        int ans = 0;
        for (int i = 1; i <= lena; i++){
            for (int j = 1; j <= lenb; j++){
                if (cha[i-1] == chb[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if (dp[i][j] > ans){
                        ans = dp[i][j];
                    }
                }else
                    dp[i][j] = 0;
            }
        }
        return ans;
}