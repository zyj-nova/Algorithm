class Solution {
    public static int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        String s = String.valueOf(num);
        int len = s.length();
        int dp[] = new int[len];
        dp[0] = 1;

        dp[1] = s.substring(0, 2).compareTo("25") <= 0 ? 2 : 1;
        for (int i = 2; i < len; i++) {
            dp[i] = dp[i - 1];
            String p = s.substring(i - 1, i + 1);
            if (p.compareTo("10") >= 0 && p.compareTo("25") <= 0) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len - 1];

    }

    public static void main(String[] args) {
        System.out.println(translateNum(1));
    }
}