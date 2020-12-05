class Solution {
    public int countPrimes(int n) {
        if (n <= 1){
            return 0;
        }
        // 素数的埃氏筛
        int cnt = 0, k = (int) Math.sqrt(n);
        boolean flag[] = new boolean[n];
        for (int i = 2; i <= k; i++){//注意 i 的最大值
            if (!flag[i]){
                for (int j = i * i; j < n; j += i){
                    flag[j] = true;
                }
            }
        }
        for (int i = 2; i < n; i++){// 注意 i 的最大值
            if (!flag[i]){
                cnt++;
            }
        }
        return cnt;
    }
}