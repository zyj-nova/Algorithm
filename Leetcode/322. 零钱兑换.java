class Solution {

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        if (amount == 0)
            return 0;
        int memo[] = new int[amount + 1];
        int ans = findWay(coins, amount, memo);
        return ans == 0 ? -1 : ans;
    }

    // 暴力递归会超时
    // 改进：记忆化搜索memo[n]表示n所需的最小硬币数目
    // 改进：动态规划
    public int findWay(int[] coins, int amount, int[] memo) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != 0) {
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int t = findWay(coins, amount - coins[i], memo);
            System.out.println(t);
            if (t >= 0)
                min = Math.min(t + 1, min);
        }
        memo[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[amount];
    }

    public static void main(String[] args) {
        Solution p = new Solution();
        int ans = p.coinChange(new int[] { 3 }, 6);
        System.out.println(ans);
    }
}