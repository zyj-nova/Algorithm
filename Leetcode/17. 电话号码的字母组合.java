import java.util.ArrayList;

class Solution {
    String map[] = new String[] { "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    ArrayList<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return ans;
        }
        int len = digits.length();// "23"
        dfs(len, "", 0, digits);
        return ans;
    }

    private void dfs(int n, String tmp, int pos, String digits) {
        if (pos > n) {
            return;
        }
        if (tmp.length() == n) {
            ans.add(tmp);
            return;
        }

        int index = digits.charAt(pos) - '0';
        String s = map[index - 1];
        for (char ch : s.toCharArray()) {
            dfs(n, tmp + ch, pos + 1, digits);
        }

    }
}