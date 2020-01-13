class Solution {
    public  int[] searchRange(int[] nums, int target) {
        int first = -1, second = -1;
        first = lower_boud(nums,target);
        second = upper_boud(nums,target);
        int ans[] = new int[]{first,second};
        return ans;
    }
    private int lower_boud(int arr[], int target){
        //利用二分搜索查找target在数组中最左边位置
        int left = 0, right = arr.length - 1,res = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (target == arr[mid]){
                res = mid;
                //逼近左边界,继续向左
                right = mid - 1;
            }else if (target < arr[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }
        return res;
    }

    private int upper_boud(int arr[], int target){
        int left = 0, right = arr.length - 1,res = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (target == arr[mid]){
                res = mid;
                //逼近右边界,继续向右
                left = mid + 1;
            }else if (target < arr[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }
        return res;
    }
}