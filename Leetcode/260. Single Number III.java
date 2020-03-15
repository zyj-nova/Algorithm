import java.util.HashMap;

class Solution {
    public int[] singleNumber(int[] nums) {
        // 哈希表 time:O(n) space:O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[2];
        int index = 0;
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        for (int k : map.keySet()) {
            if (map.get(k) == 1) {
                ans[index++] = k;
                if (index == 2)
                    break;
            }

        }
        return ans;
        // 按位异或运算 time:O(n) space:O(1)
        // ^ 相同为0 不同为1
        // 还没想明白.....

    }
}