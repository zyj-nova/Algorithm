class Solution {
    private List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<List<Integer>>();
        boolean vis[] = new boolean[nums.length];
        // 注意先排序
        Arrays.sort(nums);
        dfs(nums, vis, 0, new ArrayList<Integer>());
        return ans;
    }

    private void dfs(int nums[], boolean vis[], int n, ArrayList<Integer> tmp) {
        if (n == nums.length) {
            ans.add((ArrayList<Integer>) tmp.clone());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                // 剪枝 当前元素和前一个元素相同并且前一个元素还没用过，就不去搜索。
                if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])
                    continue;
                vis[i] = true;
                tmp.add(nums[i]);
                dfs(nums, vis, n + 1, tmp);
                vis[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
    	
    	System.out.println(new Solution().permute(new int[] {3,3,0，3}));
    }

}