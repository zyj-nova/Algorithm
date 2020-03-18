 /*
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
*/
public  int removeDuplicates(int[] nums) {
    int res = 1,i = 1;
    int index = nextDiffEle(nums,1);
    while (index < nums.length){
        res++;
        nums[i++] = nums[index];
        index = nextDiffEle(nums,index+1);
    }
    return res;
}
//函数作用：找到下一个不同于当前元素的元素
private int nextDiffEle(int nums[],int p){
    for (; p < nums.length; p++){
        if (nums[p]!=nums[p-1])
            break;
    }
    return p;
}