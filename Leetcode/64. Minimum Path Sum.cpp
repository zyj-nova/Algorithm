class Solution
{
  public
    int minPathSum(int[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length;
        int dp[][] = new int[row + 1][col + 1];
        for (int i = 0; i <= row; i++)
        {
            for (int j = 0; j <= col; j++)
                dp[i][j] = 0;
        }
        for (int i = 1; i <= row; i++)
        {
            for (int j = 1; j <= col; j++)
            {
                if (i == 1)
                {
                    dp[i][j] = dp[i][j - 1] + grid[i - 1][j - 1];
                }
                else if (j == 1)
                {
                    dp[i][j] = dp[i - 1][j] + grid[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i - 1][j - 1];
                }
            }
        }
        return dp[row][col];
    }
}