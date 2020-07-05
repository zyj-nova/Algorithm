import java.util.HashMap;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        /// 找出数组中两个数求和为target的两个数，返回其索引
        int ans[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // map中存的是各个索引对应的数组元素要加成target所需要的另一半的数，
            // 每次遍历，先看map中是否存在这个另一半，存在则直接返回，不存在，就存下来
            int another = target - nums[i];
            if (map.containsKey(another)) {
                ans[0] = map.get(another);
                ans[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans[] = twoSum(new int[] { 2, 7, 11, 15 }, 13);
        System.out.println(ans[0] + "," + ans[1]);
    }
}