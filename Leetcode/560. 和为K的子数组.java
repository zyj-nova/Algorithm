class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // sum - k 存在，则sum-k 到 sum这个区间里的和是 k，由于每次都加sum，因此一定是连续的
            // [:i]和为sum-k, [:j] sum（i < j） 表明从i+1开始到j和为k
            // 如果所有元素都大于0，那么sum每次出现的次数都是1，
            // 有0存在，sum可能经过几个元素值也不改变，但经过的元素也是子数组的一部分，
            // 因此要更新sum出现的次数 考虑 [1,0,0,1,0,0,1,0,0] k = 1
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}