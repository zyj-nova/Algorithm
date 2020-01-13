import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * 
     * candidates 中的每个数字在每个组合中只能使用一次。
     * 
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean vis[] = new boolean[candidates.length];
        Arrays.sort(candidates);
        dfs(candidates, 0, new ArrayList<>(), target, ans, vis);
        Set<List<Integer>> set = new HashSet<>();
        // 迫不得已，使用集合去了个重
        for (List<Integer> i : ans) {
            set.add(i);
        }
        ans.clear();
        for (List<Integer> j : set) {
            ans.add(j);
        }
        return ans;
    }

    private void dfs(int nums[], int i, List<Integer> tmp, int target, List<List<Integer>> res, boolean[] vis) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int start = i; i < nums.length; i++) {
            if (target < nums[start])
                continue;
            if (!vis[start]) {
                vis[start] = true;
                tmp.add(nums[start]);
                dfs(nums, start + 1, tmp, target - nums[start], res, vis);
                tmp.remove(tmp.size() - 1);
                vis[start] = false;
            }
        }
    }
}