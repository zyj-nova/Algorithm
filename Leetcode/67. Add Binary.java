class Solution {
    /*
     * 给定两个二进制字符串，返回他们的和（用二进制表示）。
     * 
     * 输入为非空字符串且只包含数字 1 和 0。
     */
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        char cha[] = a.toCharArray();
        char chb[] = b.toCharArray();
        int lena = cha.length;
        int lenb = chb.length;
        int i = lena - 1, j = lenb - 1;
        int tmp = 0;
        while (i >= 0 && j >= 0) {
            tmp += cha[i--] - '0' + chb[j--] - '0';
            res.append(tmp % 2);
            tmp /= 2;
        }
        if (i >= 0) {
            while (i >= 0) {
                tmp += cha[i--] - '0';
                res.append(tmp % 2);
                tmp /= 2;
            }
        } else if (j >= 0) {
            while (j >= 0) {
                tmp += chb[j--] - '0';
                res.append(tmp % 2);
                tmp /= 2;
            }
        }
        if (tmp > 0) {
            res.append(tmp);
        }
        return res.reverse().toString();
    }
}