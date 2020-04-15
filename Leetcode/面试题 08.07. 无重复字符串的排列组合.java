import java.util.ArrayList;

class Solution {
    ArrayList<String> ans = new ArrayList<>();
    boolean visited[];

    public String[] permutation(String S) {
        // 输出s的排列组合
        visited = new boolean[S.length()];
        dfs("", S);
        String res[] = new String[ans.size()];
        int i = 0;
        for (String s : ans) {
            res[i++] = s;
        }
        System.out.println(ans);
        return res;
    }

    private void dfs(String tmp, String origin) {
        if (tmp.length() == origin.length()) {
            ans.add(tmp);
            return;
        }
        for (int i = 0; i < origin.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                char ch = origin.charAt(i);
                dfs(tmp + ch, origin);
                visited[i] = false;
            }
        }
    }
}