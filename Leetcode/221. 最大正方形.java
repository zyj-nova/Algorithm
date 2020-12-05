class Solution {
    public int maximalSquare(char[][] matrix) {
        // dp[i][j]表示以i,j为右下角的含1的最大正方形的面积
        int row = matrix.length;
        if(row == 0){
            return 0;
        }
        int col = matrix[0].length;
        
        int dp[][] = new int[row + 1][col + 1];
        int maxn = Integer.MIN_VALUE;
        
        for(int i = 1; i <= row; i ++){
            for (int j = 1; j <= col; j ++){
                if(matrix[i-1][j-1] == '1')
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                
                maxn = Math.max(dp[i][j], maxn);
            }
        }
        // 注意要求返回最大面积，dp表示的是边长
        return maxn * maxn;
    }
}