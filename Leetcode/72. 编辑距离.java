class Solution {
    /**
     * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
     * 
     * 你可以对一个单词进行如下三种操作：
     * 
     * 插入一个字符 删除一个字符 替换一个字符
     * 
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/edit-distance
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        /**
         * 记住那个矩阵，记住矩阵怎们算就知道代码怎么写。
         * 
         * 注意：
         * 
         * 插入：dp[i][j-1] + 1,即考虑先将 word1[0,i]->word2[0,j-1]所需的cost,再插入word2[j] cost + 1
         * 
         * 删除：dp[i-1][j]+1 删掉word1的第i个字符, 操作为1 再考虑 word1[0,i-1] -> word2[0,j]的cost
         * 
         * 替换:dp[i-1][j-1]+1
         */
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1));
                // 第四种情况
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}