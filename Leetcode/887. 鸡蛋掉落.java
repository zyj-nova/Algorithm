class Solution {
    public int superEggDrop(int K, int N) {
        // K个蛋 N楼
        // 动态规划，填表
        // 每一列代表鸡蛋数量，每一行代表楼层数目
        int dp[][] = new int[N + 1][K + 1];
        // 只有1层楼，无论有多少鸡蛋，也只要1次
        for (int i = 1; i <= K; i++) {
            dp[1][i] = 1;
        }
        // 只有1个鸡蛋，有多少层楼最差情况最少扔多少次
        for (int j = 1; j <= N; j++) {
            dp[j][1] = j;
        }
        // 三重循环会超时，时间复杂度O(N^2K)
        // 第三重循环改为二分查找 -> O(NKlogN)
        // for (int n = 2; n <= N; n++) {
        // for (int k = 2; k <= K; k++) {
        // int min = Integer.MAX_VALUE;
        // for (int x = 1; x <= n; x++) {
        // // k层楼扔下，如果碎了，去(1, x-1),如果没碎,去(x,N)
        // min = Math.min(Math.max(dp[n - x][k], dp[x - 1][k - 1]), min);
        // }
        // dp[n][k] = min + 1;
        // }
        // }
        for (int n = 2; n <= N; n++) {
            for (int k = 2; k <= K; k++) {

                int left = 1;
                int right = n;
                while (left < right) {
                    int mid = left + (right - left + 1) / 2;
                    int breakCount = dp[mid - 1][k - 1];
                    int notBreakCount = dp[n - mid][k];
                    if (breakCount > notBreakCount) {
                        // 排除法（减治思想）写对二分见第 35 题，先想什么时候不是解
                        // 严格大于的时候一定不是解，此时 mid 一定不是解
                        // 下一轮搜索区间是 [left, mid - 1]
                        right = mid - 1;
                    } else {
                        // 这个区间一定是上一个区间的反面，即 [mid, right]
                        // 注意这个时候取中间数要上取整，int mid = left + (right - left + 1) / 2;
                        left = mid;
                    }

                }
                dp[n][k] = Math.max(dp[left - 1][k - 1], dp[n - left][k]) + 1;
            }
        }

        return dp[N][K];
    }
}