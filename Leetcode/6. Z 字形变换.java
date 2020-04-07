import java.util.*;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        // 找规律吧
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        // flag用来控制方向
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        String ans = "";
        for (int j = 0; j < numRows; j++) {
            ans += rows.get(j).toString();
        }
        return ans;
    }
}