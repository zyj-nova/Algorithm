import java.util.HashMap;

class Solution {
    public static int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 1) {
                nums[i] = 1;
            } else {
                nums[i] = 0;
            }
        }
        int sum = 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        numberOfSubarrays(new int[] { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 }, 2);
    }
}