import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return ans;
        }

        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 0 1 2 2 3 ... 从索引为2的元素开始，和索引为3的元素开始，都是2开头的序列，会有重复
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1])
                        L++; // 去重
                    while (L < R && nums[R] == nums[R - 1])
                        R--; // 去重
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }
}
