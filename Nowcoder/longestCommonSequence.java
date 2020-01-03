public class Solution{
    //最长公共子序列
    public static int longestCommonSequence(String a, String b){
        char cha[] = a.toCharArray();
        char chb[] = b.toCharArray();
        int lena = cha.length;
        int lenb = chb.length;
        int dp[][] = new int[101][101];
        for (int i = 1; i <= lena; i++){
            for (int j = 1; j <= lenb; j++){
                if (cha[i-1] == chb[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[lena][lenb];
    }
}