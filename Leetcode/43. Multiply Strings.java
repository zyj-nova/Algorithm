class Solution {
    // 大数相乘
    public String multiply(String num1, String num2) {
        char ch1[] = num1.toCharArray();
        char ch2[] = num2.toCharArray();
        int res[] = new int[100005];
        int digit = 0;
        for (int i = ch1.length - 1; i >= 0; i--) {
            digit = ch1.length - i - 1;
            for (int j = ch2.length - 1; j >= 0; j--) {
                res[digit++] += (ch1[i] - '0') * (ch2[j] - '0');
            }
        }
        StringBuilder ans = new StringBuilder();
        int tmp = 0;// 处理进位
        for (int k = 0; k < digit; k++) {
            ans.append((res[k] + tmp) % 10);
            tmp = (res[k] + tmp) / 10;
        }
        if (tmp != 0)
            ans.append(tmp);
        String s = ans.reverse().toString();
        if (s.indexOf("0") == 0)
            return "0";
        return s;
    }
}