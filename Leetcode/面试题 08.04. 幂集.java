import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // 编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
        int len = nums.length;
        dfs(0, len, new ArrayList<Integer>(), nums);

        return ans;
    }

    private void dfs(int pos, int n, ArrayList<Integer> tmp, int nums[]) {

        ans.add((ArrayList<Integer>) tmp.clone());
        for (int i = pos; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfs(i + 1, n, tmp, nums);
            tmp.remove(tmp.size() - 1);

        }
    }
}