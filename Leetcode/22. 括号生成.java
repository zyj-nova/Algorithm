import java.util.*;

class Solution {
    ArrayList<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        // dfs(new char[2*n],0);
        return ans;
    }

    // 优化的深搜算法
    private void dfs(int left, int right, String tmp) {
        // 结束条件
        if (left == 0 && right == 0) {
            ans.add(tmp);
        }
        if (left > 0) {
            // 添加左括号
            dfs(left - 1, right, tmp + "(");
        }
        if (right > left) {// 右括号数量大于左括号，如果右括号数量小于左括号说明有些右括号放在左括号前面了
            dfs(left, right - 1, tmp + ")");
        }

    }

    // 暴力
    private void dfs(char ch[], int pos) {
        if (pos == ch.length) {
            if (valid(ch)) {
                ans.add(String.valueOf(ch));
                return;
            }
        } else {
            ch[pos] = '(';// 添加左括号
            dfs(ch, pos + 1);
            ch[pos] = ')';// 生成右括号
            dfs(ch, pos + 1);
        }
    }

    // 判断生成的括号是否合法
    private boolean valid(char ch[]) {
        int count = 0;
        for (char c : ch) {
            if (c == '(') {
                count++;
            } else {// )
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}