import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * 
     * candidates 中的数字可以无限制重复被选取
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(candidates, 0, new ArrayList<>(), target, ans);
        return ans;
    }

    private void dfs(int nums[], int i, List<Integer> tmp, int target, List<List<Integer>> res) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int start = i; start < nums.length; start++) {
            if (target < nums[start])
                continue;
            tmp.add(nums[start]);
            dfs(nums, start, tmp, target - nums[start], res);
            // 回溯
            tmp.remove(tmp.size() - 1);
        }

    }
}