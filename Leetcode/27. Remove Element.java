public static int removeElement(int[] nums, int val) {
        int j = 0,len = 0;
        int index = nextELe(nums,0,val);
        while (index < nums.length){
            nums[j++] = nums[index];
            len++;
            index = nextELe(nums,index+1,val);
        }
        return len;
}
private static int nextELe(int []nums, int index, int val){
    for (; index < nums.length; index++){
        if (nums[index] != val){
            break;
        }
    }
    return index;
}