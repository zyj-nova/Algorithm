import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // 第一种方法：O(nlogn)
        // Arrays.sort(nums);
        // for(int i = 0; i < nums.length - 1; i++){
        // if(nums[i] == nums[i+1])
        // return true;
        // }
        // return false;
        // 第二种，哈希表
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}