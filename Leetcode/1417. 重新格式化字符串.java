class Solution {
    public String reformat(String s) {
        char nums[] = new char[500];
        char alpha[] = new char[500];
        int p = 0;
        int q = 0;
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                nums[p++] = ch;
            } else if (ch >= 'a' && ch <= 'z') {
                alpha[q++] = ch;
            }
        }
        if (nums.length == 0 || alpha.length == 0 || Math.abs(p - q) > 1) {
            return "";
        }
        int i, j;
        StringBuilder res = new StringBuilder();
        for (i = 0, j = 0; i < p && j < q; i++, j++) {
            if (p >= q) {// 数字比字母多
                res.append(nums[i]);
                res.append(alpha[j]);
            } else {
                res.append(alpha[i]);
                res.append(nums[j]);
            }
        }
        if (i < p) {
            res.append(nums[i]);
        }
        if (j < q) {
            res.append(alpha[j]);
        }

        return res.toString();
    }
}