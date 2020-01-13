class Solution {
    // 给定一个数，求该数的阶乘末尾有多少个0
    public int trailingZeroes(int n) {
        // 一般解法：大数阶乘,求出后计算多少个0,超时了.....
        // int ans[] = new int[100005];
        // int digit = 1;
        // int num = 0;
        // ans[0] = 1;
        // for (int i = 2; i <= n; i++) {
        // for (int j = 0; j < digit; j++) {
        // int tmp = ans[j] * i + num;
        // ans[j] = tmp % 10;
        // num = tmp / 10;
        // }
        // while (num != 0) {
        // ans[digit++] = num % 10;
        // num /= 10;
        // }
        // }
        // int res = 0;
        // for (int i = 0; i < digit; i++) {
        // if (ans[i] == 0)
        // res++;
        // else {
        // break;
        // }
        // }

        // return res;
        // 第二种：计算 n! 的所有乘子里面有多少个5. 因为2的出现次数比5多。超时了....
        // int ans = 0;
        // for(int i = n; i <= n; i++){
        // int N = i;
        // while(N > 0){
        // if(N % 5 == 0)
        // ans++;
        // else
        // break;
        // N /= 5;
        // }
        // }
        // return ans;
        // 第三种：第二种的改进
        int ans = 0;
        while (n > 0) {
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }
}