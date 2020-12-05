class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[]{-1,-1};
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                //找到目标元素后，还需要找到其起始位置和结束位置
                int l = mid, r = mid;
                while(l >= 1 && nums[l-1] == target){
                    l--;
                }
                res[0] = l ;
                while(r < nums.length - 1 && nums[r + 1] == target){
                    r++;
                }
                res[1] = r ;
                break;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }
}